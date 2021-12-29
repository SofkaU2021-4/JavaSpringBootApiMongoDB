package com.co.sofka.biblioteca.Services;



import com.co.sofka.biblioteca.DTOs.RecursoDTO;
import com.co.sofka.biblioteca.Mappers.RecursoMapper;
import com.co.sofka.biblioteca.Mensaje.Mensaje;
import com.co.sofka.biblioteca.Models.Recurso;
import com.co.sofka.biblioteca.Repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RecursoServicie {
    @Autowired
    RecursoRepository recursoRepository;
    RecursoMapper mapper = new RecursoMapper();

    public RecursoDTO buscarPorId(String id){
        Recurso recurso = recursoRepository.findById(id).orElseThrow(()->new RuntimeException(" Recurso NO encontrado"));
        return mapper.fromCollection(recurso);
    }


    public Mensaje obtenerPorIdYValidarEstado(String id){
        RecursoDTO recursoDTO=buscarPorId(id);
        return new Mensaje().imprimirMensajeDisponibilidad(recursoDTO.isDisponible(),recursoDTO.getFechaPrestamo());
    }

    public Mensaje PrestarUnRecurso(String id){
        RecursoDTO recursoDTO=buscarPorId(id);
        Mensaje mensaje = new Mensaje().imprimirMensajePrestamo(recursoDTO.isDisponible(),recursoDTO.getFechaPrestamo());

        if(recursoDTO.isDisponible()){
            recursoDTO.setDisponible(false);
            recursoDTO.setFechaPrestamo(new Date());
            Recurso recurso = mapper.fromDTO(recursoDTO);
            mapper.fromCollection(recursoRepository.save(recurso));
        }


        return mensaje;

    }

    public  Mensaje DevolverUnRecurso(String id){
        RecursoDTO recursoDTO=buscarPorId(id);
        Mensaje mensaje = new Mensaje().imprimirMensajeDevolucion(recursoDTO.isDisponible(),recursoDTO.getFechaPrestamo());

        if(!recursoDTO.isDisponible()){
            recursoDTO.setDisponible(true);
            recursoDTO.setFechaPrestamo(null);
            Recurso recurso = mapper.fromDTO(recursoDTO);
            mapper.fromCollection(recursoRepository.save(recurso));
        }


        return mensaje;

    }




    public RecursoDTO crear(RecursoDTO recursoDTO) {
        Recurso recurso = mapper.fromDTO(recursoDTO);
        return mapper.fromCollection(recursoRepository.save(recurso));
    }

    public void   delete(String id){
        recursoRepository.deleteById(id);
    }





}
