package br.com.estacionamento.entities;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private String cargo;
    private double salario;

    public Funcionario() {
        super();
    }

    public Funcionario(String nome, String cpf, String telefone, LocalDate dataNasc, String cargo, double salario) {
        super(nome, cpf, telefone, dataNasc);
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public String getTipo() {
        return "Funcionário";
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
