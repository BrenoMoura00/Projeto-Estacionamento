package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.ResponsavelModel;
import br.com.estacionamento.interfaces.repositories.IResponsavelRepository;
import java.util.List;

public class ResponsavelRepository extends BaseDAO<ResponsavelModel> implements IResponsavelRepository {
    
    public ResponsavelRepository() {
        super(ResponsavelModel.class);
    }

    @Override
    public ResponsavelModel findByCpf(String cpf) {
        String jpql = "SELECT r FROM ResponsavelModel r WHERE r.cpf = :cpf";
        return em.createQuery(jpql, ResponsavelModel.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
    }

    @Override
    public List<ResponsavelModel> listarTodos() {
        String jpql = "SELECT r FROM ResponsavelModel r";
        return em.createQuery(jpql, ResponsavelModel.class).getResultList();
    }
}
