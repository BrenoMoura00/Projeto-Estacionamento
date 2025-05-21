package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.ClienteModel;

import java.util.List;

public interface IclienteService {
    void cadastrarCliente(ClienteModel cliente);
    ClienteModel buscarClientePorCpf(String cpf);
    void atualizarCliente(ClienteModel cliente);
    void removerCliente(String cpf);
    List<ClienteModel> listarTodosClientes();
}
