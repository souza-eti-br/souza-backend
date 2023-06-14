package br.eti.souza.backend;

import br.eti.souza.backend.services.Status;
import br.eti.souza.server.Server;

public class Main {

    public static void main(String[] args) {
        Server.addServicePath("status", new Status());
        Server.start();
    }
}
