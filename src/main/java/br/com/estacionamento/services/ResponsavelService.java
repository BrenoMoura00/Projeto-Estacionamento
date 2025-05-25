package br.com.estacionamento.services;

import java.util.List;

import br.com.estacionamento.entities.model.ResponsavelModel;
import br.com.estacionamento.interfaces.services.IResponsavelService;
import br.com.estacionamento.repositories.ResponsavelRepository;

public class ResponsavelService implements IResponsavelService {

    private ResponsavelRepository responsavelRepository;

    public ResponsavelService() {
        this.responsavelRepository = new ResponsavelRepository();
    }

    @Override
    public String cadastrarResponsavel(ResponsavelModel responsavel) {
        if (responsavel == null) {
            return "Responsável não pode ser nulo";
        }

        if (responsavel.getCpf() == null || responsavel.getCpf().trim().isEmpty()) {
            return "CPF é obrigatório";
        }

        if (responsavel.getNome() == null || responsavel.getNome().trim().isEmpty()) {
            return "Nome é obrigatório";
        }

        if (responsavel.getEndereco() == null) {
            return "Endereço é obrigatório";
        }

        try {
            responsavelRepository.create(responsavel);
            return "Responsável cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar responsável: " + e.getMessage();
        }
    }

    @Override
    public ResponsavelModel buscarResponsavelPorId(Long id) {
        if (id == null) {
            return null;
        }
        return responsavelRepository.read(id.intValue());
    }

    @Override
    public ResponsavelModel buscarResponsavelPorCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return null;
        }
        return responsavelRepository.findByCpf(cpf);
    }

    @Override
    public String atualizarResponsavel(ResponsavelModel responsavel) {
        if (responsavel == null) {
            return "Responsável não pode ser nulo";
        }

        if (responsavel.getId() == null) {
            return "ID do responsável é obrigatório";
        }

        if (responsavel.getCpf() == null || responsavel.getCpf().trim().isEmpty()) {
            return "CPF é obrigatório";
        }

        if (responsavel.getNome() == null || responsavel.getNome().trim().isEmpty()) {
            return "Nome é obrigatório";
        }

        if (responsavel.getEndereco() == null) {
            return "Endereço é obrigatório";
        }

        try {
            responsavelRepository.update(responsavel);
            return "Responsável atualizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar responsável: " + e.getMessage();
        }
    }

    @Override
    public String removerResponsavel(Long id) {
        if (id == null) {
            return "ID do responsável não pode ser nulo";
        }

        try {
            responsavelRepository.delete(id.intValue());
            return "Responsável removido com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover responsável: " + e.getMessage();
        }
    }

    @Override
    public List<ResponsavelModel> listarTodosResponsaveis() {
        return responsavelRepository.listarTodos();
    }
    
    /*Cadastrar vagas
     * Ver estacionamentos resposavel
     * Consultar quantidade de vagas
     */
}
