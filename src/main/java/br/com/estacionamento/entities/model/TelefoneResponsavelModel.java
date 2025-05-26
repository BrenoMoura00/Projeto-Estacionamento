package br.com.estacionamento.entities.model;

import jakarta.persistence.*;

@Entity
@Table(name = "telefone_responsavel")
public class TelefoneResponsavelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @ManyToOne
    @JoinColumn(name = "telefone")
    ResponsavelModel responsavel;

    public TelefoneResponsavelModel() {
    }
}
