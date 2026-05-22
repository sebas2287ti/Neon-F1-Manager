    package com.NeonF1.infrastructure.ui.components;

    import com.NeonF1.infrastructure.ui.window.FormPanel;
    import com.NeonF1.infrastructure.ui.window.StartPanel;
    import com.NeonF1.infrastructure.ui.window.FindPanel;

    import javax.swing.*;
    import java.awt.*;

    public class ControlerInterface {
        private final CardLayout CARDLAYOUT;
        private final JPanel CONTAINER;

        //Creacion del controlador de la interfaz
        public ControlerInterface(JFrame windowMain) {
            this.CARDLAYOUT = new CardLayout();
            this.CONTAINER = new JPanel(CARDLAYOUT);

            //Inicializacion de los paneles con este controlador
            StartPanel startPanel =  new StartPanel(this);
            FormPanel formPanel = new FormPanel(this);
            FindPanel findPanel = new FindPanel(this);

            //Agregar los paneles inicializados al panel container el cual los contendra a todos
            CONTAINER.add(startPanel, "StartPanel");
            CONTAINER.add(formPanel, "FormPanel");
            CONTAINER.add(findPanel, "FindPanel");

            //Agregar el panel contenedor a la ventana principal donde se mostrara
            windowMain.add(CONTAINER);
            windowMain.setVisible(true);
        }

        //Metodo que permite cambiar entre paneles visibles y no visibles en la ventana Principal
        public void panelChange(String panelName) {
            CARDLAYOUT.show(CONTAINER, panelName);
        }
    }
