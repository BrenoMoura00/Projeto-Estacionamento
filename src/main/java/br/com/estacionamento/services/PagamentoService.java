package br.com.estacionamento.services;

import br.com.estacionamento.entities.model.PagamentoModel;
import br.com.estacionamento.interfaces.services.IPagamentoService;
import br.com.estacionamento.repositories.PagamentoRepository;
import java.util.List;

public class PagamentoService implements IPagamentoService {
    
    private PagamentoRepository pagamentoRepository;

    public PagamentoService() {
        this.pagamentoRepository = new PagamentoRepository();
    }

    @Override
    public String cadastrarPagamento(PagamentoModel pagamento) {
        return null;
    }

    @Override
    public PagamentoModel buscarPagamentoPorId(Long id) {
        return null;
    }

    @Override
    public List<PagamentoModel> buscarPagamentosPorTicket(Long ticketId) {
        return null;
    }

    @Override
    public String atualizarPagamento(PagamentoModel pagamento) {
        return null;
    }

    @Override
    public String removerPagamento(Long id) {
        return null;
    }

    @Override
    public List<PagamentoModel> listarTodosPagamentos() {
        return null;
    }
} 