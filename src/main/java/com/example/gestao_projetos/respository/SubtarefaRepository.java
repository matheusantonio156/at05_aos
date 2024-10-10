package com.example.gestao_projetos.repository;

import com.example.gestao_projetos.entity.Subtarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtarefaRepository extends JpaRepository<Subtarefa, Long> {
    List<Subtarefa> findByTarefaPrincipalId(Long tarefaPrincipalId);
}
