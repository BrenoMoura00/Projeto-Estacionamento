package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.ClienteModel;
import java.util.List;

public interface IClienteRepository extends IDAO<ClienteModel> {
    ClienteModel buscarPorCpf(String cpf);
    List<ClienteModel> listarComVeiculos();
    boolean existePorCpf(String cpf);
    void deletarPorCpf(String cpf);
}
