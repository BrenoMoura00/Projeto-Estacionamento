package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.Funcionario;
import br.com.estacionamento.interfaces.repositories.IFuncionarioRepository;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository implements IFuncionarioRepository {
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void salvar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public void remover(String cpf) {
        funcionarios.removeIf(f -> f.getCpf().equals(cpf));
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCpf().equals(funcionario.getCpf())) {
                funcionarios.set(i, funcionario);
                break;
            }
        }
    }

    @Override
    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios);
    }

    @Override
    public Funcionario buscarPorCpf(String cpf) {
        return funcionarios.stream()
                .filter(f -> f.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
}
