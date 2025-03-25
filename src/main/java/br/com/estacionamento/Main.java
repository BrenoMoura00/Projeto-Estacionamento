package br.com.estacionamento;

import br.com.estacionamento.Enum.UF;
import br.com.estacionamento.entidade.Cliente;
import br.com.estacionamento.entidade.Endereco;

public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua 1", "Bairro 1", "Cidade 1", "12345678", 123, UF.PE);
        Cliente cliente = new Cliente("Breno", "123456789", "123456789", 20, endereco);

        System.out.println(cliente);
    }
}