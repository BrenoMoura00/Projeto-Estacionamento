package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.VeiculoModel;

import java.util.List;

public interface IVeiculoService {
    void cadastrarVeiculo(VeiculoModel veiculo);
    VeiculoModel buscarVeiculoPorPlaca(String placa);
    void atualizarVeiculo(VeiculoModel veiculo);
    void removerVeiculo(String placa);
    List<VeiculoModel> listarTodosVeiculos();
}
