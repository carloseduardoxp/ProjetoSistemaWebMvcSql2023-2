package br.edu.iftm.contact.contatos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.iftm.contact.contatos.dao.LoginDao;
import br.edu.iftm.contact.contatos.domain.Login;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    Logger logger = LoggerFactory.getLogger(LoginService.class);

    public void salvar(Login login) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCriptografada = encoder.encode(login.getSenha());
        login.setSenha(senhaCriptografada);

        loginDao.salvar(login);
    }

    public Login verificaSenha(Login loginDigitado) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Login loginBanco = loginDao.getLogin(loginDigitado.getUsuario());
        if (loginBanco != null) {
            if (encoder.matches(loginDigitado.getSenha(), loginBanco.getSenha())) {
                return loginBanco;
            } else {
                logger.info("Senha não confere para o login "+loginDigitado.getUsuario());
            }
        }
        return null;
    }
}
