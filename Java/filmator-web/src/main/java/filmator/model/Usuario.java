package filmator.model;

public class Usuario {
	
	private Integer idUsuario;
	private String usuario;
	private String senha;
	private boolean ehAdmin;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isEhAdmin() {
		return ehAdmin;
	}
	public void setEhAdmin(boolean ehAdmin) {
		this.ehAdmin = ehAdmin;
	}
	
	
}
