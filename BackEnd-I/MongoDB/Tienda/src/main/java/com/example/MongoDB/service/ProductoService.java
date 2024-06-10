package com.example.MongoDB.service;

import com.example.MongoDB.entity.Producto;
import com.example.MongoDB.repository.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private IProductoRepository productoRepository;

    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> listarProductos () {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id).orElseGet(null);
    }

    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }

}
