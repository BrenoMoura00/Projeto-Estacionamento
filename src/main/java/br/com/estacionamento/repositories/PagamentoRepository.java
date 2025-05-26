package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.PagamentoModel;
import br.com.estacionamento.interfaces.repositories.IPagamentoRepository;

import java.util.List;

public class PagamentoRepository extends BaseDAO<PagamentoModel> implements IPagamentoRepository {
    public PagamentoRepository(){
        super(PagamentoModel.class);
    }

    @Override
    public List<PagamentoModel> findByTicketId(Long ticketId) {
        String jpql = "SELECT p FROM PagamentoModel p WHERE p.ticket.id = ?1";
        return executeQuery(jpql, ticketId);
    }

    @Override
    public List<PagamentoModel> findAll() {
        String jpql = "SELECT p FROM PagamentoModel p";
        return executeQuery(jpql);
    }

    @Override
    public PagamentoModel findById(Long id) {
        return read(id.intValue());
    }

    @Override
    public void save(PagamentoModel pagamento) {
        create(pagamento);
    }

    @Override
    public void delete(Long id) {
        delete(id.intValue());
    }

}
