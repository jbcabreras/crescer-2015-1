package filmator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import filmator.model.Filme;

public class FilmeDao {
	
	public FilmeDao(){}
	
	public void incluir(Filme filme) throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/filmator", "sa", "");
		
		PreparedStatement preparedStatement = connection.prepareStatement("insert into filmes "
				+ "values(seq_idfilme.nextval, ?, ?, ?, ?, ?)");
		preparedStatement.setString(1, filme.getNome());
		preparedStatement.setString(2, filme.getGenero().getNomeGenero());
		preparedStatement.setString(3, filme.getAno());
		preparedStatement.setString(4, filme.getSinopse());
		preparedStatement.setString(5, filme.getUrl());
		preparedStatement.executeUpdate();
		connection.close();
	}

//	public List<Filme> buscaTodosFilmes(){
//		//Imagina que estes dados estao vindo do banco
//		return Arrays.asList(new Filme("O poderoso chefão"),
//			new Filme("O poderoso chefão II"),
//			new Filme("O poderoso chefão III"));
//	}
	
}
 