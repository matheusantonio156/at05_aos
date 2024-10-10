package com.example.gestao_projetos.service;

import com.example.gestao_projetos.entity.Subtarefa;
import com.example.gestao_projetos.repository.SubtarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubtarefaService {

    @Autowired
    private SubtarefaRepository subtarefaRepository;

    public List<Subtarefa> getAllSubtarefas() {
        return subtarefaRepository.findAll();
    }

    public Optional<Subtarefa> getSubtarefaById(Long id) {
        return subtarefaRepository.findById(id);
    }

    public Subtarefa saveSubtarefa(Subtarefa subtarefa) {
        return subtarefaRepository.save(subtarefa);
    }

    public void deleteSubtarefa(Long id) {
        subtarefaRepository.deleteById(id);
    }
}
