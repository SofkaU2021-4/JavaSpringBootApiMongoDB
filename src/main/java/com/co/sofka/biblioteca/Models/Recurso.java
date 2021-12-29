package com.co.sofka.biblioteca.Models;


import com.co.sofka.biblioteca.Enums.AreaTematica;
import com.co.sofka.biblioteca.Enums.TipoRecuerso;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("Recursos")
public class Recurso {

    @Id
    private String id;
    private String nombre;
    private boolean isDisponible = true;
    private Date fechaPrestamo;
    private AreaTematica areaTematica ;
    private TipoRecuerso tipoRecurso ;

    public Recurso() {
    }

    public Recurso(String nombre, AreaTematica areaTematica, TipoRecuerso tipoRecurso) {
        this.nombre = nombre;
        this.areaTematica = areaTematica;
        this.tipoRecurso = tipoRecurso;
    }

    public void setId(String id) {
        this.id = id;
    }



    public void setAreaTematica(AreaTematica areaTematica) {
        this.areaTematica = areaTematica;
    }

    public void setTipoRecurso(TipoRecuerso tipoRecurso) {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDisponible(boolean disponible) {
        isDisponible = disponible;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
