import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Properties;

public class EnrollmentFrame extends JFrame {

    private Date previousDateOfBirth;

    public EnrollmentFrame() {
        this.setSize(1200, 700);
        this.setLayout(new GridLayout(3, 1));

        //upPanel--------------------------------------
        upPanel.setLayout(new GridLayout(4, 2));
        upPanel.add(enrollmentDate);
        upPanel.add(datePicker);
        upPanel.add(grade);
        upPanel.add(gradeTF);
        upPanel.add(studentComboBox);
        upPanel.add(courseComboBox);

        this.add(upPanel);

        //midPanel--------------------------------------
        midPanel.add(addEnrollment);
        addEnrollment.addActionListener(new AddAction());
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
        enrollmentTable.addMouseListener(new MouseAction());

        this.add(downPanel);

        downPanel.add(myScroll);
        refreshEnrollmentTable();
        refreshStudentCombo();
        refreshCourseCombo();

        this.setVisible(true);
    }

    //Panels
    JPanel upPanel = new JPanel();
    JPanel midPanel = new JPanel();
    JPanel downPanel = new JPanel();

    //Labels
    JLabel enrollmentDate = new JLabel("Дата на записване");
    JLabel grade = new JLabel("Оценка");

    //Text fields
    JTextField gradeTF = new JTextField();

    //Buttons
    JButton addEnrollment = new JButton("Добави");
    JButton deleteButton = new JButton("Изтриване");
    JButton editButton = new JButton("Редактиране");
    JButton searchBtn = new JButton("Търсене по оценка");
    JButton refreshBtn = new JButton("Обнови");

    JTable enrollmentTable = new JTable();
    JScrollPane myScroll = new JScrollPane(enrollmentTable);

    JComboBox<String> studentComboBox = new JComboBox<String>();
    JComboBox<String> courseComboBox = new JComboBox<String>();


    //Database connection
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    int id=-1;

    //Date of enrollment
    UtilDateModel model = new UtilDateModel();
    Properties properties = new Properties();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

    static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private final String datePattern = "yyyy-MM-dd";
        private final java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws java.text.ParseException {
            return dateFormat.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws java.text.ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormat.format(cal.getTime());
            }
            return "";
        }
    }

    class AddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "insert into ENROLLMENT (STUDENTID, COURSEID, ENROLLMENTDATE, GRADE ) values(?, ?, ?, ?)";
            try {
                statement = conn.prepareStatement(sql);
                java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
                java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                statement.setInt(1,Integer.parseInt(studentComboBox.getSelectedItem().toString().substring(0,studentComboBox.getSelectedItem().toString().indexOf('.'))));
                statement.setInt(2,Integer.parseInt(courseComboBox.getSelectedItem().toString().substring(0,courseComboBox.getSelectedItem().toString().indexOf('.'))));
                statement.setDate(3, sqlDate);
                statement.setDouble(4, Double.parseDouble(gradeTF.getText()));
                statement.execute();
                refreshEnrollmentTable();
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
            String sql = "UPDATE enrollment SET  ENROLLMENTDATE = ?, GRADE = ? WHERE ENROLLMENTID = ?";
            try {
                statement = conn.prepareStatement(sql);
                java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
                java.sql.Date sqlDate;
                if (selectedDate != null) {
                    sqlDate = new java.sql.Date(selectedDate.getTime());
                } else {
                    if (previousDateOfBirth != null) {
                        sqlDate = new java.sql.Date(previousDateOfBirth.getTime());
                    } else {
                        // Ако няма предишна стойност, изведете съобщение за грешка
                        System.out.println("Моля, изберете дата на записване.");
                        return;
                    }
                }
                statement.setDate(1, sqlDate);
                statement.setDouble(2, Double.parseDouble(gradeTF.getText()));
                statement.setInt(3, id);
                statement.executeUpdate();
                refreshEnrollmentTable();
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
            String sql = "delete from ENROLLMENT where ENROLLMENTID = ?";

            try {
                statement = conn.prepareStatement(sql);
                statement.setInt(1,id);
                statement.execute();
                refreshEnrollmentTable();
                refreshStudentCombo();
                refreshCourseCombo();
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
            String sql = "SELECT  E.ENROLLMENTID,S.FIRSTNAME, S.LASTNAME, C.COURSENAME, C.INSTRUCTOR, E.ENROLLMENTDATE, E.GRADE \n" +
                    "                    FROM COURSE AS C \n" +
                    "                    JOIN ENROLLMENT AS E ON E.COURSEID = C.COURSEID \n" +
                    "                    JOIN STUDENT AS S ON S.STUDENTID = E.STUDENTID WHERE GRADE = ?";
            try {
                statement = conn.prepareStatement(sql);
                statement.setDouble(1,Double.parseDouble(gradeTF.getText()));
                result = statement.executeQuery();
                enrollmentTable.setModel(new MyModel(result));
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
            refreshEnrollmentTable();
            clearForm();
        }
    }

    class MouseAction implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = enrollmentTable.getSelectedRow();
            id = Integer.parseInt(enrollmentTable.getValueAt(row, 0).toString());
            gradeTF.setText(enrollmentTable.getValueAt(row,6).toString());
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

    public void refreshEnrollmentTable() {
        conn = DBConnection.getConnection();
        try {
            statement = conn.prepareStatement("SELECT  E.ENROLLMENTID,S.FIRSTNAME, S.LASTNAME, C.COURSENAME, C.INSTRUCTOR, E.ENROLLMENTDATE, E.GRADE \n" +
                    "                    FROM COURSE AS C \n" +
                    "                    JOIN ENROLLMENT AS E ON E.COURSEID = C.COURSEID \n" +
                    "                    JOIN STUDENT AS S ON S.STUDENTID = E.STUDENTID");
            result = statement.executeQuery();
            enrollmentTable.setModel(new MyModel(result));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public void refreshCourseCombo() {
        courseComboBox.removeAllItems();
        conn = DBConnection.getConnection();
        String sql = "SELECT COURSEID, courseName, instructor, credits FROM course";
        try {
            statement = conn.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                int courseId = result.getInt("COURSEID");
                String courseName = result.getString("courseName");
                String instructor = result.getString("instructor");
                String fullCourse = courseId + "." + courseName + "-" + instructor;
                courseComboBox.addItem(fullCourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearForm() {
        datePicker.getModel().setValue(null);
        gradeTF.setText("");
    }
}
