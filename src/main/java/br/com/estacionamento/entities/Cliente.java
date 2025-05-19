package br.com.estacionamento.entities;


import java.time.LocalDate;

public class Cliente extends Pessoa {
    private boolean mensalista;

    public Cliente() {
        super();
    }

    public Cliente(String nome, String cpf, String telefone, LocalDate dataNasc, boolean mensalista) {
        super(nome, cpf, telefone, dataNasc);
        this.mensalista = mensalista;
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }

    public boolean isMensalista() {
        return mensalista;
    }

    public void setMensalista(boolean mensalista) {
        this.mensalista = mensalista;
    }

}
