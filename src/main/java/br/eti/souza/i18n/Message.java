package br.eti.souza.i18n;

/**
 * Mensagem internacionalizada de uma exceção.
 * @author Alan Moraes Souza
 */
public final class Message {

    /** Chave da mensagem internacionalizada. */
    private final String key;
    /** Argumentos da mensagem internacionalizada. */
    private final String[] args;

    /**
     * Construtor da mensagem internacionalizada.
     * @param key Chave da mensagem internacionalizada.
     * @param args Argumentos da mensagem internacionalizada.
     */
    public Message(String key, Object... args) {
        this.key = String.valueOf(key).trim();
        if (args != null) {
            this.args = new String[args.length];
            for (int i = 0; i < args.length; i++) {
                this.args[i] = String.valueOf(args[i]).trim();
            }
        } else {
            this.args = new String[0];
        }
    }

    /**
     * Retorna a chave da mensagem internacionalizada.
     * @return Chave da mensagem internacionalizada.
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Retorna os argumentos da mensagem internacionalizada.
     * @return Argumentos da mensagem internacionalizada.
     */
    public String[] getArgs() {
        return this.args;
    }
}
