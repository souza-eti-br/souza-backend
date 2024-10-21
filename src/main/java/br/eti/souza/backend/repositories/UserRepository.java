package br.eti.souza.backend.repositories;

import br.eti.souza.backend.entities.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositório para Usuários
 * @author Alan Moraes Souza
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Salva um usuário.
     * @param user Novo usuário.
     * @return Usuário como foi salvo.
     */
    @Override
    User save(User user);

    /**
     * Obtem um usuário pelo identificador.
     * @param id Identificador do usuário.
     * @return Usuário encontrado.
     */
    @Override
    Optional<User> findById(Long id);
}
