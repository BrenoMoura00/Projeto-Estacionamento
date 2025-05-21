package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.EnderecoModel;
import br.com.estacionamento.interfaces.repositories.IEnderecoRepository;
import java.util.List;

public class EnderecoRepository extends BaseDAO<EnderecoModel> implements IEnderecoRepository {

    public EnderecoRepository() {
        super(EnderecoModel.class);
    }

    @Override
    public List<EnderecoModel> findByCidade(String cidade) {
        return executeQuery("SELECT e FROM EnderecoModel e WHERE e.cidade = :cidade", cidade);
    }

    @Override
    public List<EnderecoModel> findByEstado(String estado) {
        return executeQuery("SELECT e FROM EnderecoModel e WHERE e.estado = :estado", estado);
    }

    @Override
    public List<EnderecoModel> findByCep(String cep) {
        return executeQuery("SELECT e FROM EnderecoModel e WHERE e.cep = :cep", cep);
    }

    @Override
    public List<EnderecoModel> findByBairro(String bairro) {
        return executeQuery("SELECT e FROM EnderecoModel e WHERE e.bairro = :bairro", bairro);
    }

    @Override
    public List<EnderecoModel> findByPessoaId(int pessoaId) {
        return executeQuery("SELECT e FROM EnderecoModel e WHERE e.pessoa.id = :pessoaId", pessoaId);
    }
}