package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.PagamentoModel;
import br.com.estacionamento.interfaces.repositories.IPagamentoRepository;

public class PagamentoRepository extends BaseDAO<PagamentoModel> implements IPagamentoRepository {
    public PagamentoRepository(){
        super(PagamentoModel.class);
    }
}
