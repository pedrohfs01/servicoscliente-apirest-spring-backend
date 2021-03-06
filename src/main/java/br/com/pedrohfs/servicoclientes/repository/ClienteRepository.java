package br.com.pedrohfs.servicoclientes.repository;

import br.com.pedrohfs.servicoclientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
