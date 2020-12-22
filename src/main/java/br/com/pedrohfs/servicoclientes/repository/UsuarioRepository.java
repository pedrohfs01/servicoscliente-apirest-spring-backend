package br.com.pedrohfs.servicoclientes.repository;

import br.com.pedrohfs.servicoclientes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<User, Integer> {
}
