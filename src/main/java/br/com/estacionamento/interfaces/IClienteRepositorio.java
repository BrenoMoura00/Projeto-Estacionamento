package br.com.estacionamento.interfaces;

import java.util.List;

import br.com.estacionamento.entidade.Cliente;

public interface IClienteRepositorio{
    // adiciona um obejto ao banco de dados
    void adicionar(Cliente  t);

    // Lista todos os itens do banco de dados
    List<Cliente> listar();

    // Busca um objeto em especifico no banco de dados
    Cliente buscar(int id);
    
    // Atualiza um item no banco de dados;
    Cliente atualizar(Cliente t);
    
    // Remove um item do banco de dados
    Cliente remove(Cliente t);
}
