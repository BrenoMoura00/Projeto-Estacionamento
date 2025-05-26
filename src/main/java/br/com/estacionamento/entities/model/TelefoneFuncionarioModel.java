package br.com.estacionamento.entities.model;

import jakarta.persistence.*;

@Entity
@Table(name = "telefone_funcionario")
public class TelefoneFuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @ManyToOne
    @JoinColumn(name = "telefone")
    private FuncionarioModel funcionario;

    public TelefoneFuncionarioModel() {
    }
}
