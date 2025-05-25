package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.ClienteModel;

import java.util.List;

public interface IclienteService {
    String cadastrarCliente(ClienteModel cliente);
    ClienteModel buscarClientePorCpf(String cpf);
    String atualizarCliente(ClienteModel cliente);
    String removerCliente(String cpf);
    List<ClienteModel> listarTodosClientes();
}
