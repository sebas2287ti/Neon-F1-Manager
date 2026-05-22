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

public class BuscadorPanel extends Background {
    private ControlerInterface controler;
    private Map<String, JComponent> componentesBuscador;

    public BuscadorPanel(ControlerInterface controler) {

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

        componentesBuscador = UiFactory.CrearFormularioInteligente(this, campos, 22, 80, 400, 520, piloto -> {

            List<PilotF1> resultados = PilotF1DAO.BuscarPilotF1(piloto);

            JOptionPane.showMessageDialog(this, "Se encontraron " + resultados.size() + " pilotos.");

        });

        JButton botonHome = UiFactory.CrearBotom("⌂", 60, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton botonBuscar = UiFactory.CrearBotom("\uD83D\uDD0D", 110, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton Boton1 = UiFactory.CrearBotom("\uD83C\uDFCE\uFE0F", 160, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton Boton2 = UiFactory.CrearBotom("\uD83D\uDE99", 210, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton Boton3 = UiFactory.CrearBotom("\uD83C\uDFC1", 260, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);

        add(botonHome);
        add(botonBuscar);
        add(Boton1);
        add(Boton2);
        add(Boton3);

        botonHome.addActionListener(e -> controler.cambiarPanel("MenuInicio"));
    }
}