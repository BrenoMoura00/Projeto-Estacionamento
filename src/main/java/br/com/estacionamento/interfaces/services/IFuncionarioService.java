package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.Funcionario;

import java.util.List;

public interface IFuncionarioService {
    void cadastrarFuncionario(Funcionario funcionario);
    Funcionario buscarFuncionarioPorCpf(String cpf);
    void atualizarFuncionario(Funcionario funcionario);
    void removerFuncionario(String cpf);
    List<Funcionario> listarTodosFuncionarios();
}
