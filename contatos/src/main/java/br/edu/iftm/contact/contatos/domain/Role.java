package br.edu.iftm.contact.contatos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {

    private Integer id;

    private String nome;
    
}
