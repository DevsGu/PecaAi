package com.edu.ifce.pecaai.controller;

import com.edu.ifce.pecaai.entities.ChamadaGarcom;
import com.edu.ifce.pecaai.services.ChamadaGarcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamadas")
public class ChamadaGarcomController {

    @Autowired
    private ChamadaGarcomService chamadaGarcomService;

    @GetMapping
    public ResponseEntity<List<ChamadaGarcom>> listarTodas() {
        return ResponseEntity.ok(chamadaGarcomService.listarTodas());
    }

    @GetMapping("/pendentes/loja/{lojaId}")
    public ResponseEntity<List<ChamadaGarcom>> listarPendentesPorLoja(@PathVariable Long lojaId) {
        return ResponseEntity.ok(chamadaGarcomService.listarPendentesPorLoja(lojaId));
    }

    @PostMapping
    public ResponseEntity<ChamadaGarcom> criar(@RequestBody ChamadaGarcom chamada) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chamadaGarcomService.salvar(chamada));
    }

    @PutMapping("/{id}/atender")
    public ResponseEntity<ChamadaGarcom> atender(@PathVariable Long id) {
        return ResponseEntity.ok(chamadaGarcomService.atenderChamada(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        chamadaGarcomService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}