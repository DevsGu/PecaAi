package com.edu.ifce.pecaai.dto;

import com.edu.ifce.pecaai.entities.Usuario;

public record UsuarioDTO(Long id, String email, String tipo) {
    public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(
            usuario.getId(), 
            usuario.getEmail(), 
            usuario.getTipo() != null ? usuario.getTipo().toString() : null
        );
    }
}