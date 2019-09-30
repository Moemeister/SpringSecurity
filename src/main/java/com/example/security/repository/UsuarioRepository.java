package com.example.security.repository;

import com.example.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    public Usuario findByUsername(String username);

}
