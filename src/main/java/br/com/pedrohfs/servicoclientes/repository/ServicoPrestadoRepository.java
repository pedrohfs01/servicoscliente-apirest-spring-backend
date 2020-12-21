package br.com.pedrohfs.servicoclientes.repository;

import br.com.pedrohfs.servicoclientes.domain.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
}
