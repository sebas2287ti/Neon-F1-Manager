package com.NeonF1.domain.DAO;

import com.NeonF1.domain.entities.PilotF1;
import com.NeonF1.infrastructure.persistence.DataConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PilotF1DAO {

    //Metodo para insertar pilotos a la base de datos (Se agrega el piloto que se quiere agregar)
    public static boolean insertPilot(PilotF1 NewPilotF1) {

        //linea de texto para la consola de la base de datos exactamente la linea para poder insertar pilotos
        String insertString = "INSERT INTO \"DatosF1\" (\"Año\", \"Equipo\", \"Nombre\", \"N_Piloto\", \"PilotoPrincipal\", \"GanarMundialPilotos\", \"PosicionCampeonato\", \"PuntosCampeonato\", \"Victorias\", \"Poles\", \"N_Campeonato\", \"TotalCarreras\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        //Creacion de la conexion y insercion de los datos con un Statement en los VALUES
        try (Connection connection = DataConnection.getConnection(); PreparedStatement insert = connection.prepareStatement(insertString)) {

            insert.setObject(1, NewPilotF1.getAño());
            insert.setObject(2, NewPilotF1.getEquipo());
            insert.setObject(3, NewPilotF1.getNombre());
            insert.setObject(4, NewPilotF1.getN_Piloto());
            insert.setObject(5, NewPilotF1.getPilotoPrincipal());
            insert.setObject(6, NewPilotF1.getGanadorMundial());
            insert.setObject(7, NewPilotF1.getPosicionCampeonato());
            insert.setObject(8, NewPilotF1.getPuntosCampeonato());
            insert.setObject(9, NewPilotF1.getVictorias());
            insert.setObject(10, NewPilotF1.getPoles());
            insert.setObject(11, NewPilotF1.getN_campeonatos());
            insert.setObject(12, NewPilotF1.getTotal_Carreras());

            insert.executeUpdate();

        }

        //Retornos true si fue exitoso y falsa si hubo algun error
        catch (Exception e) {
            e.printStackTrace();
            return false;

        }
        return true;
    }

    //Metodo para poder realizar un filtrado a la base de datos y retornar los datos que considan con el filtro (Se agrega con las caracteristicas definidas de un PilotF1)
    public static List BuscarPilotF1(PilotF1 filterPilotF1) {
        //Definicion
        StringBuilder findString = new StringBuilder("SELECT * FROM \"DatosF1\" WHERE 1 = 1");
        List<Object> findStringData = new ArrayList<>();
        List<PilotF1> listDBData = new ArrayList<>();

        //Filtros compuestos que revisan si se ingreso algo en el objecto para el buscador y se agrega una linea de texto al String del comando y se agrega a una lista que contendra el dato para insertarlo despues
        if (filterPilotF1.getId() != null) {
            findString.append(" AND \"id\" = ?");
            findStringData.add(filterPilotF1.getId());
        }

        if (filterPilotF1.getAño() != null) {
            findString.append(" AND \"Año\" = ?");
            findStringData.add(filterPilotF1.getAño());
        }

        if (filterPilotF1.getEquipo() != null && !filterPilotF1.getEquipo().trim().isEmpty()) {
            findString.append(" AND \"Equipo\" ILIKE ?");
            findStringData.add("%" + filterPilotF1.getEquipo().trim() + "%");
        }

        if (filterPilotF1.getNombre() != null && !filterPilotF1.getNombre().trim().isEmpty()) {
            findString.append(" AND \"Nombre\" ILIKE ?");
            findStringData.add("%" + filterPilotF1.getNombre().trim() + "%");
        }

        if (filterPilotF1.getN_Piloto() != null) {
            findString.append(" AND \"N_Piloto\" = ?");
            findStringData.add(filterPilotF1.getN_Piloto());
        }

        if (filterPilotF1.getPilotoPrincipal() != null) {
            findString.append(" AND \"PilotoPrincipal\" = ?");
            findStringData.add(filterPilotF1.getPilotoPrincipal());
        }

        if (filterPilotF1.getGanadorMundial() != null) {
            findString.append(" AND \"GanarMundialPilotos\" = ?");
            findStringData.add(filterPilotF1.getGanadorMundial());
        }

        if (filterPilotF1.getPosicionCampeonato() != null) {
            findString.append(" AND \"PosicionCampeonato\" = ?");
            findStringData.add(filterPilotF1.getPosicionCampeonato());
        }

        if (filterPilotF1.getPuntosCampeonato() != null) {
            findString.append(" AND \"PuntosCampeonato\" = ?");
            findStringData.add(filterPilotF1.getPuntosCampeonato());
        }

        if (filterPilotF1.getVictorias() != null) {
            findString.append(" AND \"Victorias\" = ?");
            findStringData.add(filterPilotF1.getVictorias());
        }

        if (filterPilotF1.getPoles() != null) {
            findString.append(" AND \"Poles\" = ?");
            findStringData.add(filterPilotF1.getPoles());
        }

        if (filterPilotF1.getN_campeonatos() != null) {
            findString.append(" AND \"N_Campeonato\" = ?");
            findStringData.add(filterPilotF1.getN_campeonatos());
        }

        if (filterPilotF1.getTotal_Carreras() != null) {
            findString.append(" AND \"TotalCarreras\" = ?");
            findStringData.add(filterPilotF1.getTotal_Carreras());
        }

        //Se genera la conexion y se saca la longitud de la lista que contiene los datos a ingresar y se proceden a ingresar con un bucle
        try (Connection connection = DataConnection.getConnection(); PreparedStatement insertFindStringData = connection.prepareStatement(findString.toString())) {
            for (int i = 0; i < findStringData.size(); i++) {
                insertFindStringData.setObject(i + 1, findStringData.get(i));
            }

            //Se procede a procesar los datos de la BD con while y se van insertando al objecto Piloto y despues de ser insertados se procede agregar el objecto a una lista y se vuelve a repetir hasta acabar todas las filas de la base de datos
            try (ResultSet resultDB = insertFindStringData.executeQuery()) {
                while (resultDB.next()) {
                    PilotF1 pilotF1DBData = new PilotF1();

                    pilotF1DBData.setId(resultDB.getInt("id"));
                    pilotF1DBData.setAño(resultDB.getInt("Año"));
                    pilotF1DBData.setEquipo(resultDB.getString("Equipo"));
                    pilotF1DBData.setNombre(resultDB.getString("Nombre"));
                    pilotF1DBData.setN_Piloto(resultDB.getInt("N_Piloto"));
                    pilotF1DBData.setPilotoPrincipal(resultDB.getBoolean("PilotoPrincipal"));
                    pilotF1DBData.setGanadorMundial(resultDB.getBoolean("GanarMundialPilotos"));
                    pilotF1DBData.setPosicionCampeonato(resultDB.getInt("PosicionCampeonato"));
                    pilotF1DBData.setPuntosCampeonato(resultDB.getInt("PuntosCampeonato"));
                    pilotF1DBData.setVictorias(resultDB.getInt("Victorias"));
                    pilotF1DBData.setPoles(resultDB.getInt("Poles"));
                    pilotF1DBData.setN_campeonatos(resultDB.getInt("N_Campeonato"));
                    pilotF1DBData.setTotal_Carreras(resultDB.getInt("TotalCarreras"));

                    listDBData.add(pilotF1DBData);
                }
            }
            //Si se genera un error se imprime y si no se devuelve la lista con todos los objectos"Filas" de la base de datos ya filtrada para su uso
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(listDBData.toString());
        return listDBData;
    }
}
