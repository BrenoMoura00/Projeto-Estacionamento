package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.TicketModel;
import br.com.estacionamento.interfaces.repositories.ITicketRepository;

public class TicketRepository extends BaseDAO<TicketModel> implements ITicketRepository{
    public TicketRepository(){
        super(TicketModel.class);
    }
}
