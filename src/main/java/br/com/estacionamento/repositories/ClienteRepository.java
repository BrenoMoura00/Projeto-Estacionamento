package br.com.estacionamento.repositories;


import java.util.ArrayList;
import java.util.List;

import br.com.estacionamento.entities.Cliente;
import br.com.estacionamento.interfaces.repositories.IClienteRepository;

public class ClienteRepository implements IClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void remover(String cpf) {
        clientes.removeIf(c -> c.getCpf().equals(cpf));
    }

    @Override
    public void atualizar(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cliente.getCpf())) {
                clientes.set(i, cliente);
                break;
            }
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
}
