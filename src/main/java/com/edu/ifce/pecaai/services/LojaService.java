package com.edu.ifce.pecaai.services;

import com.edu.ifce.pecaai.entities.Loja;
import com.edu.ifce.pecaai.repositories.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    public List<Loja> listarTodas() {
        return lojaRepository.findAll();
    }

    public Loja buscarPorId(Long id) {
        return lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loja não encontrada com o ID: " + id));
    }

    public Loja salvar(Loja loja) {
        return lojaRepository.save(loja);
    }

    public void deletar(Long id) {
        buscarPorId(id); // Garante que a loja existe antes de deletar
        lojaRepository.deleteById(id);
    }
}