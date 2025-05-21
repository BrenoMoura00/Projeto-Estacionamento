package br.com.estacionamento.interfaces.services;

import java.util.List;

public interface IclienteService {
    void cadastrarCliente(Cliente cliente);
    Cliente buscarClientePorCpf(String cpf);
    void atualizarCliente(Cliente cliente);
    void removerCliente(String cpf);
    List<Cliente> listarTodosClientes();
}
