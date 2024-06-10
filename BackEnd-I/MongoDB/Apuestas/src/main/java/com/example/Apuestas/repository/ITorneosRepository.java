package com.example.Apuestas.repository;

import com.example.Apuestas.entity.Torneo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITorneosRepository extends MongoRepository<Torneo, Long> {
}
