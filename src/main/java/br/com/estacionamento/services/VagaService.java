package br.com.estacionamento.services;

import br.com.estacionamento.entities.model.VagaModel;
import br.com.estacionamento.interfaces.services.IVagaService;
import br.com.estacionamento.repositories.VagaRepository;
import java.util.List;

public class VagaService implements IVagaService {
    
    private VagaRepository vagaRepository;

    public VagaService() {
        this.vagaRepository = new VagaRepository();
    }

    @Override
    public String cadastrarVaga(VagaModel vaga) {
        return null;
    }

    @Override
    public VagaModel buscarVagaPorNumero(String numero) {
        return null;
    }

    @Override
    public List<VagaModel> buscarVagasPorTipo(String tipo) {
        return null;
    }

    @Override
    public List<VagaModel> buscarVagasDisponiveis(boolean disponivel) {
        return null;
    }

    @Override
    public List<VagaModel> buscarVagasPorEstacionamento(int estacionamentoId) {
        return null;
    }

    @Override
    public String atualizarVaga(VagaModel vaga) {
        return null;
    }

    @Override
    public String removerVaga(String numero, int estacionamentoId) {
        return null;
    }

    @Override
    public List<VagaModel> listarTodasVagas() {
        return null;
    }
} 