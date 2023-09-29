package br.edu.iftm.contact.contatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.contact.contatos.dao.ContatoDao;

@Controller
public class ContatoController {

    @Autowired
    private ContatoDao dao;

    @RequestMapping("contatos")
    public String getContatos(Model model) {
        model.addAttribute("contatos",dao.getContatos());
        return "contatosList";
    }

    @RequestMapping("contatosParametro")
    public String getContatos(@RequestParam(value = "nome", required = true) String nome, Model model) {
        model.addAttribute("contatos",dao.getContatos(nome));
        return "contatosList";
    }
    
}
