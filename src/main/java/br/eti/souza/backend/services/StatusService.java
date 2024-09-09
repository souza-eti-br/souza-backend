package br.eti.souza.backend.services;

import br.eti.souza.backend.records.Status;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST para indicar o estado do servidor.
 * @author Alan Moraes Souza
 */
@RestController
public class StatusService {

    /** Server name */
    @Value("${spring.application.name}")
    public String serverName;

	@GetMapping("/status")
	public Status get() {
        // TODO: Obter estado do banco de dados de logica.
		return new Status(this.serverName, true, false);
	}
}