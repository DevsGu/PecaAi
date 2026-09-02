package com.edu.ifce.pecaai.dto;

import com.edu.ifce.pecaai.entities.Produto;

public record ProdutoResponseDTO(Long id, String nome, String descricao, Double preco, Long lojaId) {
    public static ProdutoResponseDTO fromEntity(Produto produto) {
        return new ProdutoResponseDTO(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco(),
            produto.getLoja() != null ? produto.getLoja().getId() : null
        );
    }
}