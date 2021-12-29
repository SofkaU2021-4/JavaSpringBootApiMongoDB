package com.co.sofka.biblioteca.Repositories;

import com.co.sofka.biblioteca.Models.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends MongoRepository<Recurso,String> {

}
