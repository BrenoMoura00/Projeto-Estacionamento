package br.com.estacionamento.server;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


class IndexHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String textoResposta = "Isso é um teste do servidor JAVA PURO";
        // Converte texto em Bytes
        byte[] bs = textoResposta.getBytes("UTF-8");
        // Seta o Headers para o tamanho dos bytes enviados
        exchange.sendResponseHeaders(200, bs.length);
        // Cria uma Stream de de dados de resposta
        try (OutputStream os = exchange.getResponseBody()) {
            // Escreve na stream em bytes
            os.write(bs);
            os.close();
        }
        // So debug Mesmo
        System.out.println("Rota Acessada" + exchange.getRequestURI() + "\n Requisição finalizada");
    }
}
