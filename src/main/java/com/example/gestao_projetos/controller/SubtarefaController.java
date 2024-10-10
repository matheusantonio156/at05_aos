package com.example.gestao_projetos.controller;

import com.example.gestao_projetos.entity.Subtarefa;
import com.example.gestao_projetos.service.SubtarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subtarefas")
public class SubtarefaController {

    @Autowired
    private SubtarefaService subtarefaService;

    @GetMapping
    public List<Subtarefa> listarSubtarefas() {
        return subtarefaService.getAllSubtarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subtarefa> buscarSubtarefa(@PathVariable Long id) {
        return subtarefaService.getSubtarefaById(id)
                .map(subtarefa -> ResponseEntity.ok().body(subtarefa))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Subtarefa criarSubtarefa(@RequestBody Subtarefa subtarefa) {
        return subtarefaService.saveSubtarefa(subtarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSubtarefa(@PathVariable Long id) {
        subtarefaService.deleteSubtarefa(id);
        return ResponseEntity.noContent().build();
    }
}
