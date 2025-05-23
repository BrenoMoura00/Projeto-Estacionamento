package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.ClienteModel;
import br.com.estacionamento.entities.model.TicketModel;
import br.com.estacionamento.entities.model.VeiculoModel;

import java.util.List;

public interface IClienteRepository extends IDAO<ClienteModel> {
    
    ClienteModel buscarPorCpf(String cpf);
    List<VeiculoModel> listarVeiculos();
    List<TicketModel> listarTickets();
    boolean existePorCpf(String cpf);
    void deletarPorCpf(String cpf);
    
}
