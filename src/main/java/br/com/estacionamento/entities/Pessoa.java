package br.com.estacionamento.entities;

import java.time.LocalDate;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected LocalDate dataNasc;

    public Pessoa() {}

    public Pessoa(String nome, String cpf, String telefone, LocalDate dataNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    }

    public abstract String getTipo();

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public LocalDate getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
}