package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.EnderecoModel;
import java.util.List;

public interface IEnderecoRepository extends IDAO<EnderecoModel> {
    List<EnderecoModel> findByCidade(String cidade);
    List<EnderecoModel> findByEstado(String estado);
    List<EnderecoModel> findByCep(String cep);
    List<EnderecoModel> findByBairro(String bairro);
    List<EnderecoModel> findByPessoaId(int pessoaId);
}