package br.eti.souza.backend;

import br.eti.souza.server.Server;
import br.eti.souza.backend.services.Status;

public class Main {

    public static void main(String[] args) {
        Server.setStaticResource("/home/souza/Projetos/souza-frontend/web");
        Server.addServicePath("status", new Status());
        Server.start();
    }
}
