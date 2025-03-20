package br.com.estacionamento.repositorios;


import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Client;

public class ClienteRepositorio implements Dao<Client>{
    private List<Client> list;

    public ClienteRepositorio() {
        this.list = new ArrayList<>();
    }

    @Override
    public void adicionar(Client t) {
        // Task Falcão
    }
}
