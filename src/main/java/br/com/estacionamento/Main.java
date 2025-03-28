package br.com.estacionamento;

import br.com.estacionamento.Enum.UF;
import br.com.estacionamento.entidade.Cliente;
import br.com.estacionamento.entidade.Endereco;
import br.com.estacionamento.repositorio.ClienteRepositorio;
import br.com.estacionamento.servicos.ClienteService;

public class Main {
    public static void main(String[] args) {
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio(new ConnectionFactory());
        ClienteService clienteService = new ClienteService(clienteRepositorio);
        //Endereco endereco = new Endereco("Rua 1", "Bairro 1", "Cidade 1", "12345678", 123, UF.PE);
        //Cliente cliente = new Cliente("Breno", "123456789", "123456789", 20, endereco);

        //System.out.println(cliente);
        Cliente cliente1 = new Cliente.Builder().cpf("").build();

        clienteService.adicionar(cliente1);
        clienteService.adicionar(cliente1);
        System.out.println(clienteService.listar());
    }
}