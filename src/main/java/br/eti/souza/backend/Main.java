package br.eti.souza.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Inicia o servidor.
 * @author Alan Moraes Souza
 */
@SpringBootApplication
public class Main {

    @Value("${server.allowed.origins}")
    public String[] allowedOrigins;

    /**
     * Método de entrada da execução.
     * @param args Argumentos da execução.
     */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

    /**
     * Habilita Cross Origin.
     * @return Configuração Cross Origin.
     */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(Main.this.allowedOrigins);
			}
		};
	}
}