package br.edu.iftm.contact.contatos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.iftm.contact.contatos.domain.Login;

@Component
public class LoginDao {

    @Autowired
    private JdbcTemplate db;

    public void salvar(Login login) {
        String sql = "insert into tb_login(usuario,senha) values(?,?)";
        db.update(sql, new Object[] { login.getUsuario(), login.getSenha() });
    }

    public Login getLogin(String user) {
        String sql = "select usuario,senha from tb_login where usuario = ?";
        List<Login> logins = db.query(sql,
                (res, rowNum) -> {
                    return new Login(
                            res.getString("usuario"),
                            res.getString("senha"));
                },
                new Object[] { user });
        if (!logins.isEmpty()) {
            return logins.get(0);
        } else {
            return null;
        }
    }
}
