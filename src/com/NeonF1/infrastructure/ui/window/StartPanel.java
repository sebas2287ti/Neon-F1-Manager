package com.NeonF1.infrastructure.ui.window;

import java.awt.*;
import com.NeonF1.infrastructure.ui.components.Background;
import com.NeonF1.infrastructure.ui.components.ControlerInterface;
import com.NeonF1.infrastructure.ui.components.UiFactory;

import javax.swing.*;

public class StartPanel extends Background {
    private ControlerInterface controler;

    public StartPanel(ControlerInterface controller) {
        super("/Image/FormulaPantallaInicio.jpeg");
        this.controler = controller;

        setLayout(null);

        JButton botonHome = UiFactory.CrearBotom("⌂", 870, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton botonBuscar = UiFactory.CrearBotom("\uD83D\uDD0D", 870+ 50, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton botonFormulario = UiFactory.CrearBotom("\uD83C\uDFCE\uFE0F", 870+ 50*2, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton Boton2 = UiFactory.CrearBotom("\uD83D\uDE99", 870+ 50*3, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton BotonExit = UiFactory.CrearBotom("\uD83C\uDFC1", 870 + 50*4, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);

        add(botonHome);
        add(botonBuscar);
        add(botonFormulario);
        add(Boton2);
        add(BotonExit);

        botonHome.addActionListener(e -> controler.cambiarPanel("MenuInicio"));
        botonFormulario.addActionListener(e -> controler.cambiarPanel("Formulario") );
        botonBuscar.addActionListener(e -> controler.cambiarPanel("PantallaBuscador") );
        BotonExit.addActionListener(e -> System.exit(0));
    }
}
