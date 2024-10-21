package br.eti.souza.backend.services;

import br.eti.souza.backend.records.Status;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST para indicar o estado do servidor.
 * @author Alan Moraes Souza
 */
@RestController
public class StatusService {

    /** Datasource para checar acesso a banco de dados. */
    @Autowired
    private DataSource dataSource;

    /** Server name */
    @Value("${spring.application.name}")
    public String serverName;

    /**
     * Obter status do servidor.
     * @return Status do servidor.
     */
	@GetMapping("/status")
	public Status get() {
        var isDatabaseOn = false;
        try (var conn = this.dataSource.getConnection()) {
            isDatabaseOn = conn.isValid(0);
        } catch (SQLException e) {
            Logger.getLogger(StatusService.class.getName()).log(Level.SEVERE, null, e);
        }
		return new Status(this.serverName, true, isDatabaseOn);
	}
}