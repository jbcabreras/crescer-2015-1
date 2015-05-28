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
		
		public void atualizar(Filme filme){
			jdbcTemplate.update("update filmes set nome = ?, genero = ?, anolanc= ?, sinopse = ?, url = ? where idfilme = ?",
					filme.getNome(),
					filme.getGenero().name(),
					filme.getAno(),
					filme.getSinopse(),
					filme.getUrl(),
					filme.getIdFilme());
		}
		
		public void excluir(String id){
			jdbcTemplate.update("delete from filmes where idfilme = ?", id);
		
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
			return jdbcTemplate.query("SELECT * FROM Filmes where upper(nome) like ?", (ResultSet rs, int rownum ) -> {	
				Filme filme = new Filme();
				filme.setIdFilme(rs.getInt("idfilme"));
				filme.setNome(rs.getString("nome"));
				filme.setGenero(rs.getString("genero"));
				filme.setAno(rs.getString("anolanc"));
				filme.setSinopse(rs.getString("sinopse"));
				filme.setUrl(rs.getString("url"));
				
				return filme;
				
			}, "%" + nome.toUpperCase() + "%");	
		}
		
		public Filme buscaFilmeId(String id){
			return jdbcTemplate.queryForObject("SELECT * FROM Filmes where idfilme = ?", (ResultSet rs, int rownum ) -> {	
				Filme filme = new Filme();
				filme.setIdFilme(rs.getInt("idfilme"));
				filme.setNome(rs.getString("nome"));
				filme.setGenero(rs.getString("genero"));
				filme.setAno(rs.getString("anolanc"));
				filme.setSinopse(rs.getString("sinopse"));
				filme.setUrl(rs.getString("url"));
				
				return filme;
				
			}, id);	
		}
		
		public List<Filme> buscaCapasGenero(){
			return jdbcTemplate.query("SELECT idfilme, nome, genero, url FROM filmes WHERE idfilme IN ("
					+ "SELECT Max(idfilme) FROM filmes GROUP BY genero order by genero asc)", (ResultSet rs, int rownum ) -> {	
				Filme filme = new Filme();
				filme.setGenero(rs.getString("genero"));
				filme.setUrl(rs.getString("url"));
				
				return filme;
				
			});	
		}
		
		public List<Filme> buscaFilmesGenero(String genero){
			return jdbcTemplate.query("SELECT idfilme, nome, genero, anolanc, sinopse, url FROM filmes WHERE genero = ? "
					+ "order by nome asc", (ResultSet rs, int rownum ) -> {	
				Filme filme = new Filme();
				filme.setIdFilme(rs.getInt("idfilme"));
				filme.setNome(rs.getString("nome"));
				filme.setGenero(rs.getString("genero"));
				filme.setAno(rs.getString("anolanc"));
				filme.setSinopse(rs.getString("sinopse"));
				filme.setUrl(rs.getString("url"));
				
				return filme;
				
			}, genero.toUpperCase());	
		}
		
		
		
	
//	public List<Filme> buscaTodosFilmes(){
//		//Imagina que estes dados estao vindo do banco
//		return Arrays.asList(new Filme("O poderoso chefão"),
//			new Filme("O poderoso chefão II"),
//			new Filme("O poderoso chefão III"));
//	}
	
}
 