package br.edu.iftm.contact.contatos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GerenciarLoginsController {

    @RequestMapping("/admin/gerenciarLogins")
    public String iniciar(Model model) {
        return "gerenciarLogins";
    }
    
}
