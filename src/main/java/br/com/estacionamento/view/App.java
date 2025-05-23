package br.com.estacionamento.view;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("estacionamento");
        EntityManager em =  entityManagerFactory.createEntityManager();
        // this.emf = Persistence.createEntityManagerFactory("estacionamento");
        // this.em = emf.createEntityManager();
        System.out.println("Conexão bem sucessidada");
    }
}
