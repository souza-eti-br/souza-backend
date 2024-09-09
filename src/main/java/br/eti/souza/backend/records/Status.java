package br.eti.souza.backend.records;

/**
 * Representa o estado do servidor.
 * @author Alan Moraes Souza
 */
public record Status(String name, boolean serverOnline, boolean databaseOnline) {}
