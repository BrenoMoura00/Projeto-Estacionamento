package br.com.estacionamento.services;

import br.com.estacionamento.entities.model.ConvenioModel;
import br.com.estacionamento.entities.model.ClienteModel;
import br.com.estacionamento.interfaces.services.IConvenioService;
import br.com.estacionamento.repositories.ConvenioRepository;
import java.util.List;

public class ConvenioService implements IConvenioService {
    
    private ConvenioRepository convenioRepository;

    public ConvenioService() {
        this.convenioRepository = new ConvenioRepository();
    }

    @Override
    public String cadastrarConvenio(ConvenioModel convenio) {
        return null;
    }

    @Override
    public ConvenioModel buscarConvenioPorId(Long id) {
        return null;
    }

    @Override
    public List<ClienteModel> buscarClientesPorNomeConvenio(String nome) {
        return null;
    }

    @Override
    public String atualizarConvenio(ConvenioModel convenio) {
        return null;
    }

    @Override
    public String removerConvenio(Long id) {
        return null;
    }

    @Override
    public List<ConvenioModel> listarTodosConvenios() {
        return null;
    }
} 