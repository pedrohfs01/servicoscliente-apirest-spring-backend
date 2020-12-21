package br.com.pedrohfs.servicoclientes.services;

import br.com.pedrohfs.servicoclientes.domain.ServicoPrestado;
import br.com.pedrohfs.servicoclientes.domain.Cliente;
import br.com.pedrohfs.servicoclientes.domain.dto.ServicoPrestadoDTO;
import br.com.pedrohfs.servicoclientes.repository.ServicoPrestadoRepository;
import br.com.pedrohfs.servicoclientes.services.util.BigDecimalConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ServicoPrestadoService {

    @Autowired
    ServicoPrestadoRepository repo;

    @Autowired
    ClienteService clienteService;

    @Autowired
    BigDecimalConverter converter;

    public ServicoPrestado salvar(ServicoPrestado obj){
        return repo.save(obj);
    }

    public ServicoPrestado fromDTO(ServicoPrestadoDTO objDTO){
        ServicoPrestado obj = new ServicoPrestado();

        LocalDate data = LocalDate.parse(objDTO.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Cliente cliente = clienteService.findById(objDTO.getIdCliente());

        obj.setDescricao(objDTO.getDescricao());
        obj.setData(data);
        obj.setCliente(cliente);
        obj.setValor(converter.converter(objDTO.getPreco()));

        return obj;
    }
}
