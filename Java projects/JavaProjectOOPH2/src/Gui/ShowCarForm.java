package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCarForm extends JFrame {
    private JComboBox comboBoxAllCars;
    private JButton buttonShowAllCars;
    private JButton buttonUpdate;
    private JButton buttonDelete;
    private JButton buttonAdd;
    private JPanel showAllCarsPanel;

    public ShowCarForm() {
    setContentPane(showAllCarsPanel);
    setTitle("Всички коли");
    setSize(400, 600);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setResizable(false);
    setVisible(true);

    buttonAdd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    buttonDelete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    buttonUpdate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    buttonShowAllCars.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });

    }

    public static void main(String[] args) {
        AddCarForm newForm = new AddCarForm();
    }
}
