package Gui;

import Models.Car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCarForm extends JFrame {
    private JComboBox carComboBox;
    private JTextField textFieldRegNumber;
    private JTextField textFieldBrand;
    private JTextField textFieldModel;
    private JButton buttonShowAll;
    private JButton buttonUpdate;
    private JButton buttonDelete;
    private JButton buttonAdd;
    private JLabel labelGarageName;
    private JLabel labelBrand;
    private JLabel labelModel;
    private JLabel labelRegNumber;
    private JPanel carMainPanel;

    public AddCarForm() {
        setContentPane(carMainPanel);
        setTitle("Добавяне на нова кола");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String regNum = textFieldRegNumber.getText();
                String brand = textFieldBrand.getText();
                String model = textFieldModel.getText();
            }
        });

    }

    public static void main(String[] args) {
        AddCarForm newForm = new AddCarForm();
    }
}
