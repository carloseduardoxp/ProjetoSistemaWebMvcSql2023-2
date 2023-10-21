package br.edu.iftm.contact.contatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.contact.contatos.dao.ContatoDao;
import br.edu.iftm.contact.contatos.domain.Contato;

@Controller
public class ContatoController {

    @Autowired
    private ContatoDao dao;

    @RequestMapping("contatos")
    public String getContatos(Model model) {
        model.addAttribute("contato",new Contato());
        model.addAttribute("contatos",dao.getContatos());
        return "contatosList";
    }

    @PostMapping("contatos")
    public String inserirContatos(Contato contato,Model model) {
        Contato contatoDb = dao.getContato(contato.getEmail());
        if (contatoDb == null) {
            dao.inserirContato(contato);
        } else {
            dao.updateContato(contato);
        }
        
        return getContatos(model);
    }

    @RequestMapping("contatosParametro")
    public String getContatos(@RequestParam(value = "nome", required = true) String nome, Model model) {
        model.addAttribute("contatos",dao.getContatos(nome));
        model.addAttribute("contato",new Contato());
        return "contatosList";
    }

    @RequestMapping("excluirContato")
    public String deleteContato(@RequestParam(value = "email", required = true) String email, Model model) {
        dao.deleteContato(email);
        return getContatos(model);
    }

    @RequestMapping("editarContato")
    public String editarContato(@RequestParam(value = "email", required = true) String email, Model model) {
        Contato contato = dao.getContato(email);
        model.addAttribute("contato", contato);
         model.addAttribute("contatos", dao.getContatos());
        return "contatosList";
    }
    
}
