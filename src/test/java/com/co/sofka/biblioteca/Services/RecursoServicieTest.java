package com.co.sofka.biblioteca.Services;

import com.co.sofka.biblioteca.Enums.AreaTematica;
import com.co.sofka.biblioteca.Enums.TipoRecuerso;
import com.co.sofka.biblioteca.Mappers.RecursoMapper;
import com.co.sofka.biblioteca.Mensaje.Mensaje;
import com.co.sofka.biblioteca.Models.Recurso;
import com.co.sofka.biblioteca.Repositories.RecursoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class RecursoServicieTest {

    @MockBean
    private RecursoRepository recursoRepository;

    @Autowired
    private RecursoServicie recursoServicie;

    @Test
    @DisplayName("Test findAll Success")
    public void obeteneTodos(){

        var recurso1 = new Recurso("el rey leon", AreaTematica.INFANTIL, TipoRecuerso.PELICULA);
        var recurso2 = new Recurso("Algebra",AreaTematica.MATEMATICAS,TipoRecuerso.LIBRO);

        var lista= new ArrayList<Recurso>();
        lista.add(recurso1);
        lista.add(recurso2);

        Mockito.when(recursoRepository.findAll()).thenReturn(lista);

        var resultado = recursoServicie.findAll();

        Assertions.assertEquals(2, resultado.size());
        Assertions.assertEquals(recurso1.getNombre(), resultado.get(0).getNombre());
        Assertions.assertEquals(recurso2.getNombre(), resultado.get(1).getNombre());
        Assertions.assertEquals(recurso2.getTipoRecurso(), resultado.get(1).getTipoRecurso());
        Assertions.assertEquals(recurso1.getAreaTematica(), resultado.get(0).getAreaTematica());
        Mockito.verify(recursoRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void ObtenerId(){

        var recurso1 = new Recurso("zzz","el rey leon", AreaTematica.INFANTIL, TipoRecuerso.PELICULA,true);

        Mockito.when(recursoRepository.findById(any())).thenReturn(java.util.Optional.of(recurso1));

        var resultado = recursoServicie.buscarPorId(recurso1.getId());

        Assertions.assertEquals(recurso1.getNombre(), resultado.getNombre());
        Assertions.assertEquals(recurso1.getId(), resultado.getId());
        Assertions.assertEquals(recurso1.getAreaTematica(), resultado.getAreaTematica());
        Mockito.verify(recursoRepository, Mockito.times(1)).findById("zzz");

    }

    @Test
    public void prestarRecurso(){

        var recurso1 = new Recurso("zzz","el rey leon", AreaTematica.INFANTIL, TipoRecuerso.PELICULA,true);
        var recurso2 = new Recurso("zzz","el rey leon", AreaTematica.INFANTIL, TipoRecuerso.PELICULA,false);
        var mensaje =new Mensaje(true,"El material esta disponible y te fue prestado");


        Mockito.when(recursoRepository.findById(any())).thenReturn(java.util.Optional.of(recurso1));
        Mockito.when(recursoRepository.save(any())).thenReturn(recurso2);
        var resultado = recursoServicie.PrestarUnRecurso(recurso1.getId());

        Assertions.assertEquals(mensaje.getMensaje(),resultado.getMensaje());
        Assertions.assertEquals(mensaje.isEstado(),resultado.isEstado());

    }

    @Test
    public void devolverUnRecuerso(){

        var recurso1 = new Recurso("zzz","el rey leon", AreaTematica.INFANTIL, TipoRecuerso.PELICULA,false);
        var recurso2 = new Recurso("zzz","el rey leon", AreaTematica.INFANTIL, TipoRecuerso.PELICULA,true);
        var mensaje =new Mensaje(true,"El material fue entregado con exito");


        Mockito.when(recursoRepository.findById(any())).thenReturn(java.util.Optional.of(recurso1));
        Mockito.when(recursoRepository.save(any())).thenReturn(recurso2);
        var resultado = recursoServicie.DevolverUnRecurso(recurso1.getId());

        Assertions.assertEquals(mensaje.getMensaje(),resultado.getMensaje());
        Assertions.assertEquals(mensaje.isEstado(),resultado.isEstado());

    }

    @Test
    public void filtroTest(){

        var recurso = new Recurso("xxx","algebra", AreaTematica.MATEMATICAS, TipoRecuerso.LIBRO,true);
        var lista=new ArrayList<Recurso>();
        lista.add(recurso);

        Mockito.when(recursoRepository.findByTipoRecursoAndAreaTematica(TipoRecuerso.LIBRO,AreaTematica.MATEMATICAS)).thenReturn(lista);

        RecursoMapper mapper = new RecursoMapper();
        var resultado = recursoServicie.BuscarAreaYTipo(mapper.fromCollection(recurso));

        Assertions.assertEquals(1, resultado.size());
        Assertions.assertEquals(recurso.getNombre(), resultado.get(0).getNombre());
        Assertions.assertEquals(recurso.getId(), resultado.get(0).getId());

        Mockito.verify(recursoRepository,Mockito.times(1)).findByTipoRecursoAndAreaTematica(TipoRecuerso.LIBRO,AreaTematica.MATEMATICAS);

    }


}