package com.co.sofka.biblioteca.DTOs;

import com.co.sofka.biblioteca.Enums.AreaTematica;
import com.co.sofka.biblioteca.Enums.TipoRecuerso;

import java.util.Date;

public class RecursoDTO {

    private String id;
    private String nombre;
    private boolean isDisponible = true;
    private Date fechaPrestamo;
    private AreaTematica areaTematica ;
    private TipoRecuerso tipoRecurso ;

    public RecursoDTO() {
    }

    public RecursoDTO(String nombre, AreaTematica areaTematica, TipoRecuerso tipoRecurso) {
        this.nombre = nombre;
        this.areaTematica = areaTematica;
        this.tipoRecurso = tipoRecurso;
    }



    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public AreaTematica getAreaTematica() {
        return areaTematica;
    }

    public TipoRecuerso getTipoRecurso() {
        return tipoRecurso;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDisponible(boolean disponible) {
        isDisponible = disponible;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setAreaTematica(AreaTematica areaTematica) {
        this.areaTematica = areaTematica;
    }

    public void setTipoRecurso(TipoRecuerso tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }
}
