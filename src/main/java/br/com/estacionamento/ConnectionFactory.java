package br.com.estacionamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection recuperarconexao() {
        try {
            return DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/nexus-bank?user=NexusBank&password=Nexus");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
