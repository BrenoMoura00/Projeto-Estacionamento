package br.com.estacionamento.view;

import br.com.estacionamento.entities.model.ClienteModel;
import br.com.estacionamento.repositories.BaseDAO;
import br.com.estacionamento.repositories.ClienteRepository;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        ClienteModel cliente = new ClienteModel();
        cliente.setNome("João Silva");
        cliente.setCpf("123.456.789-00");
        cliente.setTelefone("11987654321");
        cliente.setDataNasc(LocalDate.of(1990, 5, 20));

        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.create(cliente);


    }
}