package com.NeonF1.infrastructure.ui.window;

import com.NeonF1.domain.entities.PilotF1;
import com.NeonF1.domain.DAO.PilotF1DAO;
import com.NeonF1.infrastructure.ui.components.Background;
import com.NeonF1.infrastructure.ui.components.ControlerInterface;
import com.NeonF1.infrastructure.ui.components.UiFactory;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindPanel extends Background {
    private ControlerInterface controler;
    private Map<String, JComponent> componentesBuscador;
    private JScrollPane tablaScrollActual = null;

    public FindPanel(ControlerInterface controler) {
        //llamar a la clase padre para que pinte el fondo
        super("/Image/Pruebas.jpeg");
        this.controler = controler;

        setLayout(null);


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

        componentesBuscador = UiFactory.CrearFormularioInteligente(this, campos, 22, 180, 400, 420,"Buscar", piloto -> {

            List<PilotF1> resultados = PilotF1DAO.BuscarPilotF1(piloto);

            if (tablaScrollActual != null) {
                remove(tablaScrollActual);
            }

            tablaScrollActual = UiFactory.createTable(resultados, 440, 350, 798, 248);

            add(tablaScrollActual);
            revalidate();
            repaint();
            JOptionPane.showMessageDialog(this, "Se encontraron " + resultados.size() + " pilotos.");

        });

        JButton botonHome = UiFactory.createButton("⌂", 60, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton botonBuscar = UiFactory.createButton("\uD83D\uDD0D", 110, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton botonFormulario = UiFactory.createButton("\uD83C\uDFCE\uFE0F", 160, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton Boton2 = UiFactory.createButton("\uD83D\uDE99", 210, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton BotonExit = UiFactory.createButton("\uD83C\uDFC1", 260, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);

        add(botonHome);
        add(botonBuscar);
        add(botonFormulario);
        add(Boton2);
        add(BotonExit);

        botonHome.addActionListener(e -> controler.panelChange("StartPanel"));
        botonFormulario.addActionListener(e -> controler.panelChange("FormPanel") );
        botonBuscar.addActionListener(e -> controler.panelChange("FindPanel") );
        BotonExit.addActionListener(e -> System.exit(0));
    }
}