package br.com.estacionamento.view;

import java.math.BigDecimal;
import java.util.List;

import br.com.estacionamento.entities.model.ClienteModel;
import br.com.estacionamento.entities.model.ConvenioModel;
import br.com.estacionamento.entities.model.VeiculoModel;
import br.com.estacionamento.repositories.ClienteRepository;
import br.com.estacionamento.repositories.ConvenioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("estacionamento");
        EntityManager em =  entityManagerFactory.createEntityManager();
        try{
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("TESTE DE TRANSAÇÃO BEM SUCEDIDA");
        }catch(Exception e){
            e.getMessage();
        }

        // ConvenioRepository c = new ConvenioRepository();
        // ConvenioModel model = new ConvenioModel();
        // model.setAtivo(true);
        // model.setNome("top");
        // model.setNomeEmpresa("RECA");
        // model.setQntHoras(24);
        // model.setValor(new BigDecimal(1500.00));
        // model.setQntVagas(10);
        // // c.create(model);
        // for(ConvenioModel co : c.listarTodos()){
        //     System.out.println(co);
        // }

        // for(ClienteModel co : c.listarClientesPorNome("top")){
        //     System.out.println(co);
        // }


    }
}
