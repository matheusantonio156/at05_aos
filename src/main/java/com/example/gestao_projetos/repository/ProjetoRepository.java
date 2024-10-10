package com.example.gestao_projetos.repository;

import com.example.gestao_projetos.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    List<Projeto> findByDisciplinaId(Long disciplinaId);
}
