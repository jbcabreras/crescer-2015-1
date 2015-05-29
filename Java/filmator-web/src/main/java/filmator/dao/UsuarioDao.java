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
		
		public Usuario consultaUsuario(Usuario user){
			
			List<Usuario> banco = jdbcTemplate.query("select * from usuario where usuario = ?", (ResultSet rs, int rownum ) -> {	
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idusuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEhAdmin(rs.getBoolean("ehAdmin"));
				
				return usuario;
				
			}, user.getUsuario());	
			
			if(banco.isEmpty()){
				return null;
			}else{
				
				Usuario userBanco = banco.get(0);
				
				if(user.getSenha().equals(userBanco.getSenha())){
					
					return userBanco;
					
				}else{
					
					return null;
					
				}
			}
			
		}
}
 