package com.co.sofka.biblioteca.Controllers;


import com.co.sofka.biblioteca.DTOs.RecursoDTO;
import com.co.sofka.biblioteca.Services.RecursoServicie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    @Autowired
    RecursoServicie recursoServicie;

    @PostMapping("/crear")
    public ResponseEntity<RecursoDTO> create(@RequestBody RecursoDTO recursoDTO) {
        return new ResponseEntity(recursoServicie.crear(recursoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoDTO> mostrarDisponibilidad(@PathVariable("id") String id) {
        return new ResponseEntity(recursoServicie.obtenerPorIdYValidarEstado(id), HttpStatus.OK);
    }

    @PutMapping("/prestar/{id}")
    public ResponseEntity<RecursoDTO> prestar(@PathVariable String id) {
        return new ResponseEntity(recursoServicie.PrestarUnRecurso(id), HttpStatus.OK);

    }
    @PutMapping("/devolver/{id}")
    public ResponseEntity<RecursoDTO> devolver(@PathVariable String id) {
        return new ResponseEntity(recursoServicie.DevolverUnRecurso(id), HttpStatus.OK);

    }

}
