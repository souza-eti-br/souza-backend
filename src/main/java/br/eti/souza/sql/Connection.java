package br.eti.souza.sql;

import br.eti.souza.exception.SystemException;
import java.sql.SQLException;

/**
 * Representa uma connexão com o Banco de dados.
 * @author Alan Moraes Souza
 */
public class Connection implements AutoCloseable {

    /** Conexão real com o banco de dados. */
    private final java.sql.Connection connection;

    /**
     * Construtor que define a conexão real com o banco de dados.
     * @param connection Conexão real com o banco de dados.
     * @throws SystemException Caso não consiga configura a conexão.
     */
    protected Connection(java.sql.Connection connection) throws SystemException {
        this.connection = connection;
        try {
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new SystemException("error.setting.connection.to.auto.commit.false", e);
        }
    }

    /**
     * Prepara statement baseado no sql.
     * @param sql SQL para o statement.
     * @return Statement baseado no sql.
     * @throws SystemException Caso não consiga criar o statement.
     */
    public Statement prepareStatement(String sql) throws SystemException {
        try {
            return new Statement(this.connection.prepareStatement(sql));
        } catch (SQLException e) {
            throw new SystemException("error.closing.jdbc.connection", e);
        }
    }

    /**
     * Executa commit da conexão.
     * @throws SystemException Caso não consiga executar commit da conexão.
     */
    public void commit() throws SystemException {
        try {
            this.connection.commit();
        } catch (SQLException e) {
            throw new SystemException("error.committing.jdbc.connection", e);
        }
    }

    /**
     * Executa rollback da conexão.
     * @throws SystemException Caso não consiga executar rollback da conexão.
     */
    public void rollback() throws SystemException {
        try {
            this.connection.rollback();
        } catch (SQLException e) {
            throw new SystemException("error.rollbacking.jdbc.connection", e);
        }
    }

    /**
     * Fecha a conexão.
     * @throws SystemException Caso não consiga fechar a conexão.
     */
    @Override
    public void close() throws SystemException {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new SystemException("error.closing.jdbc.connection", e);
        }
    }
}
