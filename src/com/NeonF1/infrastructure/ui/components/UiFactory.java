package com.NeonF1.infrastructure.ui.components;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UiFactory {

    public static JButton CrearBotom (String simbolo, int x, int y, int w, int h, Color Background, Color Text, Color Lateral) {
        JButton Boton = new JButton();

        Boton.setBounds(x, y, w, h);
        Boton.setBackground(Background);
        Boton.setForeground(Text);
        Boton.setFont(new Font("SansSerif", Font.BOLD, 24));
        Boton.setFocusPainted(false);
        Boton.setBorder(BorderFactory.createLineBorder(Lateral));

        Boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) { Boton.setBackground(Lateral); }
            public void mouseExited(java.awt.event.MouseEvent e) { Boton.setBackground(Background); }
        });

        return Boton;
    }
}
