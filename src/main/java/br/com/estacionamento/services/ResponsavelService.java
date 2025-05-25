package br.com.estacionamento.services;

import java.util.List;

import br.com.estacionamento.entities.model.ResponsavelModel;
import br.com.estacionamento.interfaces.repositories.IResponsavelRepository;
import br.com.estacionamento.interfaces.services.IResponsavelService;
import br.com.estacionamento.repositories.ResponsavelRepository;

public class ResponsavelService implements IResponsavelService{

    private ResponsavelRepository responsavelRepository;

    @Override
    public String atualizarResponsavel(ResponsavelModel responsavel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponsavelModel buscarResponsavelPorCpf(String cpf) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponsavelModel buscarResponsavelPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String cadastrarResponsavel(ResponsavelModel responsavel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ResponsavelModel> listarTodosResponsaveis() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String removerResponsavel(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    /*Cadastrar vagas
     * Ver estacionamentos resposavel
     * Consultar quantidade de vagas
     */
}
