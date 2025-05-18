package br.com.estacionamento.entities.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estacionamentos")
public class EstacionamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @Column(name = "responsavel", length = 100)
    private String responsavel;

    @Embedded
    private EnderecoModel endereco;

    @OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VagaModel> vagas = new ArrayList<>();

    // Construtores
    public EstacionamentoModel() {
    }

    public EstacionamentoModel(String nome, String telefone, String responsavel, EnderecoModel endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.responsavel = responsavel;
        this.endereco = endereco;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public List<VagaModel> getVagas() {
        return vagas;
    }

    // Métodos de negócio
    public void adicionarVaga(VagaModel vaga) {
        vagas.add(vaga);
        vaga.setEstacionamento(this);
    }

    public void removerVaga(VagaModel vaga) {
        vagas.remove(vaga);
        vaga.setEstacionamento(null);
    }

    public long getTotalVagasDisponiveis() {
        return vagas.stream().filter(VagaModel::isDisponivel).count();
    }
}