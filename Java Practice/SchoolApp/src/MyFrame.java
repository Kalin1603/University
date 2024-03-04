import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Properties;

public class MyFrame extends JFrame {
    public MyFrame() {
        this.setSize(1500, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));

        //upPanel--------------------------------------
        upPanel.setLayout(new GridLayout(7, 5));
        upPanel.add(firstName);
        upPanel.add(firstNameTF);
        upPanel.add(lastName);
        upPanel.add(lastNameTF);
        upPanel.add(age);
        upPanel.add(ageTF);
        upPanel.add(dateOfBirth);
        upPanel.add(datePicker);
        upPanel.add(gender);
        upPanel.add(genderComboBox);
        upPanel.add(address);
        upPanel.add(addressTF);
        upPanel.add(city);
        upPanel.add(cityTF);
        upPanel.add(state);
        upPanel.add(stateTF);
        upPanel.add(postalCode);
        upPanel.add(postalCodeTF);
        upPanel.add(country);
        upPanel.add(countryTF);
        upPanel.add(email);
        upPanel.add(emailTF);
        upPanel.add(phone);
        upPanel.add(phoneTF);

        this.add(upPanel);


        //midPanel--------------------------------------
        midPanel.add(addButton);
        addButton.addActionListener(new AddAction());

        midPanel.add(deleteButton);
        midPanel.add(editButton);

        this.add(midPanel);

        //downPanel--------------------------------------
        myScroll.setPreferredSize(new Dimension(1300, 200));
        downPanel.add(myScroll);

        this.add(downPanel);

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


