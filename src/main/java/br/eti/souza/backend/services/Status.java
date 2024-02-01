package br.eti.souza.backend.services;

import br.eti.souza.backend.database.Database;
import br.eti.souza.exception.SystemException;
import br.eti.souza.exception.UserException;
import br.eti.souza.server.Request;
import br.eti.souza.server.Response;
import br.eti.souza.server.Service;
import jakarta.json.Json;

/**
 * Serviço para o status do Servidor.
 * @author Alan Moraes Souza
 */
public class Status extends Service {

    /**
     * Processa o HTTP método GET.
     * @param request Requisição.
     * @return Resultado do processamento da requisição.
     * @throws SystemException Exceção causada pelo sistema.
     * @throws UserException Exceção causada pelo usuário.
     */
    @Override
    protected Response get(Request request) throws SystemException, UserException {
        var response = new Response(200, "OK");
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:9000");
        //response.addHeader("Access-Control-Allow-Origin", "https://www.souza.eti.br");
        response.setContentType("text/json");
        var body = Json.createObjectBuilder();
        body.add("name", "Souza Server");
        body.add("serverOnline", true);
        body.add("databaseOnline", Database.check());
        response.setContentBody(body.build().toString());
        return response;
    }
}
