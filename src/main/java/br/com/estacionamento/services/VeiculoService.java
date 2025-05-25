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
        if (veiculo == null) {
            return "Veículo não pode ser nulo";
        }

        if (veiculo.getPlaca() == null || veiculo.getPlaca().trim().isEmpty()) {
            return "Placa é obrigatória";
        }

        if (veiculo.getModelo() == null || veiculo.getModelo().trim().isEmpty()) {
            return "Modelo é obrigatório";
        }

        if (veiculo.getCor() == null || veiculo.getCor().trim().isEmpty()) {
            return "Cor é obrigatória";
        }

        if (veiculo.getMarca() == null || veiculo.getMarca().trim().isEmpty()) {
            return "Marca é obrigatória";
        }

        if (veiculo.getAno() == null || veiculo.getAno() <= 0) {
            return "Ano é obrigatório e deve ser maior que zero";
        }

        if (veiculo.getCliente() == null) {
            return "Cliente é obrigatório";
        }

        try {
            veiculoRepository.create(veiculo);
            return "Veículo cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar veículo: " + e.getMessage();
        }
    }

    @Override
    public VeiculoModel buscarVeiculoPorPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            return null;
        }
        return veiculoRepository.buscarPorPlaca(placa);
    }

    @Override
    public String atualizarVeiculo(VeiculoModel veiculo) {
        if (veiculo == null) {
            return "Veículo não pode ser nulo";
        }

        if (veiculo.getId() == null) {
            return "ID do veículo é obrigatório";
        }

        if (veiculo.getPlaca() == null || veiculo.getPlaca().trim().isEmpty()) {
            return "Placa é obrigatória";
        }

        if (veiculo.getModelo() == null || veiculo.getModelo().trim().isEmpty()) {
            return "Modelo é obrigatório";
        }

        if (veiculo.getCor() == null || veiculo.getCor().trim().isEmpty()) {
            return "Cor é obrigatória";
        }

        if (veiculo.getMarca() == null || veiculo.getMarca().trim().isEmpty()) {
            return "Marca é obrigatória";
        }

        if (veiculo.getAno() == null || veiculo.getAno() <= 0) {
            return "Ano é obrigatório e deve ser maior que zero";
        }

        if (veiculo.getCliente() == null) {
            return "Cliente é obrigatório";
        }

        try {
            veiculoRepository.atualizar(veiculo);
            return "Veículo atualizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar veículo: " + e.getMessage();
        }
    }

    @Override
    public String removerVeiculo(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            return "Placa não pode ser nula";
        }

        try {
            veiculoRepository.remover(placa);
            return "Veículo removido com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover veículo: " + e.getMessage();
        }
    }

    @Override
    public List<VeiculoModel> listarTodosVeiculos() {
        return veiculoRepository.listarTodos();
    }
} 