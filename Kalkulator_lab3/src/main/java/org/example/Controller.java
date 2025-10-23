package org.example;

import javax.swing.*;
import java.awt.event.*;

public class Controller implements ActionListener {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        initListeners();
        view.setScreen(model.getDisplay());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String key = ((JButton) e.getSource()).getText();

        switch(key) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                model.appendDigit(key);
                break;
            case "/":
            case "*":
            case "-":
            case "+":
                model.applyOperator(key);
                break;
            case "=":
                model.equalsAction();
                break;
            case "<-":
                model.backspace();
                break;
            case "C":
                model.clearAll();

        }

        view.setScreen(model.getDisplay());

    }

    private void initListeners() {

        view.button_7.addActionListener(this);
        view.button_8.addActionListener(this);
        view.button_9.addActionListener(this);
        view.button_4.addActionListener(this);
        view.button_5.addActionListener(this);
        view.button_6.addActionListener(this);
        view.button_1.addActionListener(this);
        view.button_2.addActionListener(this);
        view.button_3.addActionListener(this);
        view.button_0.addActionListener(this);

        view.button_divide.addActionListener(this);
        view.button_multiply.addActionListener(this);
        view.button_subtract.addActionListener(this);
        view.button_add.addActionListener(this);

        view.button_clear.addActionListener(this);
        view.button_backspace.addActionListener(this);
        view.button_equal.addActionListener(this);
    }

}