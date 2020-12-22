package br.com.pedrohfs.servicoclientes.services;

import br.com.pedrohfs.servicoclientes.domain.Usuario;
import br.com.pedrohfs.servicoclientes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;


    public Usuario salvar(Usuario usuario){
        return repo.save(usuario);
    }
}
