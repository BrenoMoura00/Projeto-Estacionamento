package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.EstacionamentoModel;
import br.com.estacionamento.interfaces.repositories.IEstacionamentoRepository;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class EstacionamentoRepository extends BaseDAO<EstacionamentoModel> implements IEstacionamentoRepository {

    public EstacionamentoRepository() {
        super(EstacionamentoModel.class);
    }

    @Override
    public List<EstacionamentoModel> findByNome(String nome) {
        return executeQuery("SELECT e FROM EstacionamentoModel e WHERE e.nome LIKE :nome", "%" + nome + "%");
    }

    @Override
    public List<EstacionamentoModel> findByCidade(String cidade) {
        return executeQuery("SELECT e FROM EstacionamentoModel e WHERE e.endereco.cidade = :cidade", cidade);
    }

    @Override
    public List<EstacionamentoModel> findByCapacidadeGreaterThan(int capacidade) {
        return executeQuery(
                "SELECT e FROM EstacionamentoModel e WHERE e.capacidade > :capacidade",
                capacidade
        );
    }
}