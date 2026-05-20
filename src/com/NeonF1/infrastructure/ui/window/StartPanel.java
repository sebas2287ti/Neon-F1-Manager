package com.NeonF1.infrastructure.ui.window;

import java.awt.*;
import com.NeonF1.infrastructure.ui.components.Background;
import com.NeonF1.infrastructure.ui.components.ControlerInterface;
import com.NeonF1.infrastructure.ui.components.UiFactory;

import javax.swing.*;

public class StartPanel extends Background {
    private ControlerInterface controller;

    public StartPanel(ControlerInterface controller) {
        super("/Image/FormulaPantallaInicio.jpeg");
        this.controller = controller;

        setLayout(null);

        JButton botonHome = UiFactory.CrearBotom("⌂", 870, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, new Color(225, 6, 0),Color.WHITE);
        JButton botonExit = UiFactory.CrearBotom("\uD83D\uDD0D", 920, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, new Color(225, 6, 0),Color.WHITE);
        JButton Boton1 = UiFactory.CrearBotom("\uD83C\uDFCE\uFE0F", 970, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, new Color(225, 6, 0),Color.WHITE);
        JButton Boton2 = UiFactory.CrearBotom("\uD83D\uDE99", 1020, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, new Color(225, 6, 0),Color.WHITE);
        JButton Boton3 = UiFactory.CrearBotom("\uD83C\uDFC1", 1070, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, new Color(225, 6, 0),Color.WHITE);



        add(botonHome);
        add(botonExit);
        add(Boton1);
        add(Boton2);
        add(Boton3);

        botonHome.addActionListener(e -> System.exit(0));
        botonExit.addActionListener(e -> controller.cambiarPanel("Formulario") );
    }
}
