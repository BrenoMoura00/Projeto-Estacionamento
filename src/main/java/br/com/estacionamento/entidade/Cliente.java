package br.com.estacionamento.entidade;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private int idade;
    private Endereco endereco;

    public Cliente(String nome, String cpf, String telefone, int idade, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.idade = idade;
        this.endereco = endereco;
    }

    public Cliente() {
    }

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente[ " +
                "nome: '" + nome + '\'' +
                ", cpf: '" + cpf + '\'' +
                ", telefone: '" + telefone + '\'' +
                ", idade: " + idade +
                ", endereco: " + endereco +
                ']';
    }
}
