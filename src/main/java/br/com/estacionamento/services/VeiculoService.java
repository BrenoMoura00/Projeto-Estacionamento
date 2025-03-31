package br.com.estacionamento.services;

import br.com.estacionamento.entities.Veiculo;
import br.com.estacionamento.interfaces.repositories.IVeiculoRepository;
import br.com.estacionamento.interfaces.services.IVeiculoService;

import java.util.List;

public class VeiculoService implements IVeiculoService {
    private final IVeiculoRepository veiculoRepository;

    public VeiculoService(IVeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public void cadastrarVeiculo(Veiculo veiculo) {
        if (veiculoRepository.buscarPorPlaca(veiculo.getPlaca()) != null) {
            throw new IllegalArgumentException("Veículo já cadastrado com esta placa");
        }
        veiculoRepository.salvar(veiculo);
    }

    @Override
    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculoRepository.buscarPorPlaca(placa);
    }

    @Override
    public void atualizarVeiculo(Veiculo veiculo) {
        if (veiculoRepository.buscarPorPlaca(veiculo.getPlaca()) == null) {
            throw new IllegalArgumentException("Veículo não encontrado");
        }
        veiculoRepository.atualizar(veiculo);
    }

    @Override
    public void removerVeiculo(String placa) {
        veiculoRepository.remover(placa);
    }

    @Override
    public List<Veiculo> listarTodosVeiculos() {
        return veiculoRepository.listarTodos();
    }
}
