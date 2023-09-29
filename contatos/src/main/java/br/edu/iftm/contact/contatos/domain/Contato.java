package br.edu.iftm.contact.contatos.domain;

import lombok.Data;

@Data
public class Contato {

    private String nome;
    private String email;

    public Contato() {
        
    }
    public Contato(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    
    
}