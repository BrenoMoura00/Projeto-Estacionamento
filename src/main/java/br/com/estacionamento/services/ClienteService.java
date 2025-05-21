package br.com.estacionamento.services;


import br.com.estacionamento.interfaces.services.IclienteService;
import br.com.estacionamento.interfaces.repositories.IClienteRepository;
import java.util.List;

public class ClienteService implements IclienteService {
    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        if (clienteRepository.buscarPorCpf(cliente.getCpf()) != null) {
            throw new IllegalArgumentException("Cliente já cadastrado com este CPF");
        }
        clienteRepository.salvar(cliente);
    }

    @Override
    public Cliente buscarClientePorCpf(String cpf) {
        return clienteRepository.buscarPorCpf(cpf);
    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        if (clienteRepository.buscarPorCpf(cliente.getCpf()) == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        clienteRepository.atualizar(cliente);
    }

    @Override
    public void removerCliente(String cpf) {
        clienteRepository.remover(cpf);
    }

    @Override
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.listarTodos();
    }
}
