package br.com.newtry.mylab.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tb_unidade_medida")
public class UnidadeMedida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O Símbolo não pode ser nulo.")
	@Size(max = 200, message="O símbolo não pode conter mais do que duzentos caracteres.")
	private String grandeza;
	
	@NotEmpty(message = "O Nome da Unidade não pode ser nulo.")
	@Size(max = 200, message="O símbolo não pode conter mais do que duzentos caracteres.")
	@Column(name="nm_unidade")
	private String nmUnidade;
	
	@NotEmpty(message = "O Símbolo não pode ser nulo.")
	@Size(max = 10, message="O símbolo não pode conter mais do que dez caracteres.")
	private String simbolo;
	
	@NotEmpty(message = "A Regra não pode ser nulo.")
	@Size(max = 200, message="O símbolo não pode conter mais do que duzentos caracteres.")
	private String regra;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="dt_insert")
    @Temporal(TemporalType.DATE)
    private Date dtInsert = new Date();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrandeza() {
		return grandeza;
	}

	public void setGrandeza(String grandeza) {
		this.grandeza = grandeza;
	}

	public String getNmUnidade() {
		return nmUnidade;
	}

	public void setNmUnidade(String nmUnidade) {
		this.nmUnidade = nmUnidade;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}
	
	public Date getDtInsert() {
		return dtInsert;
	}

	public void setDtInsert(Date dtInsert) {
		this.dtInsert = dtInsert;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeMedida other = (UnidadeMedida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
