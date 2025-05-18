package br.com.estacionamento.repositories;

import br.com.estacionamento.interfaces.repositories.IDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BaseDAO <T> implements IDAO {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("org.hibernate.estacionamento.jpa");

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private final Class<T> type;

    public BaseDAO(Class<T> type) {
        this.type = type;
    }

    @Override
    public void create(Object objeto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Object read(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(type, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Object objeto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            T objeto = em.find(type, id);
            if (objeto != null) {
                em.remove(objeto);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
