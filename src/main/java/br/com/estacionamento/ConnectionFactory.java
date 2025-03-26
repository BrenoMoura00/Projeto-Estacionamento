package br.com.estacionamento;

import br.com.estacionamento.helpers.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection recuperarconexao() {
        try {
            return DriverManager
                    .getConnection(Constants.URL_DATABASE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
