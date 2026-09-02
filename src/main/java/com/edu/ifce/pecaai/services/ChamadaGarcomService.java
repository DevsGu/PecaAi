package com.edu.ifce.pecaai.services;

import com.edu.ifce.pecaai.entities.ChamadaGarcom;
import com.edu.ifce.pecaai.repositories.ChamadaGarcomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadaGarcomService {

    @Autowired
    private ChamadaGarcomRepository chamadaGarcomRepository;

    public List<ChamadaGarcom> listarTodas() {
        return chamadaGarcomRepository.findAll();
    }

    public List<ChamadaGarcom> listarPendentesPorLoja(Long lojaId) {
        return chamadaGarcomRepository.findByLojaIdAndStatusAtendidoFalse(lojaId);
    }

    public ChamadaGarcom buscarPorId(Long id) {
        return chamadaGarcomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamada não encontrada com o ID: " + id));
    }

    public ChamadaGarcom salvar(ChamadaGarcom chamada) {
        return chamadaGarcomRepository.save(chamada);
    }

    public ChamadaGarcom atenderChamada(Long id) {
        ChamadaGarcom chamada = buscarPorId(id);
        chamada.setStatusAtendido(true);
        return chamadaGarcomRepository.save(chamada);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        chamadaGarcomRepository.deleteById(id);
    }
}