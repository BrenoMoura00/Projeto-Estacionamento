package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.VagaModel;
import br.com.estacionamento.interfaces.repositories.IVagaRepository;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class VagaRepository extends BaseDAO<VagaModel> implements IVagaRepository {

    public VagaRepository() {
        super(VagaModel.class);
    }

    @Override
    public List<VagaModel> findByNumero(String numero) {
        return executeQuery("SELECT v FROM VagaModel v WHERE v.numero = :numero", numero);
    }

    @Override
    public List<VagaModel> findByTipo(String tipo) {
        return executeQuery("SELECT v FROM VagaModel v WHERE v.tipo = :tipo", tipo);
    }

    @Override
    public List<VagaModel> findByDisponivel(boolean disponivel) {
        return executeQuery("SELECT v FROM VagaModel v WHERE v.disponivel = :disponivel", disponivel);
    }

    @Override
    public List<VagaModel> findByEstacionamentoId(int estacionamentoId) {
        return executeQuery(
                "SELECT v FROM VagaModel v WHERE v.estacionamento.id = :estacionamentoId",
                estacionamentoId
        );
    }

    @Override
    public VagaModel findByNumeroAndEstacionamentoId(String numero, int estacionamentoId) {
        TypedQuery<VagaModel> query = em.createQuery(
                "SELECT v FROM VagaModel v WHERE v.numero = :numero AND v.estacionamento.id = :estacionamentoId",
                VagaModel.class
        );
        query.setParameter("numero", numero);
        query.setParameter("estacionamentoId", estacionamentoId);
        return query.getSingleResult();
    }

    @Override
    public List<VagaModel> listarTodos() {
        String jpql = "SELECT v FROM VagaModel v";
        return em.createQuery(jpql, VagaModel.class).getResultList();
    }
}