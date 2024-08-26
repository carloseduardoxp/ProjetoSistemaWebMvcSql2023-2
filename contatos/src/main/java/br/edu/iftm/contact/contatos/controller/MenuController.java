package br.edu.iftm.contact.contatos.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import br.edu.iftm.contact.contatos.domain.Role;
import br.edu.iftm.contact.contatos.dto.MenuItem;

@Controller
public class MenuController {

    Logger logger = LoggerFactory.getLogger(MenuController.class);

    @RequestMapping("menus")
    public String getMenus(Model model,List<Role> roles) {
        MenuItem contatos = new MenuItem("/contatos","Contatos");
        MenuItem gerenciarLogins = new MenuItem("/admin/gerenciarLogins","Gerenciar Logins");

        Set<MenuItem> itens = new HashSet<>();

        for (Role role: roles) {
            if (role.getNome().equals("ADMIN")) {
                itens.add(contatos);
                itens.add(gerenciarLogins);
            } else if (role.getNome().equals("USER")) {
                itens.add(contatos);
            }
        }
    
        model.addAttribute("menuItems",itens);
        return "menu";
    }
    
}
