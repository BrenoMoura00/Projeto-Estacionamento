package br.com.estacionamento.interfaces.repositories;

import java.util.List;

import br.com.estacionamento.entities.model.ClienteModel;
import br.com.estacionamento.entities.model.ConvenioModel;

public interface IConvenioRepository extends IDAO<ConvenioModel>{

    public List<ClienteModel> listarClientesPorNome(String nome);
    public List<ConvenioModel> listarTodos();
    
}
