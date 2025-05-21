package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.FuncionarioModel;
import java.util.List;

public interface IFuncionarioRepository extends IDAO<FuncionarioModel> {
    FuncionarioModel findByPis(String pis);
    List<FuncionarioModel> findByCargo(String cargo);
    List<FuncionarioModel> findByDataAdmissao(java.time.LocalDate dataAdmissao);
    List<FuncionarioModel> findByEnderecoId(Long enderecoId);
}
