package br.edu.iftm.tspi.formulario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.iftm.tspi.formulario.dto.LoginRequestDTO;

@Controller
public class LoginResource {

    @PostMapping("/loginResource")
    public String trataPost(LoginRequestDTO loginRequestDTO,
                            Model model) {
        System.out.println("que felicidade, estou no servidor, "+
        "e você digitou o email "+loginRequestDTO.getEmail());
        System.out.println("nome "+loginRequestDTO.getName());
        
        model.addAttribute(loginRequestDTO);

        return "output";
    }
    
}
