package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.FuncionarioModel;
import br.com.estacionamento.interfaces.repositories.IFuncionarioRepository;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class FuncionarioRepository extends BaseDAO<FuncionarioModel> implements IFuncionarioRepository {

    public FuncionarioRepository() {
        super(FuncionarioModel.class);
    }

    @Override
    public FuncionarioModel findByPis(String pis) {
        TypedQuery<FuncionarioModel> query = em.createQuery(
                "SELECT f FROM FuncionarioModel f WHERE f.pis = :pis", FuncionarioModel.class);
        query.setParameter("pis", pis);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<FuncionarioModel> findByCargo(String cargo) {
        return em.createQuery(
                        "SELECT f FROM FuncionarioModel f WHERE f.cargo = :cargo", FuncionarioModel.class)
                .setParameter("cargo", cargo)
                .getResultList();
    }

    @Override
    public List<FuncionarioModel> findByDataAdmissao(LocalDate dataAdmissao) {
        return em.createQuery(
                        "SELECT f FROM FuncionarioModel f WHERE f.dataAdmissao = :dataAdmissao", FuncionarioModel.class)
                .setParameter("dataAdmissao", dataAdmissao)
                .getResultList();
    }

    @Override
    public List<FuncionarioModel> findByEnderecoId(Long enderecoId) {
        return em.createQuery(
                        "SELECT f FROM FuncionarioModel f WHERE f.endereco.id = :enderecoId", FuncionarioModel.class)
                .setParameter("enderecoId", enderecoId)
                .getResultList();
    }
}