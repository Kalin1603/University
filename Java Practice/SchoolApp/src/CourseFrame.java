import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class CourseFrame extends JFrame {

    public CourseFrame() {
        this.setSize(1500, 900);
        this.setLayout(new GridLayout(3, 1));

        //upPanel--------------------------------------
        upPanel.setLayout(new GridLayout(15, 3));
        upPanel.add(courseName);
        upPanel.add(courseNameTF);
        upPanel.add(instructor);
        upPanel.add(instructorTF);
        upPanel.add(credits);
        upPanel.add(creditsTF);
        upPanel.add(description);
        upPanel.add(descriptionTF);
        upPanel.add(studentComboBox);
        upPanel.add(criteria1);
        upPanel.add(criteria1TF);
        upPanel.add(criteria2);
        upPanel.add(criteria2TF);

        this.add(upPanel);

        //midPanel--------------------------------------
        midPanel.add(addCourse);
        addCourse.addActionListener(new AddAction());
        midPanel.add(deleteButton);
        deleteButton.addActionListener(new DeleteAction());
        midPanel.add(editButton);
        editButton.addActionListener(new EditAction());
        midPanel.add(searchBtn);
        searchBtn.addActionListener(new SearchAction());
        midPanel.add(refreshBtn);
        refreshBtn.addActionListener(new RefreshAction());
        midPanel.add(searchBtnMultipleCriteria);
        searchBtnMultipleCriteria.addActionListener(new SearchAction());

        this.add(midPanel);

        //downPanel--------------------------------------
        downPanel.setLayout(new BorderLayout());
        myScroll.setPreferredSize(new Dimension(900, 600));
        downPanel.add(myScroll);
        courseTable.addMouseListener(new MouseAction());

        this.add(downPanel);

        refreshCourseTable();
        refreshStudentCombo();

        this.setVisible(true);
    }

    //Panels
    JPanel upPanel = new JPanel();
    JPanel midPanel = new JPanel();
    JPanel downPanel = new JPanel();

    //Labels
    JLabel courseName = new JLabel("Име на курса");
    JLabel instructor = new JLabel("Инструктор");
    JLabel credits = new JLabel("Кредити");
    JLabel description = new JLabel("Описание");
    JLabel criteria1 = new JLabel("Първи критерий");
    JLabel criteria2 = new JLabel("Втори критерий");

    //Text fields
    JTextField courseNameTF = new JTextField();
    JTextField instructorTF = new JTextField();
    JTextField creditsTF = new JTextField();
    JTextField descriptionTF = new JTextField();
    JTextField criteria1TF = new JTextField();
    JTextField criteria2TF = new JTextField();

    //Buttons
    JButton addCourse = new JButton("Добави курс");
    JButton deleteButton = new JButton("Изтриване");
    JButton editButton = new JButton("Редактиране");
    JButton searchBtn = new JButton("Търсене по кредити");
    JButton refreshBtn = new JButton("Обнови");
    JButton searchBtnMultipleCriteria = new JButton("Търсене по повече от един критерий");

    JTable courseTable = new JTable();
    JScrollPane myScroll = new JScrollPane(courseTable);


    JComboBox<String> studentComboBox = new JComboBox<String>();

    //Database connection
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    int id=-1;

    class AddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO course(courseName, instructor, credits, description) VALUES(?, ?, ?, ?)";
            try {
                statement = conn.prepareStatement(sql);
                statement.setString(1, courseNameTF.getText());
                statement.setString(2, instructorTF.getText());
                statement.setInt(3, Integer.parseInt(creditsTF.getText()));
                statement.setString(4, descriptionTF.getText());
                statement.executeUpdate();

                refreshCourseTable();
                clearForm();

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
    }

    class EditAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "UPDATE course SET courseName=?, instructor=?, credits=?, description=? WHERE COURSEID = ?";
            try {
                statement = conn.prepareStatement(sql);
                statement.setString(1, courseNameTF.getText());
                statement.setString(2, instructorTF.getText());
                statement.setInt(3, Integer.parseInt(creditsTF.getText()));
                statement.setString(4, descriptionTF.getText());
                statement.setInt(5, id);
                statement.executeUpdate();
                refreshCourseTable();
                clearForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
    }

    class DeleteAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "delete from course where COURSEID = ?";

            try {
                statement = conn.prepareStatement(sql);
                statement.setInt(1,id);
                statement.execute();
                refreshCourseTable();
                refreshStudentCombo();
                clearForm();
                id=-1;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class SearchAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();

            if (e.getSource() == searchBtn) {
                searchBySingleCriteria();
            } else if (e.getSource() == searchBtnMultipleCriteria) {
                searchByMultipleCriteria();
            }
        }
    }

    class RefreshAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            refreshCourseTable();
            clearForm();
        }
    }

    class MouseAction implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = courseTable.getSelectedRow();
            id = Integer.parseInt(courseTable.getValueAt(row, 0).toString());
            courseNameTF.setText(courseTable.getValueAt(row, 3).toString());
            instructorTF.setText(courseTable.getValueAt(row, 4).toString());
            creditsTF.setText(courseTable.getValueAt(row,5).toString());
            descriptionTF.setText((courseTable.getValueAt(row, 6).toString()));
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private void searchBySingleCriteria() {
        String sql = "SELECT  C.COURSEID,S.FIRSTNAME, S.LASTNAME, C.COURSENAME, C.INSTRUCTOR, C.CREDITS, C.DESCRIPTION \n" +
                "                    FROM COURSE AS C \n" +
                "                    JOIN ENROLLMENT AS E ON E.COURSEID = C.COURSEID \n" +
                "                    JOIN STUDENT AS S ON S.STUDENTID = E.STUDENTID WHERE CREDITS = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1,Integer.parseInt(creditsTF.getText()));
            result = statement.executeQuery();
            courseTable.setModel(new MyModel(result));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void searchByMultipleCriteria() {
        try {
            String sql = "SELECT  C.COURSEID,S.FIRSTNAME, S.LASTNAME, C.COURSENAME, C.INSTRUCTOR, C.CREDITS, C.DESCRIPTION \n" +
                    "                    FROM COURSE AS C \n" +
                    "                    JOIN ENROLLMENT AS E ON E.COURSEID = C.COURSEID \n" +
                    "                    JOIN STUDENT AS S ON S.STUDENTID = E.STUDENTID WHERE S.FIRSTNAME = ? AND C.COURSENAME = ?";

            statement = conn.prepareStatement(sql);
            statement.setString(1, criteria1TF.getText());
            statement.setString(2, criteria2TF.getText());
            result = statement.executeQuery();
            courseTable.setModel(new MyModel(result));
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public void refreshCourseTable() {
        conn = DBConnection.getConnection();
        try {
            statement = conn.prepareStatement("SELECT  C.COURSEID,S.FIRSTNAME, S.LASTNAME, C.COURSENAME, C.INSTRUCTOR, C.CREDITS, C.DESCRIPTION \n" +
                    "                    FROM COURSE AS C \n" +
                    "                    JOIN ENROLLMENT AS E ON E.COURSEID = C.COURSEID \n" +
                    "                    JOIN STUDENT AS S ON S.STUDENTID = E.STUDENTID");

            result = statement.executeQuery();
            courseTable.setModel(new MyModel(result));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void clearForm() {
        courseNameTF.setText("");
        instructorTF.setText("");
        creditsTF.setText("");
        descriptionTF.setText("");
        criteria1TF.setText("");
        criteria2TF.setText("");
    }

    public void refreshStudentCombo() {
        studentComboBox.removeAllItems();
        conn = DBConnection.getConnection();
        String sql = "SELECT STUDENTID, firstName, lastName FROM student";
        try {
            statement = conn.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                int studentId = result.getInt("STUDENTID");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String fullName = studentId + "." + firstName + " " + lastName;
                studentComboBox.addItem(fullName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
