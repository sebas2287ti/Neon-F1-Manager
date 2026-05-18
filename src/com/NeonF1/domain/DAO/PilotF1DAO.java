package com.NeonF1.domain.DAO;

import com.NeonF1.domain.entities.PilotF1;
import com.NeonF1.infrastructure.persistence.DataConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class PilotF1DAO {
    public static boolean InsertPilot (PilotF1 NewPilotF1) {
        String StringInsert = "INSERT INTO \"DatosF1\" (\"Año\", \"Equipo\", \"Nombre\", \"N_Piloto\", \"PilotoPrincipal\", \"GanarMundialPilotos\", \"PosicionCampeonato\", \"PuntosCampeonato\", \"Victorias\", \"Poles\", \"N_Campeonato\", \"TotalCarreras\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";



        try (Connection connection = DataConnection.getConnection(); PreparedStatement Insert = connection.prepareStatement(StringInsert)) {

            Insert.setInt(1, NewPilotF1.getAño());
            Insert.setString(2, NewPilotF1.getEquipo());
            Insert.setString(3, NewPilotF1.getNombre());
            Insert.setInt(4, NewPilotF1.getN_Piloto());
            Insert.setBoolean(5, NewPilotF1.getPilotoPrincipal());
            Insert.setBoolean(6, NewPilotF1.getGanadorMundial());
            Insert.setInt(7, NewPilotF1.getPosicionCampeonato());
            Insert.setInt(8, NewPilotF1.getPuntosCampeonato());
            Insert.setInt(9, NewPilotF1.getVictorias());
            Insert.setInt(10, NewPilotF1.getPoles());
            Insert.setInt(11, NewPilotF1.getN_campeonatos());
            Insert.setInt(12, NewPilotF1.getTotal_Carreras());

            Insert.executeUpdate();

        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public static List BuscarPilotF1 (PilotF1 FiltrosPilotF1) {
        String StringBuscarPilotF1 = "SELECT * FROM \"DatosF1\" WHERE 1 = 1";




        return new List();
    }
}
