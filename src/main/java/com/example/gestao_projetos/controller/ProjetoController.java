package com.example.gestao_projetos.controller;

import com.example.gestao_projetos.entity.Disciplina;
import com.example.gestao_projetos.entity.Projeto;
import com.example.gestao_projetos.entity.Mebros;
import com.example.gestao_projetos.service.ProjetoService;
// import disciplina service
// import membros service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private MembroService membroService;

    // Endpoint para listar todos os projetos de uma disciplina específica
    @GetMapping("/disciplina/{disciplinaId}")
    public String listarProjetosPorDisciplina(@PathVariable Long disciplinaId, Model model) {
        List<Projeto> projetos = projetoService.getProjetosByDisciplina(disciplinaId);
        Disciplina disciplina = disciplinaService.getDisciplinaById(disciplinaId);
        model.addAttribute("projetos", projetos);
        model.addAttribute("disciplina", disciplina);
        return "projetos/lista-projetos";
    }

    // Endpoint para exibir a página de cadastro de um novo projeto
    @GetMapping("/disciplina/{disciplinaId}/novo")
    public String exibirFormularioNovoProjeto(@PathVariable Long disciplinaId, Model model) {
        Projeto projeto = new Projeto();
        Disciplina disciplina = disciplinaService.getDisciplinaById(disciplinaId);
        model.addAttribute("projeto", projeto);
        model.addAttribute("disciplina", disciplina);
        return "projetos/form-novo-projeto";
    }

    // Endpoint para salvar um novo projeto
    @PostMapping("/disciplina/{disciplinaId}/salvar")
    public String salvarProjeto(@PathVariable Long disciplinaId, @ModelAttribute("projeto") Projeto projeto) {
        Disciplina disciplina = disciplinaService.getDisciplinaById(disciplinaId);
        projeto.setDisciplina(disciplina);
        projetoService.salvarProjeto(projeto);
        return "redirect:/projetos/disciplina/" + disciplinaId;
    }

    // Endpoint para exibir a página de detalhes do projeto
    @GetMapping("/{id}")
    public String detalhesProjeto(@PathVariable Long id, Model model) {
        Projeto projeto = projetoService.getProjetoById(id);
        List<Mebros> membros = membroService.listarMembrosPorProjeto(id);
        model.addAttribute("projeto", projeto);
        model.addAttribute("membros", membros);
        return "projetos/detalhes-projeto";
    }

    // Endpoint para excluir um projeto
    @GetMapping("/deletar/{id}")
    public String deletarProjeto(@PathVariable Long id) {
        Projeto projeto = projetoService.getProjetoById(id);
        Long disciplinaId = projeto.getDisciplina().getId();
        projetoService.deletarProjeto(id);
        return "redirect:/projetos/disciplina/" + disciplinaId;
    }
}
