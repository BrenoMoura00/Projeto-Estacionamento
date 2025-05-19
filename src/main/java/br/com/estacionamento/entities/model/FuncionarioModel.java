package br.com.estacionamento.entities.model;

import br.com.estacionamento.entities.Pessoa;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "funcionarios")
@DiscriminatorValue("FUNCIONARIO") // Para herança com Pessoa
public class FuncionarioModel extends Pessoa {

    @Column(name = "pis", unique = true, length = 14)
    private String pis;

    @Column(name = "cargo", nullable = false, length = 50)
    private String cargo;

    @Column(name = "salario", precision = 10, scale = 2)
    private BigDecimal salario;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private EnderecoModel endereco;

    // Construtores
    public FuncionarioModel() {
        super();
    }

    public FuncionarioModel(String nome, String cpf, LocalDate dataNasc, String pis,
                            String cargo, BigDecimal salario, EnderecoModel endereco) {
        super(nome, cpf, dataNasc);
        this.pis = pis;
        this.cargo = cargo;
        this.salario = salario;
        this.endereco = endereco;
    }

    // Getters e Setters
    @Override
    public String getTipo() {
        return "FUNCIONARIO";
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }
}