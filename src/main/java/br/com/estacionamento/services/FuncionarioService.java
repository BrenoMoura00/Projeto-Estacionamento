package br.com.estacionamento.services;

import br.com.estacionamento.entities.Funcionario;
import br.com.estacionamento.interfaces.repositories.IFuncionarioRepository;
import br.com.estacionamento.interfaces.services.IFuncionarioService;

import java.util.List;

public class FuncionarioService implements IFuncionarioService {
    private final IFuncionarioRepository funcionarioRepository;

    public FuncionarioService(IFuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {
        if (funcionarioRepository.buscarPorCpf(funcionario.getCpf()) != null) {
            throw new IllegalArgumentException("Funcionário já cadastrado com este CPF");
        }
        funcionarioRepository.salvar(funcionario);
    }

    @Override
    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        return funcionarioRepository.buscarPorCpf(cpf);
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionario) {
        if (funcionarioRepository.buscarPorCpf(funcionario.getCpf()) == null) {
            throw new IllegalArgumentException("Funcionário não encontrado");
        }
        funcionarioRepository.atualizar(funcionario);
    }

    @Override
    public void removerFuncionario(String cpf) {
        funcionarioRepository.remover(cpf);
    }

    @Override
    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.listarTodos();
    }
}
