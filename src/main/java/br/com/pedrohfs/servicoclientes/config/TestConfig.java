package br.com.pedrohfs.servicoclientes.config;

import br.com.pedrohfs.servicoclientes.domain.Cliente;
import br.com.pedrohfs.servicoclientes.domain.ServicoPrestado;
import br.com.pedrohfs.servicoclientes.domain.Usuario;
import br.com.pedrohfs.servicoclientes.repository.ClienteRepository;
import br.com.pedrohfs.servicoclientes.repository.ServicoPrestadoRepository;
import br.com.pedrohfs.servicoclientes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ServicoPrestadoRepository servicoPrestadoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        Cliente cli1 = Cliente.builder().cpf("96378445036").nome("Pedro").build();
        clienteRepository.save(cli1);

        ServicoPrestado s1 = ServicoPrestado.builder().data(LocalDate.now())
                .descricao("Serviço de formatação").valor(new BigDecimal(50)).cliente(cli1)
                .build();
        servicoPrestadoRepository.save(s1);

        Usuario u1 = new Usuario();
        u1.setUsername("pedro");
        u1.setPassword("123");

        usuarioRepository.save(u1);

    }
}
