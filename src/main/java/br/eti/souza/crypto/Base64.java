package br.eti.souza.crypto;

import br.eti.souza.exception.SystemException;

/**
 * Classe utilitária para criptografia usando Base64.
 * @author Alan Moraes Souza.
 */
public final class Base64 {

    /**
     * Codificar texto para base64.
     * @param text Texto.
     * @return Codificação base64.
     */
    public static String encode(String text) {
        return java.util.Base64.getEncoder().encodeToString(text.getBytes());
    }

    /**
     * Decodificar base64 para texto.
     * @param base64 Base64.
     * @return Texto decodificados.
     * @throws SystemException Caso o argumento não seja um esquema Base64 válido.
     */
    public static String decode(String base64) throws SystemException {
        try {
            return new String(java.util.Base64.getDecoder().decode(base64));
        } catch (IllegalArgumentException e) {
            throw new SystemException("invalid.scheme.base64", e);
        }
    }
}
