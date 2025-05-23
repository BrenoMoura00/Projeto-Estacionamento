package br.com.estacionamento.entities.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estacionamento")
public class EstacionamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cnpf", length = 15)
    private String cnpj;

    @Embedded
    private Endereco endereco;
    
    // @Column(name = "responsavel", length = 100)
    // private String responsavel;

    // @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "endereco_id", nullable = false)
    // private EnderecoModel endereco;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private ResponsavelModel responsavel;

    @OneToMany(mappedBy = "estacionamento",cascade = CascadeType.ALL, orphanRemoval = true )
    private List<FuncionarioModel> funcionario = new ArrayList<>();

    @OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VagaModel> vagas = new ArrayList<>();

    public void setVagas(List<VagaModel> vagas) {
        this.vagas = vagas;
    }


    // public EstacionamentoModel(String cnpj, ResponsavelModel responsavel, Endereco endereco) {
    //     // this.nome = nome;
    //     this.cnpj = cnpj;
    //     this.responsavel = responsavel;
    //     this.endereco = endereco;
    // }

     public ResponsavelModel getResponsavel() {
        return responsavel;
    }

    public EstacionamentoModel() {
    }

    public List<FuncionarioModel> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<FuncionarioModel> funcionario) {
        this.funcionario = funcionario;
    }
    
    public void setResponsavel(ResponsavelModel responsavel) {
        this.responsavel = responsavel;
    }
    public ResponsavelModel geResponsavel(){
        return responsavel;
    }

    public Long getId() {
        return id;
    }

    // public String getNome() {
    //     return nome;
    // }

    // public void setNome(String nome) {
    //     this.nome = nome;
    // }

    public String getTelefone() {
        return cnpj;
    }

    public void setTelefone(String cnpj) {
        this.cnpj = cnpj;
    }

    // public String getResponsavel() {
    //     return responsavel;
    // }

    // public void setResponsavel(String responsavel) {
    //     this.responsavel = responsavel;
    // }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<VagaModel> getVagas() {
        return vagas;
    }

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