package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.ResponsavelModel;
import java.util.List;

public interface IResponsavelService {
    String cadastrarResponsavel(ResponsavelModel responsavel);
    ResponsavelModel buscarResponsavelPorId(Long id);
    ResponsavelModel buscarResponsavelPorCpf(String cpf);
    String atualizarResponsavel(ResponsavelModel responsavel);
    String removerResponsavel(Long id);
    List<ResponsavelModel> listarTodosResponsaveis();
} 