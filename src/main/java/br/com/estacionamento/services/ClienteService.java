package br.com.estacionamento.services;

import br.com.estacionamento.interfaces.services.IclienteService;
import br.com.estacionamento.repositories.ClienteRepository;
import java.time.LocalDate;
import java.util.List;

import br.com.estacionamento.entities.model.ClienteModel;

public class ClienteService implements IclienteService  {

    private ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }

    @Override
    public String cadastrarCliente(ClienteModel cliente) {
        if (cliente == null) {
            return "Cliente não pode ser nulo";
        }
        
        if (cliente.getCpf() == null || cliente.getCpf().trim().isEmpty()) {
            return "CPF é obrigatório";
        }

        if (clienteRepository.existePorCpf(cliente.getCpf())) {
            return "Já existe um cliente cadastrado com este CPF";
        }

        try {
            cliente.setData_cadastro(LocalDate.now());
            cliente.setAtivo(true);
            clienteRepository.create(cliente);
            return "Cliente cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar cliente: " + e.getMessage();
        }
    }

    @Override
    public ClienteModel buscarClientePorCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return null;
        }
        return clienteRepository.buscarPorCpf(cpf);
    }

    @Override
    public String atualizarCliente(ClienteModel cliente) {
        if (cliente == null) {
            return "Cliente não pode ser nulo";
        }
        
        if (cliente.getCpf() == null || cliente.getCpf().trim().isEmpty()) {
            return "CPF é obrigatório";
        }

        ClienteModel clienteExistente = clienteRepository.buscarPorCpf(cliente.getCpf());
        if (clienteExistente == null) {
            return "Cliente não encontrado para atualização";
        }

        try {
            // Mantém os dados que não devem ser alterados
            cliente.setData_cadastro(clienteExistente.getData_cadastro());
            clienteRepository.update(cliente);
            return "Cliente atualizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar cliente: " + e.getMessage();
        }
    }

    @Override
    public String removerCliente(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return "CPF não pode ser nulo ou vazio";
        }

        if (!clienteRepository.existePorCpf(cpf)) {
            return "Cliente não encontrado com o CPF: " + cpf;
        }

        try {
            clienteRepository.deletarPorCpf(cpf);
            return "Cliente removido com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover cliente: " + e.getMessage();
        }
    }

    @Override
    public List<ClienteModel> listarTodosClientes() {
        return clienteRepository.listarTodos();
    }
}
