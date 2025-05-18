package br.com.estacionamento.interfaces.repositories;

public interface IDAO<T>{
    void create(T objeto);
    T read(int id);
    void update(T objeto);
    void delete(int id);
}
