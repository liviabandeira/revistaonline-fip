package br.com.fip.gati.revistaonline.domain.service.autenticacao;

import java.io.Serializable;


public class UsuarioInfo implements Serializable {
	private static final long serialVersionUID = -889580612234279330L;
	
	private Long id;
	private String email;
	private String login;
	private boolean admin;
	
	public UsuarioInfo(Long id, String email, String login, boolean admin) {
		this.id = id;
		this.email = email;
		this.login = login;
		this.admin = admin;
	}

	public Long getID() {
		return this.id;
	}

	public String getEmail() {
		return email;
	}

	public String getLogin() {
		return login;
	}

	public boolean isAdmin() {
		return admin;
	}
	
}
