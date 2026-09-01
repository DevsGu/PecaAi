package com.edu.ifce.pecaai.controller;

import com.edu.ifce.pecaai.entities.Loja;
import com.edu.ifce.pecaai.services.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @GetMapping
    public ResponseEntity<List<Loja>> listarTodas() {
        return ResponseEntity.ok(lojaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loja> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(lojaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Loja> criar(@RequestBody Loja loja) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lojaService.salvar(loja));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        lojaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}