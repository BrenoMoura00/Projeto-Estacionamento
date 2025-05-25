package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.PagamentoModel;
import java.util.List;

public interface IPagamentoService {
    String cadastrarPagamento(PagamentoModel pagamento);
    PagamentoModel buscarPagamentoPorId(Long id);
    List<PagamentoModel> buscarPagamentosPorTicket(Long ticketId);
    String atualizarPagamento(PagamentoModel pagamento);
    String removerPagamento(Long id);
    List<PagamentoModel> listarTodosPagamentos();
} 