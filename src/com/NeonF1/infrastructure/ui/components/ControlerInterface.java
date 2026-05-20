package com.NeonF1.infrastructure.ui.components;

import com.NeonF1.infrastructure.ui.window.StartPanel;

import javax.smartcardio.Card;
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
        container.add(startPanel, "MenuInicio");

        window.add(container);
        window.setVisible(true);
    }
}
