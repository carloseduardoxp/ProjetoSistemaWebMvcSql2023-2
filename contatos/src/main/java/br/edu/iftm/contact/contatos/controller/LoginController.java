package br.edu.iftm.contact.contatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iftm.contact.contatos.domain.Login;
import br.edu.iftm.contact.contatos.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ContatoController contatoController;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("mensagem", "");
        return "login";
    }

    @PostMapping("newUser")
    public String salvarLogin(Login login, Model model) {
        loginService.salvar(login);
        model.addAttribute("mensagem", "Usuario salvo com sucesso");
        return "login";
    }

    @PostMapping("login")
    public String login(Login login, Model model) {
        if (loginService.verificaSenha(login)) {
            return contatoController.getContatos(model);
        } else {
            model.addAttribute("mensagem", "Usuario ou senha inválidos");
            return "login";
        }
    }
}
