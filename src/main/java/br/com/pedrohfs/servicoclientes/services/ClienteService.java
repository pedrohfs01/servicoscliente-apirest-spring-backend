package br.com.pedrohfs.servicoclientes.services;

import br.com.pedrohfs.servicoclientes.domain.Cliente;
import br.com.pedrohfs.servicoclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repo;

    public Cliente salvar(Cliente cliente){
        return repo.save(cliente);
    }

    public List<Cliente> findAll(){
        return repo.findAll();
    }

    public Cliente findById(Integer id){
        return repo.
                findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    public void deletar(Integer id){
        repo.deleteById(id);
    }

    public Cliente atualizar(Integer id, Cliente newCliente){
        Cliente oldCliente = this.findById(id);
        newCliente = updateData(oldCliente, newCliente);
        return repo.save(newCliente);
    }

    public Cliente updateData(Cliente oldCliente, Cliente newCliente){
        oldCliente.setNome(newCliente.getNome());
        oldCliente.setCpf(newCliente.getCpf());
        return oldCliente;
    }
}
