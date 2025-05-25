package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.EstacionamentoModel;
import br.com.estacionamento.entities.model.FuncionarioModel;
import br.com.estacionamento.entities.model.ResponsavelModel;
import br.com.estacionamento.entities.model.VagaModel;
import br.com.estacionamento.interfaces.repositories.IEstacionamentoRepository;
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

    @Override
    public List<EstacionamentoModel> listarTodos() {
        String jpql = "SELECT e FROM EstacionamentoModel e";
        return em.createQuery(jpql, EstacionamentoModel.class).getResultList();
    }

    @Override
    public List<FuncionarioModel> ListarFuncionarioPeloId(Long id) {
        String JPQL = "SELECT funcionario FROM FuncionarioModel funcionario WHERE funcionario.estacionamento.id = :id";
        List<FuncionarioModel> listFuncionario = em.createQuery(JPQL,FuncionarioModel.class)
        .setParameter("id", id)
        .getResultList();
        return listFuncionario;
    }

    @Override
    public ResponsavelModel ListarResponsavelPorId(Long id) {
        String JPQL = "SELECT estacionamento.responsavel FROM EstacionamentoModel estacionamento WHERE estacionamento.id = :id";
        ResponsavelModel responsavel = em.createQuery(JPQL,ResponsavelModel.class)
        .setParameter("id", id)
        .getSingleResult();
        return responsavel;
    }

    @Override
    public List<VagaModel> ListarVagasPeloId(Long id) {
        String JPQL = "SELECT vaga FROM VagaModel vaga WHERE vaga.estacionamento.id = :id";
        List<VagaModel> listVagas = em.createQuery(JPQL,VagaModel.class)
        .setParameter("id", id)
        .getResultList();
        return listVagas;
        // return null;
    }

    
}