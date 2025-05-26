package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.PagamentoModel;
import java.util.List;

public interface IPagamentoRepository extends IDAO<PagamentoModel> {
    List<PagamentoModel> findByTicketId(Long ticketId);
    List<PagamentoModel> findAll();
    PagamentoModel findById(Long id);
    void save(PagamentoModel pagamento);
    void update(PagamentoModel pagamento);
    void delete(Long id);
}
