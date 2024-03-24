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
import java.util.Calendar;
import java.util.Properties;

public class MyFrame extends JFrame {
    private Date previousDateOfBirth;

    public MyFrame() {
        this.setSize(1500, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));

        //upPanel--------------------------------------
        upPanel.setLayout(new GridLayout(15, 3));

        upPanel.add(firstName);
        upPanel.add(firstNameTF);
        upPanel.add(new JLabel()); // Празен елемент, за да попълни мястото

        upPanel.add(lastName);
        upPanel.add(lastNameTF);
        upPanel.add(new JLabel());

        upPanel.add(age);
        upPanel.add(ageTF);
        upPanel.add(new JLabel());

        upPanel.add(dateOfBirth);
        upPanel.add(dateOfBirthTF);
        upPanel.add(datePicker);

        upPanel.add(gender);
        upPanel.add(genderComboBox);
        upPanel.add(new JLabel());

        upPanel.add(address);
        upPanel.add(addressTF);
        upPanel.add(new JLabel());

        upPanel.add(city);
        upPanel.add(cityTF);
        upPanel.add(new JLabel());

        upPanel.add(state);
        upPanel.add(stateTF);
        upPanel.add(new JLabel());

        upPanel.add(postalCode);
        upPanel.add(postalCodeTF);
        upPanel.add(new JLabel());

        upPanel.add(country);
        upPanel.add(countryTF);
        upPanel.add(new JLabel());

        upPanel.add(email);
        upPanel.add(emailTF);
        upPanel.add(new JLabel());

        upPanel.add(phone);
        upPanel.add(phoneTF);
        upPanel.add(new JLabel());

        this.add(upPanel);



        //midPanel--------------------------------------
        midPanel.add(addButton);
        addButton.addActionListener(new AddAction());

        midPanel.add(deleteButton);
        deleteButton.addActionListener(new DeleteAction());

        midPanel.add(editButton);
        editButton.addActionListener(new EditAction());

        midPanel.add(searchBtn);
        searchBtn.addActionListener(new SearchAction());

        midPanel.add(refreshBtn);
        refreshBtn.addActionListener(new RefreshAction());

