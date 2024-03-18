import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class CourseFrame extends JFrame {

    public CourseFrame() {
        this.setSize(1200, 700);
        this.setLayout(new GridLayout(3, 1));

        //upPanel--------------------------------------
        upPanel.setLayout(new GridLayout(5, 2));
        upPanel.add(courseName);
        upPanel.add(courseNameTF);
        upPanel.add(instructor);
        upPanel.add(instructorTF);
        upPanel.add(credits);
        upPanel.add(creditsTF);
        upPanel.add(description);
        upPanel.add(descriptionTF);
        upPanel.add(studentComboBox);

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

    //Text fields
    JTextField courseNameTF = new JTextField();
    JTextField instructorTF = new JTextField();
    JTextField creditsTF = new JTextField();
    JTextField descriptionTF = new JTextField();

    //Buttons
    JButton addCourse = new JButton("Добави курс");
    JButton deleteButton = new JButton("Изтриване");
    JButton editButton = new JButton("Редактиране");
    JButton searchBtn = new JButton("Търсене по кредити");
    JButton refreshBtn = new JButton("Обнови");

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
            // TO DO
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
            String sql = "select * from course where CREDITS = ?";
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
            courseNameTF.setText(courseTable.getValueAt(row, 1).toString());
            instructorTF.setText(courseTable.getValueAt(row, 2).toString());
            creditsTF.setText(courseTable.getValueAt(row,3).toString());
            descriptionTF.setText((courseTable.getValueAt(row, 4).toString()));
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

    public void refreshCourseTable() {
        conn = DBConnection.getConnection();
        try {
            statement = conn.prepareStatement("SELECT C.COURSEID, S.STUDENTID, S.FIRSTNAME, S.LASTNAME, C.COURSENAME, C.INSTRUCTOR, C.CREDITS, C.DESCRIPTION " +
                    "FROM COURSE AS C " +
                    "JOIN ENROLLMENT AS E ON E.COURSEID = C.COURSEID " +
                    "JOIN STUDENT AS S ON S.STUDENTID = E.STUDENTID");

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
