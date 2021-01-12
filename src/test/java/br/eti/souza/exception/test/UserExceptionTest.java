package br.eti.souza.exception.test;

import br.eti.souza.exception.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testes para br.eti.souza.exception.UserException.
 * @author Alan Moraes Souza
 */
public class UserExceptionTest {

    @Test
    public void testConstructorDefaultAddMessage() {
        UserException e = new UserException();
        Assertions.assertFalse(e.haveMessages());
        Assertions.assertEquals(0, e.getMessages().size());
        e.addMessage("key", "arg");
        Assertions.assertTrue(e.haveMessages());
        Assertions.assertEquals(1, e.getMessages().size());
        Assertions.assertEquals("key", e.getMessages().get(0).getKey());
        Assertions.assertArrayEquals(new String[]{"arg"}, e.getMessages().get(0).getArgs());
    }

    @Test
    public void testConstructorWithMessage() {
        UserException e = new UserException("key", "arg");
        Assertions.assertTrue(e.haveMessages());
        Assertions.assertEquals(1, e.getMessages().size());
        Assertions.assertEquals("key", e.getMessages().get(0).getKey());
        Assertions.assertArrayEquals(new String[]{"arg"}, e.getMessages().get(0).getArgs());
    }
}
