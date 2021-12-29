package com.co.sofka.biblioteca.Repositories;

import com.co.sofka.biblioteca.Enums.AreaTematica;
import com.co.sofka.biblioteca.Enums.TipoRecuerso;
import com.co.sofka.biblioteca.Models.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoRepository extends MongoRepository<Recurso,String> {
    List<Recurso> findByTipoRecursoAndAreaTematica(TipoRecuerso tipoRecuerso , AreaTematica areaTematica);
    List<Recurso> findByTipoRecursoOrAreaTematica(TipoRecuerso tipoRecuerso , AreaTematica areaTematica);

}
