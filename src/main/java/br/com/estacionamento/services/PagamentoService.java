package br.com.estacionamento.services;

import br.com.estacionamento.entities.model.PagamentoModel;
import br.com.estacionamento.interfaces.services.IPagamentoService;
import br.com.estacionamento.repositories.PagamentoRepository;
import java.time.LocalDate;
import java.util.List;

public class PagamentoService implements IPagamentoService {

    private PagamentoRepository pagamentoRepository;
    private TicketService ticketService;

    public PagamentoService() {
        this.pagamentoRepository = new PagamentoRepository();
        this.ticketService = new TicketService();
    }

    @Override
    public String cadastrarPagamento(PagamentoModel pagamento) {
        try {
            if (pagamento == null) {
                return "Erro: Pagamento não pode ser nulo";
            }
            if (pagamento.getValor() == null || pagamento.getValor() <= 0) {
                return "Erro: Valor do pagamento inválido";
            }
            if (pagamento.getTicket() == null || pagamento.getTicket().getId() <= 0) {
                return "Erro: Ticket inválido";
            }

            var ticket = ticketService.buscarTicketPorId(pagamento.getTicket().getId());
            if (ticket == null) {
                return "Erro: Ticket não encontrado";
            }

            var pagamentosExistentes = buscarPagamentosPorTicket(pagamento.getTicket().getId());
            if (!pagamentosExistentes.isEmpty()) {
                return "Erro: Já existe pagamento para este ticket";
            }

            pagamento.setData_pagamento(LocalDate.now());
            pagamentoRepository.save(pagamento);

            return "Pagamento cadastrado com sucesso";
        } catch (Exception e) {
            return "Erro ao cadastrar pagamento: " + e.getMessage();
        }
    }

    @Override
    public PagamentoModel buscarPagamentoPorId(Long id) {
        try {
            if (id == null || id <= 0) {
                return null;
            }
            return pagamentoRepository.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PagamentoModel> buscarPagamentosPorTicket(Long ticketId) {
        try {
            if (ticketId == null || ticketId <= 0) {
                return null;
            }
            return pagamentoRepository.findByTicketId(ticketId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String atualizarPagamento(PagamentoModel pagamento) {
        try {
            if (pagamento == null || pagamento.getId() <= 0) {
                return "Erro: Pagamento inválido";
            }
            var pagamentoExistente = buscarPagamentoPorId(pagamento.getId());
            if (pagamentoExistente == null) {
                return "Erro: Pagamento não encontrado";
            }
            if (pagamento.getValor() != null && pagamento.getValor() > 0) {
                pagamentoExistente.setValor(pagamento.getValor());
            } else {
                return "Erro: Valor do pagamento inválido";
            }

            pagamentoRepository.update(pagamentoExistente);

            return "Pagamento atualizado com sucesso";
        } catch (Exception e) {
            return "Erro ao atualizar pagamento: " + e.getMessage();
        }
    }

    @Override
    public String removerPagamento(Long id) {
        try {
            if (id == null || id <= 0) {
                return "Erro: ID inválido";
            }

            var pagamento = buscarPagamentoPorId(id);
            if (pagamento == null) {
                return "Erro: Pagamento não encontrado";
            }
            pagamentoRepository.delete(id);

            return "Pagamento removido com sucesso";
        } catch (Exception e) {
            return "Erro ao remover pagamento: " + e.getMessage();
        }
    }

    @Override
    public List<PagamentoModel> listarTodosPagamentos() {
        try {
            return pagamentoRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }
} 