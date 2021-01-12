package br.eti.souza.sql;

import br.eti.souza.exception.SystemException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Representa um statement com o Banco de dados.
 * @author Alan Moraes Souza
 */
public class Statement implements AutoCloseable {

    /** PreparedStatement real com o banco de dados. */
    private final PreparedStatement statement;

    /**
     * Construtor que define o PreparedStatement real com o banco de dados.
     * @param statement PreparedStatement real com o banco de dados.
     */
    protected Statement(PreparedStatement statement) {
        this.statement = statement;
    }

    /**
     * Executa o statement.
     * @throws SystemException Caso não consiga executar o statement.
     */
    public void execute() throws SystemException {
        try {
            this.statement.execute();
        } catch (SQLException e) {
            throw new SystemException("error.executing.statment", e);
        }
    }

    /**
     * Executa o statement.
     * @throws SystemException Caso não consiga executar o statement.
     */
    public void executeUpdate() throws SystemException {
        try {
            this.statement.executeUpdate();
        } catch (SQLException e) {
            throw new SystemException("error.executing.statment", e);
        }
    }

    /**
     * Executa a query deste statement retornando o result set.
     * @return ResultSet baseado no sql.
     * @throws SystemException Caso não consiga executar a query.
     */
    public ResultSet executeQuery() throws SystemException {
        try {
            return new ResultSet(this.statement.executeQuery());
        } catch (SQLException e) {
            throw new SystemException("error.executing.statment", e);
        }
    }

    /**
     * Define um parâmetro do tipo VARCHAR.
     * @param index Index do parâmetro (começa em 1).
     * @param value Valor do parâmetro.
     * @throws SystemException Caso ocorra erro atribuindo o valor do parâmetro.
     */
    public void set(int index, String value) throws SystemException {
        try {
            this.statement.setString(index, value);
        } catch (SQLException e) {
            throw new SystemException("error.to.set.statment.parameter", e);
        }
    }

    /**
     * Define um parâmetro do tipo TIMESTAMP.
     * @param index Index do parâmetro (começa em 1).
     * @param value Valor do parâmetro.
     * @throws SystemException Caso ocorra erro atribuindo o valor do parâmetro.
     */
    public void set(int index, Date value) throws SystemException {
        try {
            this.statement.setTimestamp(index, new Timestamp(value.getTime()));
        } catch (SQLException e) {
            throw new SystemException("error.to.set.statment.parameter", e);
        }
    }

    /**
     * Define um parâmetro do tipo BOOLEAN.
     * @param index Index do parâmetro (começa em 1).
     * @param value Valor do parâmetro.
     * @throws SystemException Caso ocorra erro atribuindo o valor do parâmetro.
     */
    public void set(int index, Boolean value) throws SystemException {
        try {
            this.statement.setBoolean(index, value);
        } catch (SQLException e) {
            throw new SystemException("error.to.set.statment.parameter", e);
        }
    }

    /**
     * Fecha o statement.
     * @throws SystemException Caso não consiga fechar o statement.
     */
    @Override
    public void close() throws SystemException {
        try {
            this.statement.close();
        } catch (SQLException e) {
            throw new SystemException("error.closing.jdbc.statment", e);
        }
    }
}
