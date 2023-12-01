package br.edu.iftm.contact.contatos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class MenuItem {

    private String link;

    private String nome;
    
}
