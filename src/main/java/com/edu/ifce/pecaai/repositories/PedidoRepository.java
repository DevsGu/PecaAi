package com.edu.ifce.pecaai.repositories;

import com.edu.ifce.pecaai.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByLojaId(Long lojaId);
}