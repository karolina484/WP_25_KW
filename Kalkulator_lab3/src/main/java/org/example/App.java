package org.example;

import java.awt.EventQueue;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
                View view = new View();
                new Controller(model, view);
            }
        });
    }
}