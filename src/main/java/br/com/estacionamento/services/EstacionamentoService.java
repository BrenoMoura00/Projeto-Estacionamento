package br.com.estacionamento.services;

import java.util.List;

import br.com.estacionamento.entities.model.EstacionamentoModel;
import br.com.estacionamento.entities.model.FuncionarioModel;
import br.com.estacionamento.entities.model.ResponsavelModel;
import br.com.estacionamento.entities.model.VagaModel;
import br.com.estacionamento.interfaces.services.IEstacionamentoService;
import br.com.estacionamento.repositories.EstacionamentoRepository;

// Nessa porra fica as regras de negocios
public class EstacionamentoService implements IEstacionamentoService {

    private EstacionamentoRepository estacionamentoRepository;

    @Override
    public String cadastrarEstacionamento(EstacionamentoModel estacionamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarEstacionamento'");
    }

    @Override
    public EstacionamentoModel buscarEstacionamentoPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarEstacionamentoPorId'");
    }

    @Override
    public List<EstacionamentoModel> buscarEstacionamentosPorNome(String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarEstacionamentosPorNome'");
    }

    @Override
    public List<EstacionamentoModel> buscarEstacionamentosPorCidade(String cidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarEstacionamentosPorCidade'");
    }

    @Override
    public List<EstacionamentoModel> buscarEstacionamentosPorCapacidade(int capacidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarEstacionamentosPorCapacidade'");
    }

    @Override
    public List<FuncionarioModel> listarFuncionariosPorEstacionamento(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarFuncionariosPorEstacionamento'");
    }

    @Override
    public ResponsavelModel buscarResponsavelPorEstacionamento(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarResponsavelPorEstacionamento'");
    }

    @Override
    public List<VagaModel> listarVagasPorEstacionamento(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarVagasPorEstacionamento'");
    }

    @Override
    public String atualizarEstacionamento(EstacionamentoModel estacionamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarEstacionamento'");
    }

    @Override
    public String removerEstacionamento(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerEstacionamento'");
    }

    @Override
    public List<EstacionamentoModel> listarTodosEstacionamentos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodosEstacionamentos'");
    }
    // Cadastrar um novo estacionamento
    // Listar estacionemtos
    // Puxar Estacionamento especifico e guardar na memoria
}
