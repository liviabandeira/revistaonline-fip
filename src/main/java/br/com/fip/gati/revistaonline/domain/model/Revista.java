package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@javax.persistence.Entity
@Table(name="revista")
public class Revista extends Entity {

	@NotNull
	@Size(max=15)
	private String issn;

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}
	
}
