package br.com.estacionamento.entidade;



public class Cliente extends Pessoa {
    private boolean mensalista;

    public Cliente() {
        super();
    }

    public Cliente(String nome, String cpf, String telefone, boolean mensalista) {
        super(nome, cpf, telefone);
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
