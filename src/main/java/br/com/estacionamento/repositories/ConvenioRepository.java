package br.com.estacionamento.repositories;

import java.util.List;

import br.com.estacionamento.entities.model.ClienteModel;
import br.com.estacionamento.entities.model.ConvenioModel;
import br.com.estacionamento.interfaces.repositories.IConvenioRepository;

public class ConvenioRepository extends BaseDAO<ConvenioModel> implements IConvenioRepository {

    public ConvenioRepository() {
        super(ConvenioModel.class);
    }

    @Override
    public List<ClienteModel> listarClientesPorNome(String nome) {
        String JPQL = "SELECT cliente FROM ClienteModel cliente WHERE cliente.convenio.nome = :nome";
        return em.createQuery(JPQL,ClienteModel.class)
        .setParameter("nome", nome)
        .getResultList();
    }

    @Override
    public List<ConvenioModel> listarTodos() {
        String jpql = "SELECT c FROM ConvenioModel c";
        return em.createQuery(jpql, ConvenioModel.class)
             .getResultList();
    }

    

}
