package com.example.security.service;

import com.example.security.domain.Usuario;

public interface UsuarioService {

    public void save(Usuario usuario);
    public Boolean isUserAlreadyPresent(Usuario usuario);
}
