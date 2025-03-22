package br.com.estacionamento.repositorios;


import java.util.ArrayList;
import java.util.List;



public class ClienteRepositorio implements IClienteRepositorio {
    private List<Client> list;

    public ClienteRepositorio() {
        this.list = new ArrayList<>();
    }

    @Override
    public void adicionar(Client t) {
        // Task Falcão
    }
}
