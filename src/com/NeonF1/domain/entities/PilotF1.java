package com.NeonF1.domain.entities;

public class PilotF1 {
    private Integer id;
    private Integer año;
    private String equipo;
    private String nombre;
    private Integer n_Piloto;
    private Boolean pilotoPrincipal;
    private Boolean ganadorMundial;
    private Integer posicionCampeonato;
    private Integer puntosCampeonato;
    private Integer victorias;
    private Integer poles;
    private Integer N_campeonatos;
    private Integer total_Carreras;

    public PilotF1(Integer id, Integer año, String equipo, String nombre, Integer n_Piloto, boolean pilotoPrincipal, boolean ganadorMundial, Integer posicionCampeonato, Integer victorias, Integer poles, Integer N_campeonatos, Integer total_Carrers) {
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

    public PilotF1() {

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAño() {
        return año;
    }
    public void setAño(Integer año) {
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

    public Integer getN_Piloto() {
        return n_Piloto;
    }
    public void setN_Piloto(Integer n_Piloto) {
        this.n_Piloto = n_Piloto;
    }

    public Boolean getPilotoPrincipal() {
        return pilotoPrincipal;
    }
    public void setPilotoPrincipal(boolean pilotoPrincipal) {
        this.pilotoPrincipal = pilotoPrincipal;
    }

    public Boolean getGanadorMundial() {
        return ganadorMundial;
    }
    public void setGanadorMundial(boolean ganadorMundial) {
        this.ganadorMundial = ganadorMundial;
    }

    public Integer getPosicionCampeonato() {
        return posicionCampeonato;
    }
    public void setPosicionCampeonato(Integer posicionCampeonato) {
        this.posicionCampeonato = posicionCampeonato;
    }

    public Integer getPuntosCampeonato() {
        return puntosCampeonato;
    }
    public void setPuntosCampeonato(Integer puntosCampeonato) {
        this.puntosCampeonato = puntosCampeonato;
    }

    public Integer getVictorias() {
        return victorias;
    }
    public void setVictorias(Integer victorias) {
        this.victorias = victorias;
    }

    public Integer getPoles() {
        return poles;
    }
    public void setPoles(Integer poles) {
        this.poles = poles;
    }

    public Integer getN_campeonatos() {
        return N_campeonatos;
    }
    public void setN_campeonatos(Integer N_campeonatos) {
        this.N_campeonatos = N_campeonatos;
    }

    public Integer getTotal_Carreras() {
        return total_Carreras;
    }
    public void setTotal_Carreras(Integer total_Carreras) {
        this.total_Carreras = total_Carreras;
    }
}
