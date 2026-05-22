    package com.NeonF1.infrastructure.ui.components;

    import com.NeonF1.infrastructure.ui.window.FormularioPanel;
    import com.NeonF1.infrastructure.ui.window.StartPanel;
    import com.NeonF1.infrastructure.ui.window.BuscadorPanel;

    import javax.swing.*;
    import java.awt.*;

    public class ControlerInterface {
        private JFrame window;
        private CardLayout cardLayout;
        private JPanel container;

        public ControlerInterface(JFrame window) {
            this.window = window;
            this.cardLayout = new CardLayout();
            this.container = new JPanel(cardLayout);

            StartPanel startPanel =  new StartPanel(this);
            FormularioPanel formularioPanel = new FormularioPanel(this);
            BuscadorPanel panelBuscador = new BuscadorPanel(this);

            container.add(startPanel, "MenuInicio");
            container.add(formularioPanel, "Formulario");
            container.add(panelBuscador, "PantallaBuscador");

            window.add(container);
            window.setVisible(true);
        }

        public void cambiarPanel(String nombrePanel) {
            cardLayout.show(container, nombrePanel);
        }
    }
