package com.NeonF1.infrastructure.ui.window;

import com.NeonF1.domain.entities.PilotF1;
import com.NeonF1.domain.DAO.PilotF1DAO;
import com.NeonF1.infrastructure.ui.components.Background;
import com.NeonF1.infrastructure.ui.components.ControlerInterface;
import com.NeonF1.infrastructure.ui.components.UiFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindPanel extends Background {
    private ControlerInterface controler;
    private Map<String, JComponent> componentesBuscador;
    private JScrollPane tablaScrollActual = null;

    //Metodo el cual fabrica el Jpanel encargado del buscador
    public FindPanel(ControlerInterface controler) {
        //llamar a la clase padre para que pinte el fondo
        super("/Image/Base/Buscador.jpg");
        this.controler = controler;

        setLayout(null);

        //Creacion del map al cual se le definiran las columnas de nuestra Base de datos y los respectivos datos que estas reciben para la tabla
        Map<String, Class<?>> campos = new LinkedHashMap<>();
        campos.put("id", Integer.class);
        campos.put("año", Integer.class);
        campos.put("equipo", String.class);
        campos.put("nombre", String.class);
        campos.put("n_Piloto", Integer.class);
        campos.put("pilotoPrincipal", Boolean.class);
        campos.put("ganadorMundial", Boolean.class);
        campos.put("posicionCampeonato", Integer.class);
        campos.put("puntosCampeonato", Integer.class);
        campos.put("victorias", Integer.class);
        campos.put("poles", Integer.class);
        campos.put("N_campeonatos", Integer.class);
        campos.put("total_Carreras", Integer.class);

        //La creacion del formulario con el metodo el cual incluye el boton y el guardado de los datos directamente un objecto el cual tiene todos los datos del formualrio
        componentesBuscador = UiFactory.CrearFormularioInteligente(this, campos, 28, 180, 388, 420,"Buscar", piloto -> {

            //Se procede a crear la lista la cual contendra todos los resultados devuelvos por el motodo BuscarPilotF1
            List<PilotF1> resultados = PilotF1DAO.BuscarPilotF1(piloto);

            //Eliminacion de seguridad de tablas anteriores
            if (tablaScrollActual != null) {
                remove(tablaScrollActual);
            }

            //Creacion de la tabla la cual contendra todo los resultados devuelvos por la base de datos
            tablaScrollActual = UiFactory.createTable(resultados, 440, 350, 798, 248);

            //Se agrega la tabla actual y se revalida y se repinta
            add(tablaScrollActual);
            revalidate();
            repaint();

            //Mensaje que informa la cantidad de pilotos que se encontraron con un size a la lista
            JOptionPane.showMessageDialog(this, "Se encontraron " + resultados.size() + " pilotos.");

        });

        //Creacion de la listas de imagenes (Pilotos 1 y 2, Circuitos)
        ArrayList imagePilots1 = new ArrayList<>();
        imagePilots1.add("/Image/Pilots/AA.png");
        imagePilots1.add("/Image/Pilots/CL.png");
        imagePilots1.add("/Image/Pilots/CS.png");
        imagePilots1.add("/Image/Pilots/DR.png");
        imagePilots1.add("/Image/Pilots/EO.png");
        imagePilots1.add("/Image/Pilots/FA.png");
        imagePilots1.add("/Image/Pilots/GR.png");
        imagePilots1.add("/Image/Pilots/GZ.png");
        imagePilots1.add("/Image/Pilots/KM.png");
        imagePilots1.add("/Image/Pilots/LH.png");

        ArrayList imagePilots2 = new ArrayList<>();
        imagePilots2.add("/Image/Pilots/LN.png");
        imagePilots2.add("/Image/Pilots/LS.png");
        imagePilots2.add("/Image/Pilots/LSA.png");
        imagePilots2.add("/Image/Pilots/MV.png");
        imagePilots2.add("/Image/Pilots/OP.png");
        imagePilots2.add("/Image/Pilots/PG.png");
        imagePilots2.add("/Image/Pilots/SP.png");
        imagePilots2.add("/Image/Pilots/VB.png");
        imagePilots2.add("/Image/Pilots/YT.png");

        ArrayList imageCircuits = new ArrayList<>();
        imageCircuits.add("/Image/F1Moments/1.jpg");
        imageCircuits.add("/Image/F1Moments/2.jpg");
        imageCircuits.add("/Image/F1Moments/3.jpg");
        imageCircuits.add("/Image/F1Moments/4.jpg");
        imageCircuits.add("/Image/F1Moments/5.jpg");
        imageCircuits.add("/Image/F1Moments/6.jpg");
        imageCircuits.add("/Image/F1Moments/7.jpg");
        imageCircuits.add("/Image/F1Moments/8.jpg");
        imageCircuits.add("/Image/F1Moments/9.jpg");
        imageCircuits.add("/Image/F1Moments/10.jpg");


        //Creacion de todas los carruseles de imagenes
        JPanel imagesCircuits = new UiFactory().imageCreate(850, 87, 383,244, imageCircuits);
        JPanel imagesPilots1 = new UiFactory().imageCreate(440, 90, 180,240, imagePilots1);
        JPanel imagesPilots2 = new UiFactory().imageCreate(645, 90, 180,240, imagePilots2);

        //Se Agregan todos los Jpanel que contienes los carruseles de imagenes
        add(imagesCircuits);
        add(imagesPilots2);
        add(imagesPilots1);

        /*
        Creacion de los botones mediante el metodo de creacion en el UiFactory bajo la regla de creacion:
        (Icono, Cordenadas x y, Ancho, Alto, Color del fondo, Color del Icono, Color de la margen, Color del icono al pasar encima de el)
        */
        JButton botonHome = UiFactory.createButton("⌂", 60, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton botonBuscar = UiFactory.createButton("\uD83D\uDD0D", 110, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton botonFormulario = UiFactory.createButton("\uD83C\uDFCE\uFE0F", 160, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton Boton2 = UiFactory.createButton("\uD83D\uDE99", 210, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton BotonExit = UiFactory.createButton("\uD83C\uDFC1", 260, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);

        //Añadir los iconos al panel para que se puedan visualizar
        add(botonHome);
        add(botonBuscar);
        add(botonFormulario);
        add(Boton2);
        add(BotonExit);

        //Funciones de los botones (Salir, Cambiar de panel mediante el panelChange)
        botonHome.addActionListener(e -> controler.panelChange("StartPanel"));
        botonFormulario.addActionListener(e -> controler.panelChange("FormPanel") );
        botonBuscar.addActionListener(e -> controler.panelChange("FindPanel") );
        BotonExit.addActionListener(e -> System.exit(0));
    }
}