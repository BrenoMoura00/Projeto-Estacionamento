package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.VagaModel;
import java.util.List;

public interface IVagaService {
    String cadastrarVaga(VagaModel vaga);
    VagaModel buscarVagaPorNumero(String numero);
    List<VagaModel> buscarVagasPorTipo(String tipo);
    List<VagaModel> buscarVagasDisponiveis(boolean disponivel);
    List<VagaModel> buscarVagasPorEstacionamento(int estacionamentoId);
    String atualizarVaga(VagaModel vaga);
    String removerVaga(String numero, int estacionamentoId);
    List<VagaModel> listarTodasVagas();
} 