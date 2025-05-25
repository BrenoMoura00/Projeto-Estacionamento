package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.ConvenioModel;
import br.com.estacionamento.entities.model.ClienteModel;
import java.util.List;

public interface IConvenioService {
    String cadastrarConvenio(ConvenioModel convenio);
    ConvenioModel buscarConvenioPorId(Long id);
    List<ClienteModel> buscarClientesPorNomeConvenio(String nome);
    String atualizarConvenio(ConvenioModel convenio);
    String removerConvenio(Long id);
    List<ConvenioModel> listarTodosConvenios();
} 