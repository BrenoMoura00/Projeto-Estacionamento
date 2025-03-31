package br.com.estacionamento.entidade;


public class Vaga {
    private int numero;
    private String setor;
    private boolean disponivel;

    public Vaga() {
    }

    public Vaga(int numero, String setor, boolean disponivel) {
        this.numero = numero;
        this.setor = setor;
        this.disponivel = disponivel;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
