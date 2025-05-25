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
        if (convenio == null) {
            return "Convênio não pode ser nulo";
        }

        if (convenio.getNome() == null || convenio.getNome().trim().isEmpty()) {
            return "Nome do convênio é obrigatório";
        }

        if (convenio.getNomeEmpresa() == null || convenio.getNomeEmpresa().trim().isEmpty()) {
            return "Nome da empresa é obrigatório";
        }

        if (convenio.getValor() == null || convenio.getValor().compareTo(java.math.BigDecimal.ZERO) <= 0) {
            return "Valor deve ser maior que zero";
        }

        if (convenio.getQntHoras() == null || convenio.getQntHoras() <= 0) {
            return "Quantidade de horas deve ser maior que zero";
        }

        if (convenio.getQntVagas() == null || convenio.getQntVagas() <= 0) {
            return "Quantidade de vagas deve ser maior que zero";
        }

        try {
            convenioRepository.create(convenio);
            return "Convênio cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar convênio: " + e.getMessage();
        }
    }

    @Override
    public ConvenioModel buscarConvenioPorId(Long id) {
        if (id == null) {
            return null;
        }
        return convenioRepository.read(id.intValue());
    }

    @Override
    public List<ClienteModel> buscarClientesPorNomeConvenio(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }
        return convenioRepository.listarClientesPorNome(nome);
    }

    @Override
    public String atualizarConvenio(ConvenioModel convenio) {
        if (convenio == null) {
            return "Convênio não pode ser nulo";
        }

        if (convenio.getId() == null) {
            return "ID do convênio é obrigatório";
        }

        if (convenio.getNome() == null || convenio.getNome().trim().isEmpty()) {
            return "Nome do convênio é obrigatório";
        }

        if (convenio.getNomeEmpresa() == null || convenio.getNomeEmpresa().trim().isEmpty()) {
            return "Nome da empresa é obrigatório";
        }

        if (convenio.getValor() == null || convenio.getValor().compareTo(java.math.BigDecimal.ZERO) <= 0) {
            return "Valor deve ser maior que zero";
        }

        if (convenio.getQntHoras() == null || convenio.getQntHoras() <= 0) {
            return "Quantidade de horas deve ser maior que zero";
        }

        if (convenio.getQntVagas() == null || convenio.getQntVagas() <= 0) {
            return "Quantidade de vagas deve ser maior que zero";
        }

        try {
            convenioRepository.update(convenio);
            return "Convênio atualizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar convênio: " + e.getMessage();
        }
    }

    @Override
    public String removerConvenio(Long id) {
        if (id == null) {
            return "ID do convênio não pode ser nulo";
        }

        try {
            convenioRepository.delete(id.intValue());
            return "Convênio removido com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover convênio: " + e.getMessage();
        }
    }

    @Override
    public List<ConvenioModel> listarTodosConvenios() {
        return convenioRepository.listarTodos();
    }
} 