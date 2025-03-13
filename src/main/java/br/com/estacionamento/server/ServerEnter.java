package br.com.estacionamento.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class ServerEnter {
    public static void main(String[] args) {
        try {
            // Define a porta e numero de conexões simultaneas, alem da propria URI 
            HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
            // As Rotas são registradas nessa função
            RegisterRoutes(server);
            server.start();
            System.out.println("Servidor rodando em http://localhost:8000/");
        } catch (IOException ex) {
            //Salvar o erro em algum sistema de log futuramente
            System.out.println(ex.getMessage());
        }
    }

    private static void RegisterRoutes(HttpServer server){
        // Pagina principal do Servidor
        server.createContext("/",new IndexHandler());
    }
}

