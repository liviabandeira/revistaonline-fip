package br.com.fip.gati.revistaonline.domain.model;

import br.com.fip.gati.revistaonline.domain.model.Entity;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


@javax.persistence.Entity
@Table(name="newsletter")
public class Newsletter extends Entity{
	
	@NotNull(message="{usuario.email.nulo}")
	@Email(message="{usuario.email.invalido}")
	private String email; 
	
	@NotNull
	@Size(min=3, max = 50)
	private String nome;
	
	private boolean assinante = false; 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAssinante() {
		return assinante;
	}

	public void setAssinante(boolean assinante) {
		this.assinante = assinante;
	}
}
