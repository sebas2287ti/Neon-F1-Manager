package com.NeonF1;

import javax.swing.*;

import com.NeonF1.infrastructure.ui.components.ControlerInterface;

public class NeonF1Manager {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame("F1 Manager");
                window.setSize(1280, 720);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setLocationRelativeTo(null);
            window.setResizable(false);

            ControlerInterface controlador = new ControlerInterface(window);

            window.setVisible(true);
        });
    }
}
