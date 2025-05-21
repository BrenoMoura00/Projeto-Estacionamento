package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.FuncionarioModel;

import java.util.List;

public interface IFuncionarioService {
    void cadastrarFuncionario(FuncionarioModel funcionario);
    FuncionarioModel buscarFuncionarioPorCpf(String cpf);
    void atualizarFuncionario(FuncionarioModel funcionario);
    void removerFuncionario(String cpf);
    List<FuncionarioModel> listarTodosFuncionarios();
}
