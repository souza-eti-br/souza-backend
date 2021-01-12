package br.eti.souza.sql;

import br.eti.souza.exception.SystemException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Representa um resultSet com o Banco de dados.
 * @author Alan Moraes Souza
 */
public class ResultSet implements AutoCloseable {

    /** ResultSet real com o banco de dados. */
    private final java.sql.ResultSet resultSet;

    /**
     * Construtor que define o ResultSet real com o banco de dados.
     * @param resultSet ResultSet real com o banco de dados.
     */
    protected ResultSet(java.sql.ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    /**
     * Move cursor para proxima linha do ResultSet.
     * @return Verdadeiro se a proxima linha for valida.
     * @throws SystemException Caso não consiga mover o cursor.
     */
    public boolean next() throws SystemException {
        try {
            return this.resultSet.next();
        } catch (SQLException e) {
            throw new SystemException("error.moving.cursor.to.next.row.of.result.set", e);
        }
    }

    /**
     * Retorna um campo do resultSet pelo nome.
     * @param key Nome do campo.
     * @return Valor do campo.
     * @throws SystemException Caso não consiga fechar o resultSet.
     */
    public String getString(String key) throws SystemException {
        try {
            String value = this.resultSet.getString(key);
            if (this.resultSet.wasNull()) {
                return null;
            } else {
                return value;
            }
        } catch (SQLException e) {
            throw new SystemException("error.getting.result.set.collumn.value", e);
        }
    }

    /**
     * Retorna um campo do resultSet pelo nome.
     * @param key Nome do campo.
     * @return Valor do campo.
     * @throws SystemException Caso não consiga fechar o resultSet.
     */
    public Boolean getBoolean(String key) throws SystemException {
        try {
            Boolean value = this.resultSet.getBoolean(key);
            if (this.resultSet.wasNull()) {
                return null;
            } else {
                return value;
            }
        } catch (SQLException e) {
            throw new SystemException("error.getting.result.set.collumn.value", e);
        }
    }

    /**
     * Retorna um campo do resultSet pelo nome.
     * @param key Nome do campo.
     * @return Valor do campo.
     * @throws SystemException Caso não consiga fechar o resultSet.
     */
    public Date getDate(String key) throws SystemException {
        try {
            Timestamp value = this.resultSet.getTimestamp(key);
            if (this.resultSet.wasNull()) {
                return null;
            } else {
                return new Date(value.getTime());
            }
        } catch (SQLException e) {
            throw new SystemException("error.getting.result.set.collumn.value", e);
        }
    }

    /**
     * Fecha o resultSet.
     * @throws SystemException Caso não consiga fechar o resultSet.
     */
    @Override
    public void close() throws SystemException {
        try {
            this.resultSet.close();
        } catch (SQLException e) {
            throw new SystemException("error.closing.jdbc.result.set", e);
        }
    }
}
