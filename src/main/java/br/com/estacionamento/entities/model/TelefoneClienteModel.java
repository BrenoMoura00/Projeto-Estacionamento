package br.com.estacionamento.entities.model;

import jakarta.persistence.*;

@Entity
@Table(name = "telefone_cliente")
public class TelefoneClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @ManyToOne
    @JoinColumn(name = "telefone")
    private ClienteModel cliente;

    public TelefoneClienteModel() {
    }
}
