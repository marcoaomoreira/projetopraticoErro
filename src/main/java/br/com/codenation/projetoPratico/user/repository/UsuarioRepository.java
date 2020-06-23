package br.com.codenation.projetoPratico.user.repository;

import br.com.codenation.projetoPratico.user.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByLogin(String login);


}
