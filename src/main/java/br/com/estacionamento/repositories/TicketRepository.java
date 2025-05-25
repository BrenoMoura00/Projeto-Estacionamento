package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.TicketModel;
import br.com.estacionamento.interfaces.repositories.ITicketRepository;
import java.util.List;

public class TicketRepository extends BaseDAO<TicketModel> implements ITicketRepository {
    
    public TicketRepository() {
        super(TicketModel.class);
    }

    @Override
    public List<TicketModel> findByClienteCpf(String cpf) {
        String jpql = "SELECT t FROM TicketModel t WHERE t.cliente.cpf = :cpf";
        return em.createQuery(jpql, TicketModel.class)
                .setParameter("cpf", cpf)
                .getResultList();
    }

    @Override
    public List<TicketModel> listarTodos() {
        String jpql = "SELECT t FROM TicketModel t";
        return em.createQuery(jpql, TicketModel.class).getResultList();
    }
}
