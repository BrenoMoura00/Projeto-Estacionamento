package br.com.estacionamento.services;

import br.com.estacionamento.entities.model.VeiculoModel;
import br.com.estacionamento.interfaces.services.IVeiculoService;
import br.com.estacionamento.repositories.VeiculoRepository;
import java.util.List;

public class VeiculoService implements IVeiculoService {
    
    private VeiculoRepository veiculoRepository;

    public VeiculoService() {
        this.veiculoRepository = new VeiculoRepository();
    }

    @Override
    public String cadastrarVeiculo(VeiculoModel veiculo) {
        return null;
    }

    @Override
    public VeiculoModel buscarVeiculoPorPlaca(String placa) {
        return null;
    }

    @Override
    public String atualizarVeiculo(VeiculoModel veiculo) {
        return null;
    }

    @Override
    public String removerVeiculo(String placa) {
        return null;
    }

    @Override
    public List<VeiculoModel> listarTodosVeiculos() {
        return null;
    }
} 