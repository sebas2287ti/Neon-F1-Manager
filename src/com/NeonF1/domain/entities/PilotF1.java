package com.NeonF1.domain.entities;

public class PilotF1 {
    private Integer id;
    private Integer año;
    private String equipo;
    private String nombre;
    private Integer n_Piloto;
    private boolean pilotoPrincipal;
    private boolean ganadorMundial;
    private Integer posicionCampeonato;
    private Integer puntosCampeonato;
    private Integer victorias;
    private Integer poles;
    private Integer N_campeonatos;
    private Integer total_Carreras;

    public PilotF1(int id, int año, String equipo, String nombre, int n_Piloto, boolean pilotoPrincipal, boolean ganadorMundial, int posicionCampeonato, int victorias, int poles, int N_campeonatos, int total_Carrers) {
        this.id = id;
        this.año = año;
        this.equipo = equipo;
        this.nombre = nombre;
        this.n_Piloto = n_Piloto;
        this.pilotoPrincipal = pilotoPrincipal;
        this.ganadorMundial = ganadorMundial;
        this.posicionCampeonato = posicionCampeonato;
        this.victorias = victorias;
        this.poles = poles;
        this.N_campeonatos = N_campeonatos;
        this.total_Carreras = total_Carrers;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }

    public String getEquipo() {
        return equipo;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getN_Piloto() {
        return n_Piloto;
    }
    public void setN_Piloto(int n_Piloto) {
        this.n_Piloto = n_Piloto;
    }

    public boolean getPilotoPrincipal() {
        return pilotoPrincipal;
    }
    public void setPilotoPrincipal(boolean pilotoPrincipal) {
        this.pilotoPrincipal = pilotoPrincipal;
    }

    public boolean getGanadorMundial() {
        return ganadorMundial;
    }
    public void setGanadorMundial(boolean ganadorMundial) {
        this.ganadorMundial = ganadorMundial;
    }

    public int getPosicionCampeonato() {
        return posicionCampeonato;
    }
    public void setPosicionCampeonato(int posicionCampeonato) {
        this.posicionCampeonato = posicionCampeonato;
    }

    public int getPuntosCampeonato() {
        return puntosCampeonato;
    }
    public void setPuntosCampeonato(int puntosCampeonato) {
        this.puntosCampeonato = puntosCampeonato;
    }

    public int getVictorias() {
        return victorias;
    }
    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getPoles() {
        return poles;
    }
    public void setPoles(int poles) {
        this.poles = poles;
    }

    public int getN_campeonatos() {
        return N_campeonatos;
    }
    public void setN_campeonatos(int N_campeonatos) {
        this.N_campeonatos = N_campeonatos;
    }

    public int getTotal_Carreras() {
        return total_Carreras;
    }
    public void setTotal_Carreras(int total_Carreras) {
        this.total_Carreras = total_Carreras;
    }
}
