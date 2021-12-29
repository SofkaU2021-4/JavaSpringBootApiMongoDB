package com.co.sofka.biblioteca.Mappers;

import com.co.sofka.biblioteca.DTOs.RecursoDTO;
import com.co.sofka.biblioteca.Models.Recurso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RecursoMapper {

    public Recurso fromDTO(RecursoDTO dto){
        Recurso recurso = new Recurso();
        recurso.setId(dto.getId());
        recurso.setAreaTematica(dto.getAreaTematica());
        recurso.setDisponible(dto.isDisponible());
        recurso.setFechaPrestamo(dto.getFechaPrestamo());
        recurso.setNombre(dto.getNombre());
        recurso.setTipoRecurso(dto.getTipoRecurso());
        return recurso;
    }

    public RecursoDTO fromCollection(Recurso collection){
        RecursoDTO recursoDTO = new RecursoDTO();
        recursoDTO.setId(collection.getId());
        recursoDTO.setAreaTematica(collection.getAreaTematica());
        recursoDTO.setDisponible(collection.isDisponible());
        recursoDTO.setFechaPrestamo(collection.getFechaPrestamo());
        recursoDTO.setNombre(collection.getNombre());
        recursoDTO.setTipoRecurso(collection.getTipoRecurso());
        return recursoDTO;
    }

    public List<RecursoDTO> fromCollectionList(List<Recurso> collection){
        if(collection==null){
            return null;
        }
        List<RecursoDTO> list = new ArrayList<>(collection.size());
        Iterator listTrack = collection.iterator();

        while(listTrack.hasNext()){
            Recurso recurso = (Recurso) listTrack.next();
            list.add(fromCollection(recurso));
        }
        return list;
    }

}
