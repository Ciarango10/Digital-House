package com.example.MongoDB.repository;

import com.example.MongoDB.entity.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends MongoRepository<Producto, Integer> {
}
