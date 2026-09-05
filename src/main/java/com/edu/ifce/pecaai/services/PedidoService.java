package com.edu.ifce.pecaai.services;

import com.edu.ifce.pecaai.dto.PedidoRequestDTO; // Ajuste o pacote se necessário
import com.edu.ifce.pecaai.entities.Loja;
import com.edu.ifce.pecaai.entities.Pedido;
import com.edu.ifce.pecaai.entities.Usuario;
import com.edu.ifce.pecaai.repositories.LojaRepository;
import com.edu.ifce.pecaai.repositories.PedidoRepository;
import com.edu.ifce.pecaai.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

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

    public Pedido salvar(PedidoRequestDTO dto) {
        Pedido pedido = new Pedido();

        if (pedido.getDataHora() == null) {
            pedido.setDataHora(LocalDateTime.now());
        }

        // Busca e vincula a Loja usando o ID do DTO
        Loja loja = lojaRepository.findById(dto.lojaId())
                .orElseThrow(() -> new RuntimeException("Loja não encontrada com ID: " + dto.lojaId()));
        pedido.setLoja(loja);

        // Busca e vincula o Cliente (Usuário) usando o ID do DTO
        Usuario cliente = usuarioRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + dto.clienteId()));
        pedido.setUsuario(cliente);

        // Salva o pedido principal no banco
        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        pedidoRepository.deleteById(id);
    }
}