package br.eti.souza.sql;

import br.eti.souza.exception.SystemException;
import br.eti.souza.logger.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Pool de conexões.
 * @author Alan Moraes Souza
 */
public class ConnectionPool {

    /** Se está configurado */
    private static boolean CONFIGURED = true;
    /** URL conexão jdbc. */
    private static String URL;
    /** SQL para test da conexão. */
    private static String SQL_TEST;

    /** Ler as configurações. */
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            ConnectionPool.CONFIGURED = false;
            Logger.error(new SystemException("erro.creating.connection.poll.instance.could.not.init.jdbc.driver"));
        }
        ConnectionPool.URL = System.getenv("SOUZA_DB_URL");
        if ((ConnectionPool.URL == null) || ConnectionPool.URL.isBlank()) {
            ConnectionPool.CONFIGURED = false;
            Logger.error(new SystemException("erro.creating.connection.poll.instance.invalid.jdbc.url"));
        }
        ConnectionPool.SQL_TEST = "SELECT 1";
    }

    /**
     * Obtem uma conexão JDBC com o banco de dados.
     * @return Conexão JDBC.
     * @throws SystemException Caso ocorra erro na criação da conexão.
     */
    public static Connection getConnection() throws SystemException {
        if (ConnectionPool.CONFIGURED) {
            try {
                return new Connection(DriverManager.getConnection(ConnectionPool.URL));
            } catch (SQLException e) {
                throw new SystemException("error.creating.jdbc.connection", e);
            }
        } else {
            throw new SystemException("connection.poll.instance.is.not.configured");
        }
    }

    /**
     * Teste para validar se as configurações estão ok.
     * @throws SystemException Caso ocorra erro na criação da conexão ou execução do sql de teste.
     */
    public static void checkConnectionConfiguration() throws SystemException {
        try (Connection conn = ConnectionPool.getConnection()) {
            try (Statement stmt = conn.prepareStatement(ConnectionPool.SQL_TEST)) {
                stmt.execute();
            }
        }
    }
}
