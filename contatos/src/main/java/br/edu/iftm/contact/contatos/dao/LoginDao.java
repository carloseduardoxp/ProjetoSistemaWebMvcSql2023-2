package br.edu.iftm.contact.contatos.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.iftm.contact.contatos.domain.Login;
import br.edu.iftm.contact.contatos.domain.Role;

@Component
public class LoginDao {

    @Autowired
    private JdbcTemplate db;

    Logger logger = LoggerFactory.getLogger(LoginDao.class);


    public void salvar(Login login) {
        String sql = "insert into tb_login(usuario,senha) values(?,?)";
        db.update(sql, new Object[] { login.getUsuario(), login.getSenha() });
    }

    public Login getLogin(String user) {
        String sql = "select usuario,senha from tb_login where usuario = ?";
        try {
            Login login = db.queryForObject(sql,
                (res, rowNum) -> {
                    return new Login(
                            res.getString("usuario"),
                            res.getString("senha"));
                },
                new Object[] { user });
            login.setRoles(getRoles(user));
            return login;
        } catch(EmptyResultDataAccessException e) {
            logger.info("User not found "+user+" message: "+e);
            return null;
        }    
    }

    public List<Role> getRoles(String user) {
        String sql = "select id,nome from tb_role where id in (select role_id from tb_role_user where usuario = ?)";
        return db.query(sql,
                (res, rowNum) -> {
                    return new Role(
                            res.getInt("id"),
                            res.getString("nome"));
                },
                new Object[] { user });
    }
}
