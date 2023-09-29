package br.edu.iftm.tspi.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iftm.tspi.cadastro.dto.CadastroDTO;

@Controller
public class CadastroController {

    List<CadastroDTO> cadastros = new ArrayList<>();

    @PostMapping("cadastroResourcePost")
    public String doPost(CadastroDTO dto,Model model) {
        cadastros.add(dto);
        //model.addAttribute("cadastros",cadastros);
        //return "listagem";
        return doGet(model);
    }

    @RequestMapping("cadastroResourceGet")
    public String doGet(Model model) {
        model.addAttribute("cadastros",cadastros);
        return "listagem";
    }

    @GetMapping(value = {"/cadastros/{cadastroId}/edit"})
    public String showEditContact(Model model, @PathVariable String cadastroId) {
        CadastroDTO cadastroDTO = cadastros.get(0);
        model.addAttribute("cadastro", cadastroDTO);
        return "cadastro-edit";
    }


    
}
