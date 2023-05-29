package br.eti.souza.backend.database;

import br.eti.souza.server.Server;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe para verificar banco de dados.
 * @author Alan Moraes Souza
 */
public class Database {

    /** Logger desta classe. */
    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());

    /**
     * Verificar status do banco de dados.
     * @return Status do banco de dados.
     */
    public static boolean check() {
        var connectionProps = new Properties();
        connectionProps.put("user", "souza");
        connectionProps.put("password", "13sharp7");
        try (var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/souzadb", connectionProps)) {
            return true;
        } catch (SQLException e) {
            Database.LOGGER.log(Level.SEVERE, "Ocorreu erro tentando conectar ao banco de dados.", e);
        }
        return false;
    }
}
