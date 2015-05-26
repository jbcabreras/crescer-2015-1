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

@Component
public class FilmeDao {

		@Inject
		private JdbcTemplate jdbcTemplate;
		
		
		public void inserir(Filme filme){
			jdbcTemplate.update("insert into filmes values(seq_idfilme.nextval, ?, ?, ?, ?, ?)",
				filme.getNome(),
				filme.getGenero().name(),
				filme.getAno(),
				filme.getSinopse(),
				filme.getUrl());
		}
		

		public List<Filme> buscaTodosFilmesJava8(){
			return jdbcTemplate.query("SELECT * FROM Filmes", (ResultSet rs, int rownum ) -> {	
				Filme filme = new Filme();
				filme.setNome(rs.getString("nome"));
				filme.setGenero(rs.getString("genero"));
				filme.setAno(rs.getString("anolanc"));
				filme.setSinopse(rs.getString("sinopse"));
				filme.setUrl(rs.getString("url"));
				
				return filme;
			});	
		}
		
		public List<Filme> buscaFilmeNome(String nome){
			return jdbcTemplate.query("SELECT * FROM Filmes where nome like ?", (ResultSet rs, int rownum ) -> {	
				Filme filme = new Filme();
				filme.setNome(rs.getString("nome"));
				filme.setGenero(rs.getString("genero"));
				filme.setAno(rs.getString("anolanc"));
				filme.setSinopse(rs.getString("sinopse"));
				filme.setUrl(rs.getString("url"));
				
				return filme;
				
			}, "%" + nome + "%");	
		}
		
		
		
	
//	public List<Filme> buscaTodosFilmes(){
//		//Imagina que estes dados estao vindo do banco
//		return Arrays.asList(new Filme("O poderoso chefão"),
//			new Filme("O poderoso chefão II"),
//			new Filme("O poderoso chefão III"));
//	}
	
}
 