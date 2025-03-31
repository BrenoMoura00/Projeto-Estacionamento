package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.Veiculo;

import java.util.List;

public interface IVeiculoService {
    void cadastrarVeiculo(Veiculo veiculo);
    Veiculo buscarVeiculoPorPlaca(String placa);
    void atualizarVeiculo(Veiculo veiculo);
    void removerVeiculo(String placa);
    List<Veiculo> listarTodosVeiculos();
}
