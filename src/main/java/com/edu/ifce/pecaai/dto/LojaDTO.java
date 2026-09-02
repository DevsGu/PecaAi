package com.edu.ifce.pecaai.dto;

import com.edu.ifce.pecaai.entities.Loja;

public record LojaDTO(Long id, String nome, String cnpj) {
    public static LojaDTO fromEntity(Loja loja) {
        return new LojaDTO(loja.getId(), loja.getNome(), loja.getCnpj());
    }
}