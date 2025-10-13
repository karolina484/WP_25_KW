package org.example;

import javax.swing.JButton; // przyciski
import javax.swing.JFrame; // okienko aplikacji
import javax.swing.JLabel; // etykiety
import javax.swing.JPanel; // panele
import javax.swing.JTextField; // jako ekran

import java.awt.BorderLayout; // menadżer rozkładu, rozmieszcza komponenty w kierunkach świata (5 el.)
import java.awt.EventQueue; // kolejka zdarzeń, żeby bezproblemowo obsługiwać aplikacje okienkowe
import java.awt.GridLayout; // menedżer rozkładu - prostokątna siatka, można zagnieździć
import java.awt.event.ActionListener; // słuchacz akcji - reakcja na wciskanie przycisków
import java.awt.event.ActionEvent;

public class App extends JFrame
{
    private JTextField screen; // pole tekstowe pełniące rolę wyświetlacza

    private JButton button_1 = new JButton("1");
    private JButton button_2 = new JButton("2");
    private JButton button_3 = new JButton("3");
    private JButton button_4 = new JButton("4");
    private JButton button_5 = new JButton("5");
    private JButton button_6 = new JButton("6");
    private JButton button_7 = new JButton("7");
    private JButton button_8 = new JButton("8");
    private JButton button_9 = new JButton("9");
    private JButton button_0 = new JButton("0");

    private JButton button_backspace = new JButton("<-");
    private JButton button_clear = new JButton("C");

    private JButton button_add = new JButton("+");
    private JButton button_subtract = new JButton("-");
    private JButton button_multiply = new JButton("*");
    private JButton button_divide = new JButton("/");
    private JButton button_equal = new JButton("=");

    private double num1;
    private double num2;
    private double result;
    private char oper = '\0';

    private boolean firstEntered = false;
    private boolean justCalculated = false;

