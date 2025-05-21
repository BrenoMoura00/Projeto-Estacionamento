package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.VeiculoModel;

import java.util.List;

public interface IVeiculoRepository {
    void salvar(VeiculoModel veiculo);
    void remover(String placa);
    void atualizar(VeiculoModel veiculo);
    List<VeiculoModel> listarTodos();
    VeiculoModel buscarPorPlaca(String placa);
}
