package br.com.pedrohfs.servicoclientes.services.exceptions;

public class UsuarioCadastradoException extends RuntimeException{


    public UsuarioCadastradoException(){
        super("Usuário já cadastrado.");
    }
}
