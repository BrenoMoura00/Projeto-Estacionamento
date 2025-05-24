package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.ClienteModel;
import br.com.estacionamento.entities.model.ConvenioModel;
import br.com.estacionamento.entities.model.ReservaModel;
import br.com.estacionamento.entities.model.TicketModel;
import br.com.estacionamento.entities.model.VeiculoModel;

import java.util.List;

public interface IClienteRepository extends IDAO<ClienteModel> {
    ClienteModel buscarPorCpf(String cpf);
    ConvenioModel buscarConvenioPorCpf(String cpf);
    List<VeiculoModel> listarVeiculosPorCpf(String cpf);
    List<TicketModel> listarTicketsPorCpf(String cpf);
    List<ReservaModel> listarReservasPorCpf(String cpf);
    boolean existePorCpf(String cpf);
    void deletarPorCpf(String cpf);
}
