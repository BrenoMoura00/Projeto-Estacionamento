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
        if (vaga == null) {
            return "Vaga não pode ser nula";
        }

        if (vaga.getNumero() == null) {
            return "Número da vaga é obrigatório";
        }

        if (vaga.getSetor() == null || vaga.getSetor().trim().isEmpty()) {
            return "Setor é obrigatório";
        }

        if (vaga.getAndar() == null || vaga.getAndar().trim().isEmpty()) {
            return "Andar é obrigatório";
        }

        if (vaga.getEstacionamento() == null) {
            return "Estacionamento é obrigatório";
        }

        try {
            vagaRepository.create(vaga);
            return "Vaga cadastrada com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar vaga: " + e.getMessage();
        }
    }

    @Override
    public VagaModel buscarVagaPorNumero(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            return null;
        }
        List<VagaModel> vagas = vagaRepository.findByNumero(numero);
        return vagas.isEmpty() ? null : vagas.get(0);
    }

    @Override
    public List<VagaModel> buscarVagasPorTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            return null;
        }
        return vagaRepository.findByTipo(tipo);
    }

    @Override
    public List<VagaModel> buscarVagasDisponiveis(boolean disponivel) {
        return vagaRepository.findByDisponivel(disponivel);
    }

    @Override
    public List<VagaModel> buscarVagasPorEstacionamento(int estacionamentoId) {
        if (estacionamentoId <= 0) {
            return null;
        }
        return vagaRepository.findByEstacionamentoId(estacionamentoId);
    }

    @Override
    public String atualizarVaga(VagaModel vaga) {
        if (vaga == null) {
            return "Vaga não pode ser nula";
        }

        if (vaga.getId() == null) {
            return "ID da vaga é obrigatório";
        }

        if (vaga.getNumero() == null) {
            return "Número da vaga é obrigatório";
        }

        if (vaga.getSetor() == null || vaga.getSetor().trim().isEmpty()) {
            return "Setor é obrigatório";
        }

        if (vaga.getAndar() == null || vaga.getAndar().trim().isEmpty()) {
            return "Andar é obrigatório";
        }

        if (vaga.getEstacionamento() == null) {
            return "Estacionamento é obrigatório";
        }

        try {
            vagaRepository.update(vaga);
            return "Vaga atualizada com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar vaga: " + e.getMessage();
        }
    }

    @Override
    public String removerVaga(String numero, int estacionamentoId) {
        if (numero == null || numero.trim().isEmpty()) {
            return "Número da vaga não pode ser nulo";
        }

        if (estacionamentoId <= 0) {
            return "ID do estacionamento inválido";
        }

        try {
            VagaModel vaga = vagaRepository.findByNumeroAndEstacionamentoId(numero, estacionamentoId);
            if (vaga == null) {
                return "Vaga não encontrada";
            }
            vagaRepository.delete(vaga.getId().intValue());
            return "Vaga removida com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover vaga: " + e.getMessage();
        }
    }

    @Override
    public List<VagaModel> listarTodasVagas() {
        return vagaRepository.listarTodos();
    }
} 