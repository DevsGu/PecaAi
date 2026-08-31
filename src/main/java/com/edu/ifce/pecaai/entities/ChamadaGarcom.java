package com.edu.ifce.pecaai.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_chamada_garcom")
public class ChamadaGarcom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = false)
    private Integer numeroMesa;

    @Column(nullable = false)
    private Boolean statusAtendido = false;

    @ManyToOne
    @JoinColumn(name = "loja_id", nullable = false)
    private Loja loja;
}
