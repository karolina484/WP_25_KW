package org.example;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JTextField screen;

    JButton button_1 = new JButton("1");
    JButton button_2 = new JButton("2");
    JButton button_3 = new JButton("3");
    JButton button_4 = new JButton("4");
    JButton button_5 = new JButton("5");
    JButton button_6 = new JButton("6");
    JButton button_7 = new JButton("7");
    JButton button_8 = new JButton("8");
    JButton button_9 = new JButton("9");
    JButton button_0 = new JButton("0");

    JButton button_backspace = new JButton("<-");
    JButton button_clear = new JButton("C");

    JButton button_add = new JButton("+");
    JButton button_subtract = new JButton("-");
    JButton button_multiply = new JButton("*");
    JButton button_divide = new JButton("/");
    JButton button_equal = new JButton("=");

    JPanel panelButtons = new JPanel(new GridLayout(5, 4));

    public View() {
        JPanel panel = new JPanel(new BorderLayout());
        screen = new JTextField(10);
        screen.setEditable(false);
        screen.setText("0");
        panel.add("North", screen);

        panelButtons.add(button_7);
        panelButtons.add(button_8);
        panelButtons.add(button_9);
        panelButtons.add(button_divide);

        panelButtons.add(button_4);
        panelButtons.add(button_5);
        panelButtons.add(button_6);
        panelButtons.add(button_multiply);

        panelButtons.add(button_1);
        panelButtons.add(button_2);
        panelButtons.add(button_3);
        panelButtons.add(button_subtract);

        panelButtons.add(button_clear);
        panelButtons.add(button_0);
        panelButtons.add(button_backspace);
        panelButtons.add(button_add);

        panelButtons.add(new JLabel());
        panelButtons.add(button_equal);

        panel.add("Center", panelButtons);
        setContentPane(panel);
        pack();
        setVisible(true);
    }

    public void setScreen(String text) {
        screen.setText(text);
    }

    public String getText() {
        return screen.getText();
    }
}