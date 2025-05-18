package br.com.estacionamento.view;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.estacionamento.jpa");
        System.out.println("Conexão bem sucessidada");
    }
}
