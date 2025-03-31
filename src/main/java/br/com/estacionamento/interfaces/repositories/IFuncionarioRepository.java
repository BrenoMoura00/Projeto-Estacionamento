package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.Funcionario;

import java.util.List;

public interface IFuncionarioRepository {
    void salvar(Funcionario funcionario);
    void remover(String cpf);
    void atualizar(Funcionario funcionario);
    List<Funcionario> listarTodos();
    Funcionario buscarPorCpf(String cpf);
}
