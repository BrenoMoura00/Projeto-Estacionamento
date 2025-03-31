package br.com.estacionamento.entidade;



//BRENO NÃO ALTERA ESSA PORRA
public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private int idade;
    private Endereco endereco;


    public Cliente(Builder builder){
        this.nome = builder.nome;
        this.cpf = builder.cpf;
        this.telefone = builder.telefone;
        this.idade = builder.idade;
        this.endereco = builder.endereco;
    }
    //BRENO NÃO ALTERA ESSA PORRA
    public static class Builder{
        private String nome;
        private String cpf;
        private String telefone;
        private int idade;
        private Endereco endereco;

        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }
        public Builder cpf(String cpf){
            this.cpf = cpf;
            return this;
        }
        public Builder telefone(String telefone){
            this.telefone = telefone;
            return this;
        }
        public Builder idade(int idade){
            this.idade = idade;
            return this;
        }
        public Builder endereco(Endereco endereco){
            this.endereco = endereco;
            return this;
        }

        public Cliente build(){
            return new Cliente(this);
        }
    }
}
