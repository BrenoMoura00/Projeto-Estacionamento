package br.com.estacionamento;

import br.com.estacionamento.Enum.UF;
import br.com.estacionamento.entidade.Cliente;
import br.com.estacionamento.repositorio.ClienteRepositorio;
import br.com.estacionamento.servicos.ClienteService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Endereco endereco2 = new Endereco("rua ahjdsasd","PEPEU","PIPIU","696969",690,UF.AC);
        Endereco endereco1 = new Endereco("rua do caralho", "da caceta","paudalho","828732",69, UF.MT);

        Cliente cliente1 = new Cliente("jamerson", "1521737372","81672635",12,endereco1);
        Cliente cliente2 = new Cliente("caralhedeo","17685324","12836794",117,endereco2);

        ClienteService service = new ClienteService(new ClienteRepositorio(new ConnectionFactory()));

        service.adicionar(cliente1);
        service.adicionar(cliente2);

        service.listar();










    }
}