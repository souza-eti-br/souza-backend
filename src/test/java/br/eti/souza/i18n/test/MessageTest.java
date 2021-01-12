package br.eti.souza.i18n.test;

import br.eti.souza.i18n.Message;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testes para br.eti.souza.i18n.Message.
 * @author Alan Moraes Souza
 */
public class MessageTest {

    @Test
    public void testConstructorKeyNull() {
        Message msg = new Message(null);
        Assertions.assertEquals("null", msg.getKey());
        Assertions.assertArrayEquals(new String[0], msg.getArgs());
    }

    @Test
    public void testConstructorKeyNullArgsNull() {
        Message msg = new Message(null, (Object) null);
        Assertions.assertEquals("null", msg.getKey());
        Assertions.assertArrayEquals(new String[]{"null"}, msg.getArgs());
    }

    @Test
    public void testConstructorKeyEmpty() {
        Message msg = new Message("");
        Assertions.assertEquals("", msg.getKey());
        Assertions.assertArrayEquals(new String[0], msg.getArgs());
    }

    @Test
    public void testConstructorKeyEmptyArgsEmpty() {
        Message msg = new Message(null, (Object) null);
        Assertions.assertEquals("null", msg.getKey());
        Assertions.assertArrayEquals(new String[]{"null"}, msg.getArgs());
    }

    @Test
    public void testConstructorKeyNotEmpty() {
        Message msg = new Message("key.message");
        Assertions.assertEquals("key.message", msg.getKey());
        Assertions.assertArrayEquals(new String[0], msg.getArgs());
    }

    @Test
    public void testConstructorKeyNotEmptyArgsNotEmpty() {
        Date now = new Date();
        Message msg = new Message("key.message", "arg01", 89, 79L, 8.5, now);
        Assertions.assertEquals("key.message", msg.getKey());
        Assertions.assertArrayEquals(new String[]{"arg01", "89", "79", "8.5", now.toString()}, msg.getArgs());
    }
}
