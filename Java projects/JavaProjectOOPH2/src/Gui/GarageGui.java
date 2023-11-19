package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GarageGui extends JFrame {
    private JComboBox comboBox;
    private JButton buttonShowAll;
    private JButton buttonAdd;
    private JLabel mainLabel;
    private JPanel mainPanel;
    private JLabel labelGarageName;

    public GarageGui(){
        setContentPane(mainPanel);
        setTitle("Гараж");
        setSize(600,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCarForm addCarForm = new AddCarForm();
                addCarForm.setVisible(true);
            }
        });
        buttonShowAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowCarForm showCarForm = new ShowCarForm();
                showCarForm.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        GarageGui garageGui = new GarageGui();
    }
}
