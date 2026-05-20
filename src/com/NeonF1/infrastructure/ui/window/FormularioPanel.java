package com.NeonF1.infrastructure.ui.window;

import com.NeonF1.infrastructure.ui.components.Background;
import com.NeonF1.infrastructure.ui.components.ControlerInterface;
import com.NeonF1.infrastructure.ui.components.UiFactory;

import javax.swing.*;
import java.awt.*;

public class FormularioPanel extends Background {
    private ControlerInterface controler;

    public FormularioPanel(ControlerInterface controler) {
        super("/Image/Pruebas.jpeg");
        this.controler = controler;

        setLayout(null);


        JButton botonHome = UiFactory.CrearBotom("⌂", 60, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton botonExit = UiFactory.CrearBotom("\uD83D\uDD0D", 110, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton Boton1 = UiFactory.CrearBotom("\uD83C\uDFCE\uFE0F", 160, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton Boton2 = UiFactory.CrearBotom("\uD83D\uDE99", 210, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton Boton3 = UiFactory.CrearBotom("\uD83C\uDFC1", 260, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);

        add(botonHome);
        add(botonExit);
        add(Boton1);
        add(Boton2);
        add(Boton3);

        botonHome.addActionListener(e -> controler.cambiarPanel("MenuInicio") );
    }


}
