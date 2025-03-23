package br.com.estacionamento.entidade;

import br.com.estacionamento.Enum.UF;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String cep;
    private int numero;
    private UF uf;

    public Endereco(String rua, String bairro, String cidade, String cep, int numero, UF uf) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.numero = numero;
        this.uf = uf;
    }

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco[ " +
                "rua: '" + rua + '\'' +
                ", bairro: '" + bairro + '\'' +
                ", cidade: '" + cidade + '\'' +
                ", cep: '" + cep + '\'' +
                ", numero: " + numero +
                ", uf: " + uf +
                ']';
    }
}
