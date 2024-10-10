package com.example.gestao_projetos.entity;

import jakarta.persistence.*;

@Entity
public class Subtarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "tarefa_principal_id")
    private Tarefa tarefaPrincipal;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tarefa getTarefaPrincipal() {
        return tarefaPrincipal;
    }

    public void setTarefaPrincipal(Tarefa tarefaPrincipal) {
        this.tarefaPrincipal = tarefaPrincipal;
    }
}
