package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.ResponsavelModel;
import java.util.List;

public interface IResponsavelRepository extends IDAO<ResponsavelModel> {
    ResponsavelModel findByCpf(String cpf);
    List<ResponsavelModel> listarTodos();
}
