package com.NeonF1.infrastructure.ui.components;
import com.NeonF1.domain.entities.PilotF1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.tools.FileObject;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class UiFactory {

    public static JButton CrearBotom(String simbolo, int x, int y, int w, int h, Color Background, Color Text, Color Lateral, Color Text2) {
        JButton Boton = new JButton(simbolo);

        Boton.setBounds(x, y, w, h);
        Boton.setBackground(Background);
        Boton.setForeground(Text);
        Boton.setFont(new Font("SansSerif", Font.BOLD, 24));
        Boton.setFocusPainted(false);
        Boton.setBorder(BorderFactory.createLineBorder(Lateral, 1));

        Boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                Boton.setBackground(Lateral);
                Boton.setForeground(Text2);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                Boton.setBackground(Background);
                Boton.setForeground(Text);
            }
        });

        return Boton;
    }

    public static Map<String, JComponent> CrearFormularioInteligente(JPanel panel, Map<String, Class<?>> campos, int x, int y, int w, int h, Consumer<PilotF1> alGuardar) {
        Map<String, JComponent> componentesFormulario = new HashMap<>();
        JPanel contenedor = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(30, 32, 43, 220));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            }
        };
        contenedor.setOpaque(false);
        contenedor.setBounds(x, y, w, h);
        contenedor.setLayout(null);

        int margenIzquierdo = 20;
        int margenSuperior = 20;
        int altoComponente = 22;
        int espaciado = 27;

        Font fuenteLabel = new Font("Arial", Font.BOLD, 12);
        Font fuenteComponentes = new Font("Arial", Font.PLAIN, 12);

        int anchoDisponible = w - (margenIzquierdo * 2);
        int anchoLabel = (int) (anchoDisponible * 0.45);
        int anchoComponente = (int) (anchoDisponible * 0.55);

        int i = 0;
        for (Map.Entry<String, Class<?>> entrada : campos.entrySet()) {
            String nombrecampo = entrada.getKey();
            Class<?> tipoDato = entrada.getValue();
            int posicionY = margenSuperior + (i * espaciado);

            JLabel Label = new JLabel(nombrecampo + ":");
            Label.setForeground(Color.white);
            Label.setFont(fuenteLabel);
            Label.setBounds(margenIzquierdo, posicionY, anchoLabel, altoComponente);
            contenedor.add(Label);

            JComponent componenteFinal;

            if (tipoDato == Boolean.class) {
                String[] opcionesBuscador = {"SIN INGRESAR", "Sí", "No"};

                JComboBox<String> comboBox = new JComboBox<>(opcionesBuscador);
                if (campos.size() == 12) {
                    comboBox.removeAllItems();
                    comboBox.addItem("Sí");
                    comboBox.addItem("No");
                }

                comboBox.setBounds(margenIzquierdo + anchoLabel, posicionY, anchoComponente, altoComponente);
                comboBox.setFont(fuenteComponentes);
                comboBox.setBackground(new Color(53, 56, 77));
                comboBox.setForeground(Color.white);
                comboBox.setBorder(BorderFactory.createLineBorder(new Color(225, 6, 0), 1));
                contenedor.add(comboBox);
                componenteFinal = comboBox;
            } else {
                JTextField textField = new JTextField();
                textField.setBounds(margenIzquierdo + anchoLabel, posicionY, anchoComponente, altoComponente);
                textField.setFont(fuenteComponentes);
                textField.setBackground(new Color(53, 56, 77));
                textField.setForeground(Color.white);
                textField.setCaretColor(Color.white);
                textField.setBorder(BorderFactory.createLineBorder(new Color(225, 6, 0), 1));

                if (tipoDato == Integer.class) {
                    textField.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent evt) {
                            char c = evt.getKeyChar();
                            if (!Character.isDigit(c)) {
                                evt.consume();
                            }
                        }
                    });
                }
                contenedor.add(textField);
                componenteFinal = textField;
            }

            componentesFormulario.put(nombrecampo, componenteFinal);
            i++;
        }

        int anchoBoton = 140;
        int altoBoton = 32;
        int botonX = (w / 2) - (anchoBoton / 2);
        int botonY = h - altoBoton - 20;

        JButton botonG = CrearBotom("Guardar", botonX, botonY, anchoBoton, altoBoton, new Color(225, 6, 0), Color.WHITE, Color.WHITE, Color.BLACK);
        botonG.setFont(new Font("Arial", Font.BOLD, 13));

        botonG.addActionListener(e -> {
            try {
                PilotF1 piloto = new PilotF1();
                if (campos.size() == 13 ){
                    piloto.setId(obtenerEntero(componentesFormulario.get("id")));
                }
                piloto.setAño(obtenerEntero(componentesFormulario.get("año")));
                piloto.setEquipo(obtenerString(componentesFormulario.get("equipo")));
                piloto.setNombre(obtenerString(componentesFormulario.get("nombre")));
                piloto.setN_Piloto(obtenerEntero(componentesFormulario.get("n_Piloto")));
                piloto.setPilotoPrincipal(obtenerBooleano(componentesFormulario.get("pilotoPrincipal")));
                piloto.setGanadorMundial(obtenerBooleano(componentesFormulario.get("ganadorMundial")));
                piloto.setPosicionCampeonato(obtenerEntero(componentesFormulario.get("posicionCampeonato")));
                piloto.setPuntosCampeonato(obtenerEntero(componentesFormulario.get("puntosCampeonato")));
                piloto.setVictorias(obtenerEntero(componentesFormulario.get("victorias")));
                piloto.setPoles(obtenerEntero(componentesFormulario.get("poles")));
                piloto.setN_campeonatos(obtenerEntero(componentesFormulario.get("N_campeonatos")));
                piloto.setTotal_Carreras(obtenerEntero(componentesFormulario.get("total_Carreras")));

                if (alGuardar != null) {
                    alGuardar.accept(piloto);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error al procesar los datos del formulario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        contenedor.add(botonG);
        contenedor.putClientProperty("botonG", "bOTON GUARDAR");
        panel.add(contenedor);

        return componentesFormulario;
    }



    private static String obtenerString(JComponent comp) {
        if (comp instanceof JTextField) {
            return ((JTextField) comp).getText().trim();
        }
        return null;
    }

    private static Integer obtenerEntero(JComponent comp) {
        if (comp instanceof JTextField) {
            String texto = ((JTextField) comp).getText().trim();
            if (!texto.isEmpty()) {
                try {
                    return Integer.parseInt(texto);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }
        return null;
    }

    private static Boolean obtenerBooleano(JComponent comp) {
        if (comp instanceof JComboBox) {
            String seleccionado = (String) ((JComboBox<?>) comp).getSelectedItem();
            if (seleccionado.equals("Sí")) {
                return "Sí".equals(seleccionado);
            }
            if (seleccionado.equals("No")) {
                return "No".equals(seleccionado);
            }
        }
        return null;
    }

}

