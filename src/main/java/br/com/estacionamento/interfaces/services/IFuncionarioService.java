package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.FuncionarioModel;

import java.util.List;

public interface IFuncionarioService {
    String cadastrarFuncionario(FuncionarioModel funcionario);
    FuncionarioModel buscarFuncionarioPorCpf(String cpf);
    String atualizarFuncionario(FuncionarioModel funcionario);
    String removerFuncionario(String cpf);
    List<FuncionarioModel> listarTodosFuncionarios();
}
