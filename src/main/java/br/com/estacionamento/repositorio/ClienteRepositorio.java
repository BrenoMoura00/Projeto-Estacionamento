package br.com.estacionamento.repositorio;


import java.util.ArrayList;
import java.util.List;

import br.com.estacionamento.entidade.Cliente;
import br.com.estacionamento.interfaces.IClienteRepositorio;

public class ClienteRepositorio implements IClienteRepositorio {
    private List<Cliente> list;

    public ClienteRepositorio() {
        this.list = new ArrayList<>();
    }

    @Override
    public void adicionar(Cliente t) {
        // Task Falcão
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
