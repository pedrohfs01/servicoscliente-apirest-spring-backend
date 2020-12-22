package br.com.pedrohfs.servicoclientes.rest;

import br.com.pedrohfs.servicoclientes.domain.Usuario;
import br.com.pedrohfs.servicoclientes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario){
        return service.salvar(usuario);
    }
}
