package br.com.pedrohfs.servicoclientes.rest;

import br.com.pedrohfs.servicoclientes.domain.Cliente;
import br.com.pedrohfs.servicoclientes.repository.ClienteRepository;
import br.com.pedrohfs.servicoclientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteResource {

    @Autowired
    ClienteService service;

    @GetMapping
    public List<Cliente> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid Cliente cliente){
        return service.salvar(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        service.deletar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Cliente atualizar(@PathVariable Integer id, @RequestBody @Valid Cliente newCliente){
        return service.atualizar(id, newCliente);
    }

}
