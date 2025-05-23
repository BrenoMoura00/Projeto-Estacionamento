package br.com.estacionamento.view;

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
    }
}
