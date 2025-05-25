package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.VeiculoModel;

import java.util.List;

public interface IVeiculoService {
    String cadastrarVeiculo(VeiculoModel veiculo);
    VeiculoModel buscarVeiculoPorPlaca(String placa);
    String atualizarVeiculo(VeiculoModel veiculo);
    String removerVeiculo(String placa);
    List<VeiculoModel> listarTodosVeiculos();
}
