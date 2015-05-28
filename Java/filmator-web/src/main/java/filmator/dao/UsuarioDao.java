package filmator.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Usuario;

@Component
public class UsuarioDao {

		@Inject
		private JdbcTemplate jdbcTemplate;
		
		public void inserir(Usuario user){
			jdbcTemplate.update("insert into usuario values(seq_person.nextval, ?, ?, ?)",
				user.getUsuario(),
				user.getSenha(),
				false);
		}
		
		public boolean logar(Usuario user){
			
			List<Usuario> banco = jdbcTemplate.query("select * from usuario where usuario = ?", user.getUsuario());
			
			if()
		}
}
 