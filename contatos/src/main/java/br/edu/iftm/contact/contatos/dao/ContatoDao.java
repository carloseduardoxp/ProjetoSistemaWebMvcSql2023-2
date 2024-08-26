package br.edu.iftm.contact.contatos.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.iftm.contact.contatos.domain.Contato;

@Component
public class ContatoDao {

    JdbcTemplate db;

	public ContatoDao(JdbcTemplate db) {
		this.db = db;
	}

    public List<Contato> getContatos() {
		String sql = "select  email,nome from tb_contato";

		return db.query(sql, (res, rowNum) -> 
			new Contato(
					res.getString("nome"),
					res.getString("email")
			)
		);
	}

	public List<Contato> getContatos(String nome) {
		String sql = "select  email,nome from tb_contato where lower(nome) like ?";

		return db.query(sql,
		                new BeanPropertyRowMapper<>(Contato.class),
						"%"+nome+"%");
	}

	public Contato getContato(String email) {
		String sql = "select  email,nome from tb_contato where email = ?";

		List<Contato> contatos=  db.query(sql,
		                new BeanPropertyRowMapper<>(Contato.class),
						email);
		if (contatos != null && !contatos.isEmpty()) {
			return contatos.get(0);
		} else {
			return null;
		}
	}

	public void inserirContato(Contato contato) {
		String sql = "insert into tb_contato(email,nome) values(?,?)";

		db.update(sql,contato.getEmail(),contato.getNome());
	}

	public void updateContato(Contato contato) {
		String sql = "update tb_contato set nome = ? where email = ?";

		db.update(sql,contato.getNome(),contato.getEmail());
	}

	public void deleteContato(String email) {
		String sql = "delete from tb_contato where email = ?";

		db.update(sql,email);
	}

}