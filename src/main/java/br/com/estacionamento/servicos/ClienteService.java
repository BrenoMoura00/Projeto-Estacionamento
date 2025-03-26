package br.com.estacionamento.servicos;


import br.com.estacionamento.entidade.Cliente;
import br.com.estacionamento.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;

import java.util.List;


public class ClienteService {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteService(ClienteRepositorio clienteRepositorio){
        this.clienteRepositorio = clienteRepositorio;
    }

    public void adicionar(Cliente cliente){
        this.clienteRepositorio.adicionar(cliente);
    }

    public List<Cliente> listar(){
        return this.clienteRepositorio.listar();
    };

    public Cliente buscar(String cpf){
        return this.clienteRepositorio.buscar(cpf);
    };

    public Cliente atualizar(Cliente cliente){
        return this.clienteRepositorio.atualizar(cliente);
    };

    public Cliente remove(Cliente cliente){
        return this.clienteRepositorio.remove(cliente);
    };
}
