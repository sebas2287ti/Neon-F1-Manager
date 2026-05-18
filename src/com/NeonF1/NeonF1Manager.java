package com.NeonF1;

import javax.swing.*;
import com.NeonF1.infrastructure.ui.window.UiNeonF1Manager;
import com.NeonF1.infrastructure.persistence.DataConnection;
import com.NeonF1.domain.DAO.PilotF1DAO;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class NeonF1Manager {
    public static void main(String[] args) {
        UiNeonF1Manager ui = new UiNeonF1Manager();
        JFrame window = new JFrame("Formula 1 Datos Generales");


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(ui.getMainPanel());
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
