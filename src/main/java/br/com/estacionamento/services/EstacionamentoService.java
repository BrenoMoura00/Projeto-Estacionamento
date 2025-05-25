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

    public EstacionamentoService() {
        this.estacionamentoRepository = new EstacionamentoRepository();
    }

    @Override
    public String cadastrarEstacionamento(EstacionamentoModel estacionamento) {
        if (estacionamento == null) {
            return "Estacionamento não pode ser nulo";
        }

        if (estacionamento.getTelefone() == null || estacionamento.getTelefone().trim().isEmpty()) {
            return "CNPJ é obrigatório";
        }

        if (estacionamento.getEndereco() == null) {
            return "Endereço é obrigatório";
        }

        if (estacionamento.getResponsavel() == null) {
            return "Responsável é obrigatório";
        }

        try {
            estacionamentoRepository.create(estacionamento);
            return "Estacionamento cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar estacionamento: " + e.getMessage();
        }
    }

    @Override
    public EstacionamentoModel buscarEstacionamentoPorId(Long id) {
        if (id == null) {
            return null;
        }
        return estacionamentoRepository.read(id.intValue());
    }

    @Override
    public List<EstacionamentoModel> buscarEstacionamentosPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }
        return estacionamentoRepository.findByNome(nome);
    }

    @Override
    public List<EstacionamentoModel> buscarEstacionamentosPorCidade(String cidade) {
        if (cidade == null || cidade.trim().isEmpty()) {
            return null;
        }
        return estacionamentoRepository.findByCidade(cidade);
    }

    @Override
    public List<EstacionamentoModel> buscarEstacionamentosPorCapacidade(int capacidade) {
        if (capacidade <= 0) {
            return null;
        }
        return estacionamentoRepository.findByCapacidadeGreaterThan(capacidade);
    }

    @Override
    public List<FuncionarioModel> listarFuncionariosPorEstacionamento(Long id) {
        if (id == null) {
            return null;
        }
        return estacionamentoRepository.ListarFuncionarioPeloId(id);
    }

    @Override
    public ResponsavelModel buscarResponsavelPorEstacionamento(Long id) {
        if (id == null) {
            return null;
        }
        return estacionamentoRepository.ListarResponsavelPorId(id);
    }

    @Override
    public List<VagaModel> listarVagasPorEstacionamento(Long id) {
        if (id == null) {
            return null;
        }
        return estacionamentoRepository.ListarVagasPeloId(id);
    }

    @Override
    public String atualizarEstacionamento(EstacionamentoModel estacionamento) {
        if (estacionamento == null) {
            return "Estacionamento não pode ser nulo";
        }

        if (estacionamento.getId() == null) {
            return "ID do estacionamento é obrigatório";
        }

        if (estacionamento.getTelefone() == null || estacionamento.getTelefone().trim().isEmpty()) {
            return "CNPJ é obrigatório";
        }

        if (estacionamento.getEndereco() == null) {
            return "Endereço é obrigatório";
        }

        if (estacionamento.getResponsavel() == null) {
            return "Responsável é obrigatório";
        }

        try {
            estacionamentoRepository.update(estacionamento);
            return "Estacionamento atualizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar estacionamento: " + e.getMessage();
        }
    }

    @Override
    public String removerEstacionamento(Long id) {
        if (id == null) {
            return "ID do estacionamento não pode ser nulo";
        }

        try {
            estacionamentoRepository.delete(id.intValue());
            return "Estacionamento removido com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover estacionamento: " + e.getMessage();
        }
    }

    @Override
    public List<EstacionamentoModel> listarTodosEstacionamentos() {
        return estacionamentoRepository.listarTodos();
    }
    // Cadastrar um novo estacionamento
    // Listar estacionemtos
    // Puxar Estacionamento especifico e guardar na memoria
}
