package br.eti.souza.crypto;

import java.math.BigInteger;

/**
 * Classe utilitária para criptografia usando criptografia própria da Souza.eti.br.
 * @author Alan Moraes Souza.
 */
public final class Souza {

    /**
     * Obter código hash usado na codificação.
     * @param masterPassword Senha da codificação.
     * @return Código hash.
     */
    private static int getHash(String masterPassword) {
        return Math.abs(masterPassword.hashCode() % 33797) + 347;
    }

    /**
     * Codificar texto para criptografia própria da Souza.eti.br.
     * @param text Texto.
     * @param masterPassword Senha da codificação.
     * @return Codificação baseado na criptografia própria da Souza.eti.br.
     */
    public static String encode(String text, String masterPassword) {
        int hash = Souza.getHash(masterPassword);
        char[] characters = text.toCharArray();
        String encoded = "";
        for (int i = 0; i < characters.length; i++) {
            String number = String.valueOf(characters[i] + hash);
            while (number.length() < 5) {
                number = "0".concat(number);
            }
            encoded = encoded.concat(number);
        }
        return new BigInteger(encoded, 10).toString(32).toUpperCase();
    }

    /**
     * Decodificar texto na criptografia própria da Souza.eti.br.
     * @param data Codificação baseado na criptografia própria da Souza.eti.br..
     * @param masterPassword Senha da codificação.
     * @return Texto decodificado.
     */
    public static String decode(String data, String masterPassword) {
        int hash = Souza.getHash(masterPassword);
        String dataDecimal = new BigInteger(data, 32).toString(10);
        char[] characters = new char[dataDecimal.length() / 5];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = (char) (Integer.valueOf(dataDecimal.substring(i * 5, (i + 1) * 5)) - hash);
        }
        return String.valueOf(characters);
    }
}
