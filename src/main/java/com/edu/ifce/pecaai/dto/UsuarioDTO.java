package com.edu.ifce.pecaai.dto;

import com.edu.ifce.pecaai.entities.Usuario;

public record UsuarioDTO(Long id, String nome, String email, String senha, String tipo) {
    public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(
            usuario.getId(), 
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getSenha(), 
            usuario.getTipo() != null ? usuario.getTipo().toString() : null
        );
    }
}