package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Nota;

@Component
public class NotaDao {

		@Inject
		private JdbcTemplate jdbcTemplate;
		
		public void insereNota(Integer valor, Integer idfilme, Integer idusuario) {
			
			if(buscaNota(idfilme, idusuario).isEmpty()){
				
				jdbcTemplate.update("insert into nota values(seq_idnota.nextval, ?, 1, ?, ?)",
						idfilme,
						valor,
						idusuario);
				
			}else{
				
				jdbcTemplate.update("UPDATE nota SET ? WHERE idfilme = ? and idusuario = ?",
						valor,
						idfilme,
						idusuario);
			}
		}
		
		public List<Nota> buscaNota( Integer idfilme, Integer idusuario ){
			
			return jdbcTemplate.query( "SELECT * FROM nota WHERE IDFILME = ? and idusuario = ? ", (ResultSet rs, int rowNum) ->{
				
				Nota nota = new Nota();
				nota.setIdfilme(rs.getInt("idfilme"));
				nota.setVotos(rs.getInt("votos"));
				nota.setPotos(rs.getInt("pontos"));
				nota.setIdusuario(rs.getInt("idusuario"));
				
				return nota;
				
			}, idfilme, idusuario );
		}
		
}
		
		
		
		
