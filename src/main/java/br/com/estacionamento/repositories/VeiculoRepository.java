package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.Veiculo;
import br.com.estacionamento.interfaces.repositories.IVeiculoRepository;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository implements IVeiculoRepository {private List<Veiculo> veiculos = new ArrayList<>();

    @Override
    public void salvar(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    @Override
    public void remover(String placa) {
        veiculos.removeIf(v -> v.getPlaca().equals(placa));
    }

    @Override
    public void atualizar(Veiculo veiculo) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getPlaca().equals(veiculo.getPlaca())) {
                veiculos.set(i, veiculo);
                break;
            }
        }
    }

    @Override
    public List<Veiculo> listarTodos() {
        return new ArrayList<>(veiculos);
    }

    @Override
    public Veiculo buscarPorPlaca(String placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);
    }
}
