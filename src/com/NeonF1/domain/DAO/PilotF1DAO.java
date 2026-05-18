package com.NeonF1.domain.DAO;

import com.NeonF1.domain.entities.PilotF1;
import com.NeonF1.infrastructure.persistence.DataConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public static List BuscarPilotF1(PilotF1 FiltrosPilotF1) {
        StringBuilder StringBuscarPilotF1 = new StringBuilder("SELECT * FROM \"DatosF1\" WHERE 1 = 1");
        List<Object> Filtros = new ArrayList<>();
        List<PilotF1> DBData = new ArrayList<>();

        if (FiltrosPilotF1.getAño() != null) {
            StringBuscarPilotF1.append(" AND \"Año\" = ?");
            Filtros.add(FiltrosPilotF1.getAño().toString());
        }

        if (FiltrosPilotF1.getEquipo() != null && !FiltrosPilotF1.getEquipo().trim().isEmpty()) {
            StringBuscarPilotF1.append(" AND \"Equipo\" ILIKE ?");
            Filtros.add("%" + FiltrosPilotF1.getEquipo().trim() + "%");
        }

        if (FiltrosPilotF1.getNombre() != null && !FiltrosPilotF1.getNombre().trim().isEmpty()) {
            StringBuscarPilotF1.append(" AND \"Nombre\" ILIKE ?");
            Filtros.add("%" + FiltrosPilotF1.getNombre().trim() + "%");
        }

        if (FiltrosPilotF1.getN_Piloto() != null) {
            StringBuscarPilotF1.append(" AND \"N_Piloto\" = ?");
            Filtros.add(FiltrosPilotF1.getN_Piloto());
        }

        if (FiltrosPilotF1.getPilotoPrincipal() != null) {
            StringBuscarPilotF1.append(" AND \"PilotoPrincipal\" = ?");
            Filtros.add(FiltrosPilotF1.getPilotoPrincipal());
        }

        if (FiltrosPilotF1.getGanadorMundial() != null) {
            StringBuscarPilotF1.append(" AND \"GanarMundialPilotos\" = ?");
            Filtros.add(FiltrosPilotF1.getGanadorMundial());
        }

        if (FiltrosPilotF1.getPosicionCampeonato() != null) {
            StringBuscarPilotF1.append(" AND \"PosicionCampeonato\" = ?");
            Filtros.add(FiltrosPilotF1.getPosicionCampeonato());
        }

        if (FiltrosPilotF1.getPuntosCampeonato() != null) {
            StringBuscarPilotF1.append(" AND \"PuntosCampeonato\" = ?");
            Filtros.add(FiltrosPilotF1.getPuntosCampeonato());
        }

        if (FiltrosPilotF1.getVictorias() != null) {
            StringBuscarPilotF1.append(" AND \"Victorias\" = ?");
            Filtros.add(FiltrosPilotF1.getVictorias());
        }

        if (FiltrosPilotF1.getPoles() != null) {
            StringBuscarPilotF1.append(" AND \"Poles\" = ?");
            Filtros.add(FiltrosPilotF1.getPoles());
        }

        if (FiltrosPilotF1.getN_campeonatos() != null) {
            StringBuscarPilotF1.append(" AND \"N_Campeonato\" = ?");
            Filtros.add(FiltrosPilotF1.getN_campeonatos());
        }

        if (FiltrosPilotF1.getTotal_Carreras() != null) {
            StringBuscarPilotF1.append(" AND \"TotalCarreras\" = ?");
            Filtros.add(FiltrosPilotF1.getTotal_Carreras());
        }

        try (Connection connection = DataConnection.getConnection(); PreparedStatement Filtrado = connection.prepareStatement(StringBuscarPilotF1.toString())) {
            for (int i = 0; i < Filtros.size(); i++) {
                Filtrado.setObject(i + 1, Filtros.get(i));
            }

            try (ResultSet resultSet = Filtrado.executeQuery()) {
                while (resultSet.next()) {
                    PilotF1 DBDatos = new PilotF1();

                    DBDatos.setId(resultSet.getInt("id")); // O el tipo de dato que uses para tu ID
                    DBDatos.setAño(resultSet.getInt("Año"));
                    DBDatos.setEquipo(resultSet.getString("Equipo"));
                    DBDatos.setNombre(resultSet.getString("Nombre"));
                    DBDatos.setN_Piloto(resultSet.getInt("N_Piloto"));
                    DBDatos.setPilotoPrincipal(resultSet.getBoolean("PilotoPrincipal"));
                    DBDatos.setGanadorMundial(resultSet.getBoolean("GanarMundialPilotos"));
                    DBDatos.setPosicionCampeonato(resultSet.getInt("PosicionCampeonato"));
                    DBDatos.setPuntosCampeonato(resultSet.getInt("PuntosCampeonato"));
                    DBDatos.setVictorias(resultSet.getInt("Victorias"));
                    DBDatos.setPoles(resultSet.getInt("Poles"));
                    DBDatos.setN_campeonatos(resultSet.getInt("N_Campeonato"));
                    DBDatos.setTotal_Carreras(resultSet.getInt("TotalCarreras"));

                    DBData.add(DBDatos);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(DBData.toString());
        return DBData;
    }
}
