package com.NeonF1.infrastructure.ui.window;

import com.NeonF1.infrastructure.ui.components.Background;
import com.NeonF1.infrastructure.ui.components.ControlerInterface;
import com.NeonF1.infrastructure.ui.components.UiFactory;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class StartPanel extends Background {
    private final ControlerInterface CONTROLER;

    //metodo para la creacion de primer panel o StartPanel
    public StartPanel(ControlerInterface controler) {
        //llamar a la clase padre para que pinte el fondo
        super("/Image/FormulaPantallaInicio.jpeg");
        this.CONTROLER = controler;

        setLayout(null);

        /*
        Creacion de los botones mediante el metodo de creacion en el UiFactory bajo la regla de creacion:
        (Icono, Cordenadas x y, Ancho, Alto, Color del fondo, Color del Icono, Color de la margen, Color del icono al pasar encima de el)
        */
        JButton homeButton = UiFactory.createButton("⌂", 870, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.red, Color.black);
        JButton findButton = UiFactory.createButton("\uD83D\uDD0D", 870 + 50, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.red, Color.black);
        JButton formButton = UiFactory.createButton("\uD83C\uDFCE", 870 + 50 * 2, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.red, Color.black);
        JButton testButton = UiFactory.createButton("\uD83D\uDE99", 870 + 50 * 3, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.red, Color.black);
        JButton exitButton = UiFactory.createButton("\uD83C\uDFC1", 870 + 50 * 4, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.red, Color.black);

        ArrayList images = new ArrayList<>();
        images.add("/Image/Pruebas.jpeg");
        images.add("/Image/NuevoPiloto.jpg");

        JPanel image = new UiFactory().imageCreate(0, 0, 300,300, images, Color.WHITE);

        //Añadir los iconos al panel para que se puedan visualizar
        add(homeButton);
        add(findButton);
        add(formButton);
        add(testButton);
        add(exitButton);
        add(image);


        //Funciones de los botones (Salir, Cambiar de panel mediante el panelChange)
        homeButton.addActionListener(_ -> this.CONTROLER.panelChange("StartPanel"));
        formButton.addActionListener(_ -> this.CONTROLER.panelChange("FormPanel") );
        findButton.addActionListener(_ -> this.CONTROLER.panelChange("FindPanel") );
        exitButton.addActionListener(_ -> System.exit(0));
    }
}
