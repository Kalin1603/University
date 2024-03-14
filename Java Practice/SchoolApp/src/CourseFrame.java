import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class CourseFrame extends JFrame {
    private Connection conn;
    private PreparedStatement statement;
    private ResultSet result;

    public CourseFrame() {
        this.setTitle("Курсове");
        this.setSize(800, 600);
        this.setLayout(new GridLayout(3, 2));

        //upPanel--------------------------------------
        this.setLayout(new GridLayout(5, 2));
        upPanel.add(courseName);
        upPanel.add(courseNameTF);
        upPanel.add(instructor);
        upPanel.add(instructorTF);
        upPanel.add(credits);
        upPanel.add(creditsTF);
        upPanel.add(description);
        upPanel.add(descriptionTF);

        this.add(upPanel);

        //midPanel--------------------------------------
        midPanel.add(addCourse);

        this.add(midPanel);

        //downPanel--------------------------------------
        myScroll.setPreferredSize(new Dimension(800, 400));
        downPanel.add(myScroll);

        this.add(downPanel);

        refreshCourseTable();

        this.setVisible(true);
    }

    //Panels
    JPanel upPanel = new JPanel();
    JPanel midPanel = new JPanel();
    JPanel downPanel = new JPanel();

    //Labels
    JLabel courseName = new JLabel("Име на курса");
    JLabel instructor = new JLabel("Инструктор");
    JLabel credits = new JLabel("Звезди");
    JLabel description = new JLabel("Описание");

    //Text fields
    JTextField courseNameTF = new JTextField();
    JTextField instructorTF = new JTextField();
    JTextField creditsTF = new JTextField();
    JTextField descriptionTF = new JTextField();

    JButton addCourse = new JButton("Добави курс");

    JTable courseTable = new JTable();
    JScrollPane myScroll = new JScrollPane(courseTable);

    public void refreshCourseTable() {
        conn = DBConnection.getConnection();
        try {
            statement = conn.prepareStatement("SELECT COURSENAME, INSTRUCTOR, CREDITS, DESCRIPTION FROM course");
            result = statement.executeQuery();
            courseTable.setModel(new MyModel(result));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
