package br.com.estacionamento.interfaces.repositories;

import java.util.List;

import br.com.estacionamento.entities.Cliente;

public interface IClienteRepository {
    void salvar(Cliente cliente);
    void remover(String cpf);
    void atualizar(Cliente cliente);
    List<Cliente> listarTodos();
    Cliente buscarPorCpf(String cpf);
}
