package br.com.estacionamento.interfaces.repositories;

import java.util.List;

public interface IVeiculoRepository {
    void salvar(Veiculo veiculo);
    void remover(String placa);
    void atualizar(Veiculo veiculo);
    List<Veiculo> listarTodos();
    Veiculo buscarPorPlaca(String placa);
}
