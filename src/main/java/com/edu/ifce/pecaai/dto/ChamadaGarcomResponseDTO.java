package com.edu.ifce.pecaai.dto;

import com.edu.ifce.pecaai.entities.ChamadaGarcom;

public record ChamadaGarcomResponseDTO(Long id, Integer numeroMesa, Boolean statusAtendido, Long lojaId) {
    public static ChamadaGarcomResponseDTO fromEntity(ChamadaGarcom chamada) {
        return new ChamadaGarcomResponseDTO(
            chamada.getId(),
            chamada.getNumeroMesa(),
            chamada.getStatusAtendido(),
            chamada.getLoja() != null ? chamada.getLoja().getId() : null
        );
    }
}