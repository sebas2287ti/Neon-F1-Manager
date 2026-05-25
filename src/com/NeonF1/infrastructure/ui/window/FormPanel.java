    package com.NeonF1.infrastructure.ui.window;

    import com.NeonF1.domain.DAO.PilotF1DAO;
    import com.NeonF1.domain.entities.PilotF1;
    import com.NeonF1.infrastructure.ui.components.Background;
    import com.NeonF1.infrastructure.ui.components.ControlerInterface;
    import com.NeonF1.infrastructure.ui.components.UiFactory;

    import javax.swing.*;
    import java.awt.*;
    import java.util.ArrayList;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.Map;

    //Metodo para la creacion del panel de formulario y extension a la clase padre para poner el fondo
    public class FormPanel extends Background {
        //Definiciones basicas para el uso
        private ControlerInterface controler;
        private Map<String, JComponent> componentsForm;
        private JScrollPane tableScrollNow = null;

        public FormPanel(ControlerInterface controler) {
            super("/Image/Base/NuevoPiloto.jpg");
            this.controler = controler;

            setLayout(null);

            //Creacion del map al cual se le definiran las columnas de nuestra Base de datos y los respectivos datos que estas reciben para la tabla
            Map<String, Class<?>> fields = new LinkedHashMap<>();
            fields.put("año", Integer.class);
            fields.put("equipo", String.class);
            fields.put("nombre", String.class);
            fields.put("n_Piloto", Integer.class);
            fields.put("pilotoPrincipal", Boolean.class);
            fields.put("ganadorMundial", Boolean.class);
            fields.put("posicionCampeonato", Integer.class);
            fields.put("puntosCampeonato", Integer.class);
            fields.put("victorias", Integer.class);
            fields.put("poles", Integer.class);
            fields.put("N_campeonatos", Integer.class);
            fields.put("total_Carreras", Integer.class);

            //La creacion del formulario con el metodo el cual incluye el boton y el guardado de los datos directamente un objecto el cual tiene todos los datos del formualrio
            componentsForm = UiFactory.CrearFormularioInteligente(this, fields, 28, 180, 388, 420,"Guardar", DatePilotF1 -> {

                //If activa el metodo insertar al pasarle el objecto resultante de nuestro Formulario que tambien verifica que si se logro el guardado de los datos del formulario y la comunicacion con la base de datos
                if ( PilotF1DAO.insertPilot(DatePilotF1) == true) {

                    //Creacion de la lista que contendra todos los datos
                    List<PilotF1> resultDB = new java.util.ArrayList<>();

                    //En este caso que solo es la operacion de añadir DatePilotF1 solo se añadira al DatePilotF1 que se inserto en la base de datos
                    resultDB.add(DatePilotF1);

                    //Metodo encargo para la eliminacion de tablas anteriores
                    if (tableScrollNow != null) {
                        remove(tableScrollNow);
                    }

                    //Creacion de la nueva tabla
                    tableScrollNow = UiFactory.createTable(resultDB, 440, 350, 798, 248);

                    //Se añade la nueva table y se redibuja y revalida los datos en esta misma
                    add(tableScrollNow);
                    revalidate();
                    repaint();

                    //Boton que le verifica al usuario que fue un exito el agregar al neuvo DatePilotF1
                    JOptionPane.showMessageDialog(this, "Piloto " + DatePilotF1.getNombre() + " guardado");
                }
                else {
                    //Boton que le verifica al usuario que fue no se pudo el agregar al nuevo DatePilotF1
                    JOptionPane.showMessageDialog(this, "Fallo el guardado del DatePilotF1 " + DatePilotF1.getNombre() + " revisa la peticion");
                };
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
            JButton homeButton = UiFactory.createButton("⌂", 60, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
            JButton findButton = UiFactory.createButton("\uD83D\uDD0D", 110, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
            JButton formButton = UiFactory.createButton("\uD83C\uDFCE\uFE0F", 160, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
            JButton testButton = UiFactory.createButton("\uD83D\uDE99", 210, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
            JButton exitButton = UiFactory.createButton("\uD83C\uDFC1", 260, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);

            //Añadir los iconos al panel para que se puedan visualizar
            add(homeButton);
            add(findButton);
            add(formButton);
            add(testButton);
            add(exitButton);

            //Funciones de los botones (Salir, Cambiar de panel mediante el panelChange)
            homeButton.addActionListener(e -> controler.panelChange("StartPanel"));
            formButton.addActionListener(e -> controler.panelChange("FormPanel") );
            findButton.addActionListener(e -> controler.panelChange("FindPanel") );
            exitButton.addActionListener(e -> System.exit(0));
        }
    }
