package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.EstacionamentoModel;
import br.com.estacionamento.entities.model.FuncionarioModel;
import br.com.estacionamento.entities.model.ResponsavelModel;
import br.com.estacionamento.entities.model.VagaModel;

import java.util.List;

public interface IEstacionamentoRepository extends IDAO<EstacionamentoModel> {
    List<EstacionamentoModel> findByNome(String nome);
    List<EstacionamentoModel> findByCidade(String cidade);
    List<EstacionamentoModel> findByCapacidadeGreaterThan(int capacidade);
    List<EstacionamentoModel> listarTodos();

    List<VagaModel> ListarVagasPeloId(Long id);
    List<FuncionarioModel> ListarFuncionarioPeloId(Long id);
    ResponsavelModel ListarResponsavelPorId(Long id);
}