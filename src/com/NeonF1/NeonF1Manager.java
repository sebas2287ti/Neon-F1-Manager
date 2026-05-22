package com.NeonF1;

import com.NeonF1.infrastructure.ui.components.ControlerInterface;

import javax.swing.*;

public class NeonF1Manager {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            //Creacion de la ventana JFrame
            JFrame windowMain = new JFrame("F1 Manager");
            windowMain.setSize(1280, 720);
            windowMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windowMain.setLocationRelativeTo(null);
            windowMain.setResizable(false);

            //Iniciar el controlador de todos los paneles dentro de la ventana principal
            ControlerInterface controler = new ControlerInterface(windowMain);

            windowMain.setVisible(true);
        });
    }
}
