package com.edu.ifce.pecaai.services;

import com.edu.ifce.pecaai.entities.Pedido;
import com.edu.ifce.pecaai.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> listarPorLoja(Long lojaId) {
        return pedidoRepository.findByLojaId(lojaId);
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));
    }

    public Pedido salvar(Pedido pedido) {
        if (pedido.getDataHora() == null) {
            pedido.setDataHora(LocalDateTime.now());
        }
        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        pedidoRepository.deleteById(id);
    }
}