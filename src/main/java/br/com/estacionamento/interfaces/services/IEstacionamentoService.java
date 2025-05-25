package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.EstacionamentoModel;
import br.com.estacionamento.entities.model.FuncionarioModel;
import br.com.estacionamento.entities.model.ResponsavelModel;
import br.com.estacionamento.entities.model.VagaModel;
import java.util.List;

public interface IEstacionamentoService {
    String cadastrarEstacionamento(EstacionamentoModel estacionamento);
    EstacionamentoModel buscarEstacionamentoPorId(Long id);
    List<EstacionamentoModel> buscarEstacionamentosPorNome(String nome);
    List<EstacionamentoModel> buscarEstacionamentosPorCidade(String cidade);
    List<EstacionamentoModel> buscarEstacionamentosPorCapacidade(int capacidade);
    List<FuncionarioModel> listarFuncionariosPorEstacionamento(Long id);
    ResponsavelModel buscarResponsavelPorEstacionamento(Long id);
    List<VagaModel> listarVagasPorEstacionamento(Long id);
    String atualizarEstacionamento(EstacionamentoModel estacionamento);
    String removerEstacionamento(Long id);
    List<EstacionamentoModel> listarTodosEstacionamentos();
} 