    public App() {
        JPanel panel = new JPanel(new BorderLayout());
        screen = new JTextField(10);
        screen.setEditable(false);
        screen.setText("0");
        panel.add("North", screen);
        JPanel panelButtons = new JPanel(new GridLayout(5, 4));
        // menadżer rozkładu z 5 wierszami i 4 kolumnami

        // istotna kolejność dodawania komponentów

        button_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isNumeric(screen.getText())) {
                    screen.setText("7");
                    justCalculated = false;
                    return;
                }
                if (justCalculated || screen.getText().equals("0")) {
                    screen.setText("7");
                    justCalculated = false;
                } else {
                    screen.setText(screen.getText() + "7");
                }
            }
        });
        panelButtons.add(button_7);

        button_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isNumeric(screen.getText())) {
                    screen.setText("8");
                    justCalculated = false;
                    return;
                }
                if (justCalculated || screen.getText().equals("0")) {
                    screen.setText("8");
                    justCalculated = false;
                } else {
                    screen.setText(screen.getText() + "8");
                }
            }
        });
        panelButtons.add(button_8);

        button_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isNumeric(screen.getText())) {
                    screen.setText("9");
                    justCalculated = false;
                    return;
                }
                if (justCalculated || screen.getText().equals("0")) {
                    screen.setText("9");
                    justCalculated = false;
                } else {
                    screen.setText(screen.getText() + "9");
                }
            }
        });
        panelButtons.add(button_9);

        button_divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = screen.getText();
                if (!isNumeric(text)) {
                    return;
                }
                if (firstEntered && justCalculated) {
                    oper = '/';
                    return;
                }
                if (firstEntered) {
                    num2 = Double.parseDouble(text);
                    switch (oper) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            if (num2 == 0) {
                                screen.setText("Nie można dzielić przez 0");
                                firstEntered = false;
                                oper = '\0';
                                justCalculated = true;
                                return;
                            }
                            result = num1 / num2;
                            break;
                    }
                    num1 = result;
                    if (Math.floor(result) == result) {
                        screen.setText(String.valueOf((int) result));
                    } else {
                        screen.setText(String.valueOf(result));
                    }
                    justCalculated = true;
                } else {
                    num1 = Double.parseDouble(text);
                    firstEntered = true;
                    justCalculated = true;
                }
                oper = '/';
            }
        });
        panelButtons.add(button_divide);

        button_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isNumeric(screen.getText())) {
                    screen.setText("4");
                    justCalculated = false;
                    return;
                }
                if (justCalculated || screen.getText().equals("0")) {
                    screen.setText("4");
                    justCalculated = false;
                } else {
                    screen.setText(screen.getText() + "4");
                }
            }
        });
        panelButtons.add(button_4);

        button_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isNumeric(screen.getText())) {
                    screen.setText("5");
                    justCalculated = false;
                    return;
                }
                if (justCalculated || screen.getText().equals("0")) {
                    screen.setText("5");
                    justCalculated = false;
                } else {
                    screen.setText(screen.getText() + "5");
                }
            }
        });
        panelButtons.add(button_5);

        button_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isNumeric(screen.getText())) {
                    screen.setText("6");
                    justCalculated = false;
                    return;
                }
                if (justCalculated || screen.getText().equals("0")) {
                    screen.setText("6");
                    justCalculated = false;
                } else {
                    screen.setText(screen.getText() + "6");
                }
            }
        });
        panelButtons.add(button_6);

        button_multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = screen.getText();
                if (!isNumeric(text)) {
                    return;
                }
                if (firstEntered && justCalculated) {
                    oper = '*';
                    return;
                }
                if (firstEntered) {
                    num2 = Double.parseDouble(text);
                    switch (oper) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            if (num2 == 0) {
                                screen.setText("Nie można dzielić przez 0");
                                firstEntered = false;
                                oper = '\0';
                                justCalculated = true;
                                return;
                            }
                            result = num1 / num2;
                            break;
                    }
                    num1 = result;
                    if (Math.floor(result) == result) {
                        screen.setText(String.valueOf((int) result));
                    } else {
                        screen.setText(String.valueOf(result));
                    }
                    justCalculated = true;
                } else {
                    num1 = Double.parseDouble(text);
                    firstEntered = true;
                    justCalculated = true;
                }
                oper = '*';
            }
        });
        panelButtons.add(button_multiply);

        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isNumeric(screen.getText())) {
                    screen.setText("1");
                    justCalculated = false;
                    return;
                }
                if (justCalculated || screen.getText().equals("0")) {
                    screen.setText("1");
                    justCalculated = false;
                } else {
                    screen.setText(screen.getText() + "1");
                }
            }
        });
        panelButtons.add(button_1);

        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isNumeric(screen.getText())) {
                    screen.setText("2");
                    justCalculated = false;
                    return;
                }
                if (justCalculated || screen.getText().equals("0")) {
                    screen.setText("2");
                    justCalculated = false;
                } else {
                    screen.setText(screen.getText() + "2");
                }
            }
        });
        panelButtons.add(button_2);

        button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isNumeric(screen.getText())) {
                    screen.setText("3");
                    justCalculated = false;
                    return;
                }
                if (justCalculated || screen.getText().equals("0")) {
                    screen.setText("3");
                    justCalculated = false;
                } else {
                    screen.setText(screen.getText() + "3");
                }
            }
        });
        panelButtons.add(button_3);

        button_subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = screen.getText();
                if (!isNumeric(text)) {
                    return;
                }
                if (firstEntered && justCalculated) {
                    oper = '-';
                    return;
                }
                if (firstEntered) {
                    num2 = Double.parseDouble(text);
                    switch (oper) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            if (num2 == 0) {
                                screen.setText("Nie można dzielić przez 0");
                                firstEntered = false;
                                oper = '\0';
                                justCalculated = true;
                                return;
                            }
                            result = num1 / num2;
                            break;
                    }
                    num1 = result;
                    if (Math.floor(result) == result) {
                        screen.setText(String.valueOf((int) result));
                    } else {
                        screen.setText(String.valueOf(result));
                    }
                    justCalculated = true;
                } else {
                    num1 = Double.parseDouble(text);
                    firstEntered = true;
                    justCalculated = true;
                }
                oper = '-';
            }
        });
        panelButtons.add(button_subtract);

        button_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen.setText("0");
                num1 = 0;
                num2 = 0;
                result = 0;
                firstEntered = false;
                oper = '\0';
                justCalculated = false;
            }
        });
        panelButtons.add(button_clear);

        button_0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isNumeric(screen.getText())) {
                    screen.setText("0");
                    justCalculated = false;
                    return;
                }
                if (justCalculated || screen.getText().equals("0")) {
                    screen.setText("0");
                    justCalculated = false;
                } else {
                    screen.setText(screen.getText() + "0");
                }
            }
        });
        panelButtons.add(button_0);

        button_backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = screen.getText();
                if (!isNumeric(text)) {
                    screen.setText("0");
                    justCalculated = false;
                    return;
                }
                if (text.length() > 1) {
                    String after = text.substring(0, text.length() - 1);
                    if (after.endsWith(".")) {
                        after = after.substring(0, after.length() - 1);
                    }
                    if (after.isEmpty() || after.equals("-")) {
                        screen.setText("0");
                    } else {
                        screen.setText(after);
                    }
                } else {
                    screen.setText("0");
                }

                justCalculated = false;
            }
        });
        panelButtons.add(button_backspace);

        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = screen.getText();
                if (!isNumeric(text)) {
                    return;
                }
                if (firstEntered && justCalculated) {
                    oper = '+';
                    return;
                }
                if (firstEntered) {
                    num2 = Double.parseDouble(text);
                    switch (oper) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            if (num2 == 0) {
                                screen.setText("Nie można dzielić przez 0");
                                firstEntered = false;
                                oper = '\0';
                                justCalculated = true;
                                return;
                            }
                            result = num1 / num2;
                            break;
                    }
                    num1 = result;
                    if (Math.floor(result) == result) {
                        screen.setText(String.valueOf((int) result));
                    } else {
                        screen.setText(String.valueOf(result));
                    }
                    justCalculated = true;
                } else {
                    num1 = Double.parseDouble(text);
                    firstEntered = true;
                    justCalculated = true;
                }
                oper = '+';
            }
        });
        panelButtons.add(button_add);

        panelButtons.add(new JLabel());
        // panelButtons.add(new JLabel());
        // panelButtons.add(new JLabel());

        button_equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = screen.getText();
                if (!isNumeric(text)) {
                    return;
                }
                if (firstEntered && justCalculated) {
                    return;
                }
                if (firstEntered) {
                    num2 = Double.parseDouble(text);

                    switch (oper) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            if (num2 == 0) {
                                screen.setText("Nie można dzielić przez 0");
                                firstEntered = false;
                                oper = '\0';
                                justCalculated = true;
                                return;
                            }
                            result = num1 / num2;
                            break;
                    }

                    if (Math.floor(result) == result) {
                        screen.setText(String.valueOf((int) result));
                    } else {
                        screen.setText(String.valueOf(result));
                    }

                    num1 = result;
                    firstEntered = false;
                    oper = '\0';
                    justCalculated = true;
                }
            }
        });
        panelButtons.add(button_equal);

        panel.add("Center", panelButtons); // wstawienie panelu z przyciskami
        setContentPane(panel); // ustawienie głównego panelu aplikacji
        pack(); // dopasowanie rozmiaru okienka aplikacji do zawartości
        setVisible(true); // wyświetla okno aplikacji na ekranie
    }

    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}
