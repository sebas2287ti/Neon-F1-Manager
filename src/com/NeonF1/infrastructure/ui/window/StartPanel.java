package com.NeonF1.infrastructure.ui.window;

import java.awt.*;
import com.NeonF1.infrastructure.ui.components.ControlerInterface;

import javax.swing.*;

public class StartPanel extends JPanel {
    private ControlerInterface controller;

    public StartPanel(ControlerInterface controller) {
        this.controller = controller;

        setLayout(null);
        setBackground(new Color(15, 15, 15));

        JButton btnHome = crearBotonIcono("⌂", 1170, 20);
        add(btnHome);


        JButton btnExit = crearBotonIcono("\uD83D\uDD0D", 1100, 20);
        add(btnExit);

        btnHome.addActionListener(e -> System.exit(0));
    }

    private JButton crearBotonIcono(String simbolo, int x, int y) {
        JButton btn = new JButton(simbolo);
        btn.setBounds(x, y, 50, 50);
        btn.setBackground(new Color(40, 40, 40));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("SansSerif", Font.BOLD, 24));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(225, 6, 0), 1)); // Borde rojo sutil

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) { btn.setBackground(new Color(225, 6, 0)); }
            public void mouseExited(java.awt.event.MouseEvent e) { btn.setBackground(new Color(40, 40, 40)); }
        });

        return btn;
    }
}
