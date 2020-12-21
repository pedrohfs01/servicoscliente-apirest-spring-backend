package br.com.pedrohfs.servicoclientes.rest;

import br.com.pedrohfs.servicoclientes.domain.Cliente;
import br.com.pedrohfs.servicoclientes.domain.ServicoPrestado;
import br.com.pedrohfs.servicoclientes.domain.dto.ServicoPrestadoDTO;
import br.com.pedrohfs.servicoclientes.services.ServicoPrestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoResource {

    @Autowired
    ServicoPrestadoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO objDto)
    {
        ServicoPrestado obj = service.fromDTO(objDto);
        return service.salvar(obj);
    }
}
