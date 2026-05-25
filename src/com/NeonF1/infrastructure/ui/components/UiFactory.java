package com.NeonF1.infrastructure.ui.components;
import com.NeonF1.domain.entities.PilotF1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.awt.Image;

public class UiFactory {

    //Metodo de creacion de botones apartir de (Icono, Cordenadas x y, Ancho, Alto, Color del fondo, Color del Icono, Color de la margen, Color del icono al pasar encima de el)
    public static JButton createButton(String symbol, int x, int y, int w, int h, Color background, Color text, Color border, Color reColorText) {
        JButton button = new JButton(symbol);

        //Definicion de las caracteristicas del boton (posicion, color de fondo, color de borde)
        button.setBounds(x, y, w, h);
        button.setBackground(background);
        button.setFont(new Font("SansSerif", Font.BOLD, 24));
        button.setForeground(text);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(border, 1));

        //Creacion de eventos cuando el mouse esta encima del boton y cuando no
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(border);
                button.setForeground(reColorText);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(background);
                button.setForeground(text);
            }
        });

        //retorno del boton totalmente creado para el uso
        return button;
    }

    public static Map<String, JComponent> CrearFormularioInteligente(JPanel panel, Map<String, Class<?>> campos, int x, int y, int w, int h,String TextBoton, Consumer<PilotF1> savePilotData) {
        Map<String, JComponent> componentesFormulario = new HashMap<>();
        JPanel container = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(30, 32, 43, 220));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            }
        };
        container.setOpaque(false);
        container.setBounds(x, y, w, h);
        container.setLayout(null);

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
            container.add(Label);

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
                comboBox.setBorder(BorderFactory.createLineBorder(new Color(225, 225, 225), 1));
                container.add(comboBox);
                componenteFinal = comboBox;
            } else {
                JTextField textField = new JTextField();
                textField.setBounds(margenIzquierdo + anchoLabel, posicionY, anchoComponente, altoComponente);
                textField.setFont(fuenteComponentes);
                textField.setBackground(new Color(53, 56, 77));
                textField.setForeground(Color.white);
                textField.setCaretColor(Color.white);
                textField.setBorder(BorderFactory.createLineBorder(new Color(225, 225, 225), 1));

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
                container.add(textField);
                componenteFinal = textField;
            }

            componentesFormulario.put(nombrecampo, componenteFinal);
            i++;
        }

        //Caracteristicas del boton
        int wButton = 370;
        int hButton = 24;
        int xButton = 15;
        int yButton = 384;

        //Creacion del boton
        JButton Button = createButton(TextBoton, xButton, yButton, wButton, hButton, new Color(43, 44, 65), Color.WHITE, Color.WHITE, Color.BLACK);
        Button.setFont(new Font("Arial", Font.BOLD, 13));

        //Aciones del boton
        Button.addActionListener(e -> {
            try {
                //Creacion de un objecto al presionar el boton con toda la informacion dentro del formulario
                PilotF1 pilotData = new PilotF1();

                //Esta if permite saber si es un buscador o un formulario de insercion dependiendo de cual sea se tiene que llenar correctamente para su uso posterior
                if (campos.size() == 13 ){
                    pilotData.setId(getInt(componentesFormulario.get("id")));
                }
                pilotData.setAño(getInt(componentesFormulario.get("año")));
                pilotData.setEquipo(getString(componentesFormulario.get("equipo")));
                pilotData.setNombre(getString(componentesFormulario.get("nombre")));
                pilotData.setN_Piloto(getInt(componentesFormulario.get("n_Piloto")));
                pilotData.setPilotoPrincipal(getBolean(componentesFormulario.get("pilotoPrincipal")));
                pilotData.setGanadorMundial(getBolean(componentesFormulario.get("ganadorMundial")));
                pilotData.setPosicionCampeonato(getInt(componentesFormulario.get("posicionCampeonato")));
                pilotData.setPuntosCampeonato(getInt(componentesFormulario.get("puntosCampeonato")));
                pilotData.setVictorias(getInt(componentesFormulario.get("victorias")));
                pilotData.setPoles(getInt(componentesFormulario.get("poles")));
                pilotData.setN_campeonatos(getInt(componentesFormulario.get("N_campeonatos")));
                pilotData.setTotal_Carreras(getInt(componentesFormulario.get("total_Carreras")));

                //Si la creacion del objecto es exitosa se procede a devolver mediante un callback o retorno para el uso del objecto pilotf1
                if (savePilotData != null) {
                    savePilotData.accept(pilotData);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error al procesar los datos del formulario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        //Añadir el boton al contenedor que tendra
        container.add(Button);
        container.putClientProperty("Button", "Save Button");
        panel.add(container);

        return componentesFormulario;
    }

    //Metodo de cracion de la tabla
    public static JScrollPane createTable(java.util.List<?> listDataDB, int x, int y, int w, int h) {

        //Titulos que tendra la tabla
        String[] tittles = {
                "ID", "Año", "Equipo", "Nombre", "N° Piloto", "Piloto Principal", "Ganador Mundial", "Posición", "Puntos", "Victorias", "Poles", "N° Campeonatos", "Total Carreras"
        };

        //Configurar toda la tabla para que no se pueda editar
        DefaultTableModel model = new DefaultTableModel(tittles, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //Llenado de toda la tabla mediante la lista de objectos que contiene toda la informacion de las filas de la DataBase
        if (!listDataDB.isEmpty()) {
            for (Object obj: listDataDB) {
                PilotF1 pilotDataRow = (PilotF1) obj;
                Object[] fila = {
                        pilotDataRow.getId() != null ? pilotDataRow.getId() : "",
                        pilotDataRow.getAño() != null ? pilotDataRow.getAño() : "",
                        pilotDataRow.getEquipo() != null ? pilotDataRow.getEquipo() : "",
                        pilotDataRow.getNombre() != null ? pilotDataRow.getNombre() : "",
                        pilotDataRow.getN_Piloto() != null ? pilotDataRow.getN_Piloto() : "",
                        pilotDataRow.getPilotoPrincipal() != null ? (pilotDataRow.getPilotoPrincipal() ? "Sí" : "No") : "",
                        pilotDataRow.getGanadorMundial() != null ? (pilotDataRow.getGanadorMundial() ? "Sí" : "No") : "",
                        pilotDataRow.getPosicionCampeonato() != null ? pilotDataRow.getPosicionCampeonato() : "",
                        pilotDataRow.getPuntosCampeonato() != null ? pilotDataRow.getPuntosCampeonato() : "",
                        pilotDataRow.getVictorias() != null ? pilotDataRow.getVictorias() : "",
                        pilotDataRow.getPoles() != null ? pilotDataRow.getPoles() : "",
                        pilotDataRow.getN_campeonatos() != null ? pilotDataRow.getN_campeonatos() : "",
                        pilotDataRow.getTotal_Carreras() != null ? pilotDataRow.getTotal_Carreras() : ""
                };

                //Metodo que cambia a la siguiente fila de la tabla
                model.addRow(fila);
            }
        }

        //Personalizacion de la tabla
        JTable tabla = new JTable(model);
        tabla.setFillsViewportHeight(true);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setFocusable(false);

        //persnalizacion de las filas
        tabla.setBackground(new Color(53, 56, 77));
        tabla.setForeground(Color.WHITE);
        tabla.setGridColor(new Color(43, 44, 65));
        tabla.setFont(new Font("Arial", Font.PLAIN, 12));
        tabla.setRowHeight(25);

        //personalizacion de todos los titulos de la tabla
        tabla.getTableHeader().setBackground(new Color(30, 32, 43));
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tabla.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(43, 44, 65), 1));

        //Creacion del panel que permite contener la tabla la cual al ser tan grande se usara el un scrollpane que permite bajar
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(x, y, w, h);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(43, 44, 65), 1));
        scrollPane.getViewport().setBackground(new Color(30, 32, 43));

        //retorno del scrollpane
        return scrollPane;
    }

    //Metodo para la creacion de imagenes dentro de la interfaz
    public JPanel imageCreate(int x, int y, int w, int h, ArrayList URLImage, Color Background) {
        //Definicion basica de las variables que se usaran
        JPanel container = new JPanel();
        JLabel imageLabel = new JLabel();
        final int[] i = {0};

        //Obtencion de las URL de la primera imagen que se mostrara al cargar
        URL firtUrl = getClass().getResource(URLImage.get(0).toString());
        ImageIcon fistIconImage = new ImageIcon(firtUrl);
        Image firtImageFix = fistIconImage.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);


        //Definicion de donde ira el Jpanel contenedor
        container.setOpaque(false);
        container.setBounds(x, y, w, h);
        container.setLayout(null);

        //Colocacion de la primera imagen y ajuste del tamaño
        imageLabel.setBounds(x, y, w, h);
        imageLabel.setIcon(new ImageIcon(firtImageFix));


        //Separacion del hilo de ejecucion mediante un timer //un while pero infinito para monos con la ejecucion del evento
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Obtencion de las URL dentro del timer
                String URLImages = (String) URLImage.get(i[0]); //no se por que no dejan usar directamente el array sin esto pero ya que
                URL imagesFinalUrl = getClass().getResource(URLImages);

                //Colocacion de las imagenes y actualizar o repintar todo el Jpanel o contenedor
                ImageIcon originalIcon = new ImageIcon(imagesFinalUrl);
                Image imageFix = originalIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(imageFix));
                container.repaint();

                //Aumento del ciclo
                i[0]++;

                //Caso if para que cada vez que se llegue al limite de imagenes se vuelva a 0 para hacerlo infinito
                if (i[0] >= URLImage.size()) {
                    i[0] = 0;
                }
            }
        });

        //Inicio del timer "While infinito"
        timer.start();

        //Añadir al contenedor todo nuestro carrusel de imagenes
        container.add(imageLabel);

        //Devolver el contenedor a donde sea que lo hayan llamado para ser usado
        return container;
    }

    //Metodo para extraer el texto del un JtextField y realizarle una limpieza
    private static String getString(JComponent comp) {
        if (comp instanceof JTextField) {
            return ((JTextField) comp).getText().trim();
        }
        return null;
    }

    //Metodo para extraer el numero del un JtextField y pasarlo a string con una limpieza
    private static Integer getInt(JComponent comp) {
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

    //Metodo para extraer el numero del un JtextField y pasarlo a string con una limpieza
    private static Boolean getBolean(JComponent comp) {
        if (comp instanceof JComboBox) {
            String seleccionado = (String) ((JComboBox<?>) comp).getSelectedItem();
            if (seleccionado.equals("Sí")) {
                System.out.print("Sí".equals(seleccionado));
                return true;

            }
            if (seleccionado.equals("No")) {
                System.out.print("No".equals(seleccionado));
                return false;
            }
        }
        return null;
    }
}

