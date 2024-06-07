package com.example.ORM.service;

import com.example.ORM.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    Usuario agregarUsuario(Usuario usuario);
    Optional<Usuario> buscarUnUsuario(Long id);
    List<Usuario> buscarTodosUsuarios();
    void modificarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);
}
