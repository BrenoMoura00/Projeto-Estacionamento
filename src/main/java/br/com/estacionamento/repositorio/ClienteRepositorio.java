package br.com.estacionamento.repositorio;


import java.util.ArrayList;
import java.util.List;

import br.com.estacionamento.ConnectionFactory;
import br.com.estacionamento.entidade.Cliente;
import br.com.estacionamento.interfaces.IClienteRepositorio;

public class ClienteRepositorio implements IClienteRepositorio {
    private final ConnectionFactory connectionFactory;
    private List<Cliente> list;

    public ClienteRepositorio(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        this.list = new ArrayList<>();
    }

    @Override
    public void adicionar(Cliente t) {

    }

    @Override
    public Cliente atualizar(Cliente t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente buscar(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente remove(Cliente t) {
        // TODO Auto-generated method stub
        return null;
    }
}
