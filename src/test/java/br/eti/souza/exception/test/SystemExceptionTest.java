package br.eti.souza.exception.test;

import br.eti.souza.exception.SystemException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testes para br.eti.souza.exception.SystemException.
 * @author Alan Moraes Souza
 */
public class SystemExceptionTest {

    @Test
    public void testConstructorMessageNull() {
        SystemException e = new SystemException(null);
        Assertions.assertEquals("null", e.getMessage());
        Assertions.assertNull(e.getCause());
    }

    @Test
    public void testConstructorMessageNullCauseNull() {
        SystemException e = new SystemException(null, null);
        Assertions.assertEquals("null", e.getMessage());
        Assertions.assertNull(e.getCause());
    }

    @Test
    public void testConstructorMessageNullCauseNotNull() {
        NullPointerException cause = new NullPointerException("teste");
        SystemException e = new SystemException(null, cause);
        Assertions.assertEquals("null", e.getMessage());
        Assertions.assertEquals(cause, e.getCause());
    }

    @Test
    public void testConstructorMessageEmpty() {
        SystemException e = new SystemException("");
        Assertions.assertEquals("", e.getMessage());
        Assertions.assertNull(e.getCause());
    }

    @Test
    public void testConstructorMessageEmptyCauseNull() {
        SystemException e = new SystemException("", null);
        Assertions.assertEquals("", e.getMessage());
        Assertions.assertNull(e.getCause());
    }

    @Test
    public void testConstructorMessageEmptyCauseNotNull() {
        NullPointerException cause = new NullPointerException("teste");
        SystemException e = new SystemException("", cause);
        Assertions.assertEquals("", e.getMessage());
        Assertions.assertEquals(cause, e.getCause());
    }

    @Test
    public void testConstructorMessageNotEmpty() {
        SystemException e = new SystemException("message");
        Assertions.assertEquals("message", e.getMessage());
        Assertions.assertNull(e.getCause());
    }

    @Test
    public void testConstructorMessageNotEmptyCauseNull() {
        SystemException e = new SystemException("message", null);
        Assertions.assertEquals("message", e.getMessage());
        Assertions.assertNull(e.getCause());
    }

    @Test
    public void testConstructorMessageNotEmptyCauseMotNull() {
        NullPointerException cause = new NullPointerException("teste");
        SystemException e = new SystemException("message", cause);
        Assertions.assertEquals("message", e.getMessage());
        Assertions.assertEquals(cause, e.getCause());
    }
}
