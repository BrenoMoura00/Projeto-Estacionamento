package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.ClienteModel;
import br.com.estacionamento.entities.model.ConvenioModel;
import br.com.estacionamento.entities.model.ReservaModel;
import br.com.estacionamento.entities.model.TicketModel;
import br.com.estacionamento.entities.model.VeiculoModel;
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

    // @Override
    // public List<VeiculoModel> () {
    //     return null
    // }
    

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

    @Override
    public List<TicketModel> listarTicketsPorCpf(String cpf) {
        // Negocio complicado do JABO
        String JPQL = "SELECT ticket FROM TicketModel ticket WHERE ticket.cliente.cpf = :cpf";
        
        List<TicketModel> listTickets = em.createQuery(JPQL,TicketModel.class)
        .setParameter("cpf", cpf)
        .getResultList();
        return listTickets;
    }

    @Override
    public List<VeiculoModel> listarVeiculosPorCpf(String cpf) {
        String JPQL = "SELECT veiculo FROM VeiculoModel veiculo WHERE veiculo.cliente.cpf = :cpf";
        
        List<VeiculoModel> listVeiculos = em.createQuery(JPQL,VeiculoModel.class)
        .setParameter("cpf", cpf)
        .getResultList();
        
        return listVeiculos;
        // return null;
    }

    @Override
    public ConvenioModel buscarConvenioPorCpf(String cpf) {
        String JPQL = "SELECT convenio FROM ConvenioModel convenio WHERE convenio.cliente.cpf = :cpf";
        ConvenioModel convenioModel = em.createQuery(JPQL,ConvenioModel.class)
        .setParameter("cpf", cpf)
        .getSingleResult();

        return convenioModel;
    }

    @Override
    public List<ReservaModel> listarReservasPorCpf(String cpf) {
        String JPQL = "SELECT reserva FROM ReservaModel reserva where reservar.cliente.cpf = :cpf";
        List<ReservaModel> listReservas = em.createQuery(JPQL,ReservaModel.class)
        .setParameter("cpf", cpf)
        .getResultList();
        
        return listReservas;
    }

    public List<ClienteModel> listarTodos() {
        String jpql = "SELECT c FROM ClienteModel c";
        return em.createQuery(jpql, ClienteModel.class).getResultList();
    }
}