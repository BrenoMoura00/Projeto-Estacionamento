package br.com.estacionamento.repositorio;


import java.util.ArrayList;
import java.util.List;

import br.com.estacionamento.ConnectionFactory;
import br.com.estacionamento.entidade.Cliente;
import br.com.estacionamento.interfaces.IClienteRepositorio;

public class ClienteRepositorio implements IClienteRepositorio {
    private List<Cliente> list;
    private final ConnectionFactory connectionFactory;


    public ClienteRepositorio(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        this.list = new ArrayList<>();
    }

    @Override
    public void adicionar(Cliente t) {
        this.list.add(t);
    }

    @Override
    public Cliente atualizar(Cliente t) {
        for (Cliente cliente1 : list){
            if (cliente1.getCpf().equals( t.getCpf())){
                cliente1.setNome(t.getNome());
                cliente1.setIdade(t.getIdade());
                cliente1.setTelefone(t.getTelefone());
            } else{
                return null;
            }
        }
        return null;
    }

    @Override
    public Cliente buscar(String cpf) {
        for (Cliente t : list){
            if(t.getCpf().equals(cpf)){
                return t;
            }
        }
        return null;
    }

    @Override
    public List listar() {
        if(list.size() > 0){
            return list;
        }
        return null;
    }

    @Override
    public Cliente remove(Cliente t) {
        for (Cliente cliente1 : list){
            if (cliente1.getCpf().equals(t.getCpf())){
                list.remove(cliente1);
            }
        }
        return null;
    }
}
