package br.edu.iftm.contact.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iftm.contact.contatos.domain.Login;
import br.edu.iftm.contact.contatos.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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

    @RequestMapping("/login/telaNovoUsuario")
    public String novo(Model model) {
        return "cadastro";
    }

    @PostMapping("/login/novoUsuario")
    public String salvarLogin(Login login, Model model) {
        loginService.salvar(login);
        model.addAttribute("mensagem", "Usuario salvo com sucesso");
        return home(model);
    }

    @PostMapping("/login/entrar")
    public String login(HttpSession session, Login login, Model model) {
        if (loginService.verificaSenha(login)) {
            List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ADMIN");
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    login.getUsuario(),
                    login.getSenha(),
                    authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext());

            return contatoController.getContatos(model);
        } else {
            model.addAttribute("mensagem", "Usuario ou senha inválidos");
            return "login";
        }
    }

    @RequestMapping("/login/sair")
    public String customLogoutMethod(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "login";
    }

}