        midPanel.add(courseBtn);
        midPanel.add(enrollmentBtn);
        courseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseFrame courseFrame = new CourseFrame();
            }
        });

        enrollmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnrollmentFrame enrollmentFrame = new EnrollmentFrame();
            }
        });

        this.add(midPanel);

        //downPanel--------------------------------------
        myScroll.setPreferredSize(new Dimension(1300, 200));
        downPanel.add(myScroll);

        this.add(downPanel);

        table.addMouseListener(new MouseAction());

        refreshTable();

        this.setVisible(true);
    }

    //Panels
    JPanel upPanel = new JPanel();
    JPanel midPanel = new JPanel();
    JPanel downPanel = new JPanel();

    //Labels
    JLabel firstName = new JLabel("Име");
    JLabel lastName = new JLabel("Фамилия");
    JLabel age = new JLabel("Години");
    JLabel dateOfBirth = new JLabel("Дата на раждане");
    JLabel gender = new JLabel("Пол");
    JLabel address = new JLabel("Адрес");
    JLabel city = new JLabel("Град");
    JLabel state = new JLabel("Област");
    JLabel postalCode = new JLabel("Пощенски код");
    JLabel country = new JLabel("Държава");
    JLabel email = new JLabel("Имейл");
    JLabel phone = new JLabel("Телефон");

    //Text fields
    JTextField firstNameTF = new JTextField();
    JTextField lastNameTF = new JTextField();
    JTextField ageTF = new JTextField();
    JTextField dateOfBirthTF = new JTextField();
    JTextField addressTF = new JTextField();
    JTextField cityTF = new JTextField();
    JTextField stateTF = new JTextField();
    JTextField postalCodeTF = new JTextField();
    JTextField countryTF = new JTextField();
    JTextField emailTF = new JTextField();
    JTextField phoneTF = new JTextField();

    //Gender combo box
    String[] genderInfo = {"Мъж", "Жена"};
    JComboBox<String> genderComboBox = new JComboBox<>(genderInfo);

    //Buttons
    JButton addButton = new JButton("Добавяне");
    JButton deleteButton = new JButton("Изтриване");
    JButton editButton = new JButton("Редактиране");
    JButton searchBtn = new JButton("Търсене по години");
    JButton refreshBtn = new JButton("Обнови");
    JButton courseBtn = new JButton("Курсове");
    JButton enrollmentBtn = new JButton("Записвания");
    JTable table = new JTable();
    JScrollPane myScroll = new JScrollPane(table);

    //Date of birth
    UtilDateModel model = new UtilDateModel();
    Properties properties = new Properties();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

    //Database connection
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    int id=-1;

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
            String sql = "insert into student(firstName, lastName, age, dateOfBirth, gender, address, city, state, postalCode, country, email, phone) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                statement = conn.prepareStatement(sql);
                statement.setString(1, firstNameTF.getText());
                statement.setString(2, lastNameTF.getText());
                statement.setInt(3, Integer.parseInt(ageTF.getText()));
                java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
                java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                statement.setDate(4, sqlDate);
                statement.setString(5, genderComboBox.getSelectedItem().toString());
                statement.setString(6, addressTF.getText());
                statement.setString(7, cityTF.getText());
                statement.setString(8, stateTF.getText());
                statement.setString(9, postalCodeTF.getText());
                statement.setString(10, countryTF.getText());
                statement.setString(11, emailTF.getText());
                statement.setString(12, phoneTF.getText());
                statement.execute();
                refreshTable();
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
            String sql = "UPDATE student SET firstName=?, lastName=?, age=?, dateOfBirth=?, gender=?, address=?, city=?, state=?, postalCode=?, country=?, email=?, phone=? WHERE STUDENTID=?";
            try {
                statement = conn.prepareStatement(sql);
                statement.setString(1, firstNameTF.getText());
                statement.setString(2, lastNameTF.getText());
                statement.setInt(3, Integer.parseInt(ageTF.getText()));

                // Проверка за избрана нова дата на раждане
                java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
                java.sql.Date sqlDate;
                if (selectedDate != null) {
                    // Ако е избрана нова дата, използвайте я
                    sqlDate = new java.sql.Date(selectedDate.getTime());
                } else {
                    // Ако не е избрана нова дата, използвайте предишната стойност
                    // Предполагаме, че сте съхранявали предишната дата в променлива previousDateOfBirth
                    if (previousDateOfBirth != null) {
                        sqlDate = new java.sql.Date(previousDateOfBirth.getTime());
                    } else {
                        // Ако няма предишна стойност, изведете съобщение за грешка
                        System.out.println("Моля, изберете дата на раждане.");
                        return;
                    }
                }
                statement.setDate(4, sqlDate);

                statement.setString(5, genderComboBox.getSelectedItem().toString());
                statement.setString(6, addressTF.getText());
                statement.setString(7, cityTF.getText());
                statement.setString(8, stateTF.getText());
                statement.setString(9, postalCodeTF.getText());
                statement.setString(10, countryTF.getText());
                statement.setString(11, emailTF.getText());
                statement.setString(12, phoneTF.getText());
                statement.setInt(13, id);
                statement.executeUpdate();
                refreshTable();
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
            String sql = "delete from student where STUDENTID = ?";

            try {
                statement = conn.prepareStatement(sql);
                statement.setInt(1,id);
                statement.execute();
                refreshTable();
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
            String sql = "select * from student where age = ?";
            try {
                statement = conn.prepareStatement(sql);
                statement.setInt(1,Integer.parseInt(ageTF.getText()));
                result = statement.executeQuery();
                table.setModel(new MyModel(result));
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


            refreshTable();
            clearForm();
        }
    }

    class MouseAction implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = table.getSelectedRow();
            id = Integer.parseInt(table.getValueAt(row,0).toString());
            firstNameTF.setText(table.getValueAt(row, 1).toString());
            lastNameTF.setText(table.getValueAt(row, 2).toString());
            ageTF.setText(table.getValueAt(row,12).toString());
            dateOfBirthTF.setText(table.getValueAt(row,3).toString());
            addressTF.setText((table.getValueAt(row, 5).toString()));
            cityTF.setText((table.getValueAt(row, 6).toString()));
            stateTF.setText((table.getValueAt(row, 7).toString()));
            postalCodeTF.setText((table.getValueAt(row, 8).toString()));
            countryTF.setText((table.getValueAt(row, 9).toString()));
            emailTF.setText((table.getValueAt(row, 10).toString()));
            phoneTF.setText((table.getValueAt(row, 11).toString()));
            if(table.getValueAt(row, 4).toString().equals("Мъж")){
                genderComboBox.setSelectedIndex(0);
            }
            else {
                genderComboBox.setSelectedIndex(1);
            }
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

    public void refreshTable() {
        conn=DBConnection.getConnection();

        try {
            statement=conn.prepareStatement("select * from student");
            result=statement.executeQuery();
            table.setModel(new MyModel(result));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void clearForm() {
        firstNameTF.setText("");
        lastNameTF.setText("");
        ageTF.setText("");
        dateOfBirthTF.setText("");
        addressTF.setText("");
        cityTF.setText("");
        stateTF.setText("");
        postalCodeTF.setText("");
        countryTF.setText("");
        emailTF.setText("");
        phoneTF.setText("");
        datePicker.getModel().setValue(null);
        genderComboBox.setSelectedIndex(0);
    }


}


