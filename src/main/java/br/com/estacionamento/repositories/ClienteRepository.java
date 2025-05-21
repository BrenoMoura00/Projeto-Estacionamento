package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.ClienteModel;
import br.com.estacionamento.interfaces.repositories.IClienteRepository;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ClienteRepository extends BaseDAO<ClienteModel> implements IClienteRepository {

    public ClienteRepository() {
        super(ClienteModel.class);
    }

    @Override
    public ClienteModel buscarPorCpf(String cpf) {
        TypedQuery<ClienteModel> query = em.createQuery(
                "SELECT c FROM ClienteModel c WHERE c.cpf = :cpf", ClienteModel.class);
        query.setParameter("cpf", cpf);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<ClienteModel> listarComVeiculos() {
        return em.createQuery(
                "SELECT DISTINCT c FROM ClienteModel c LEFT JOIN FETCH c.veiculos",
                ClienteModel.class).getResultList();
    }

    @Override
    public boolean existePorCpf(String cpf) {
        Long count = em.createQuery(
                        "SELECT COUNT(c) FROM ClienteModel c WHERE c.cpf = :cpf", Long.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public void deletarPorCpf(String cpf) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            // Busca o cliente pelo CPF
            ClienteModel cliente = em.createQuery(
                            "SELECT c FROM ClienteModel c WHERE c.cpf = :cpf", ClienteModel.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();

            // Remove o cliente
            em.remove(cliente);

            transaction.commit();
        } catch (NoResultException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Cliente com CPF " + cpf + " não encontrado", e);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao deletar cliente", e);
        }
    }
}