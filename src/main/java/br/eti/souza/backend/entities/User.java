package br.eti.souza.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa um Usuário no banco de dados,
 * @author Alan Moraes Souza
 */
@Entity
@Table(name = "usuario")
public class User {

    /** Identificador do usuário. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Nome do usuário. */
    @Column(name="nome")
    private String name;

    /**
     * Obter  Identificador do usuário.
     * @return Identificador do usuário.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Definir Identificador do usuário.
     * @param id Novo Identificador do usuário.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obter  Nome do usuário.
     * @return Identificador do usuário.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Definir Nome do usuário.
     * @param name Novo Nome do usuário.
     */
    public void setName(String name) {
        this.name = name;
    }
}
