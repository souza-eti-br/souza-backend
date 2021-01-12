package br.eti.souza.crypto;

import br.eti.souza.exception.SystemException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe utilitária para criptografia usando MD5.
 * @author Alan Moraes Souza.
 */
public final class MD5 {

    /** Message digest para MD5. */
    private static MessageDigest MESSAGE_DIGEST_MD5;

    /**
     * Obter message digest para MD5.
     * @return Message digest para MD5.
     * @throws SystemException Caso o algorítimo MD5 não seja suportado.
     */
    private static MessageDigest getMessageDigestMD5() throws SystemException {
        try {
            if (MD5.MESSAGE_DIGEST_MD5 == null) {
                MD5.MESSAGE_DIGEST_MD5 = MessageDigest.getInstance("MD5");
            }
            return MD5.MESSAGE_DIGEST_MD5;
        } catch (NoSuchAlgorithmException e) {
            throw new SystemException("algorithm.md5.not.supported", e);
        }
    }

    /**
     * Codificar texto para MD5.
     * @param text Texto.
     * @return Codificação MD5 com tamanho fixo de 32 caracteres.
     * @throws SystemException Caso o algorítimo MD5 não seja suportado.
     */
    public static String encode(String text) throws SystemException {
        String encoded = new BigInteger(1, MD5.getMessageDigestMD5().digest(text.getBytes())).toString(16);
        while (encoded.length() < 32) {
            encoded = "0" + encoded;
        }
        return encoded;
    }
}
