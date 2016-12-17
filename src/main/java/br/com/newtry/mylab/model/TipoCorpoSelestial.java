package br.com.newtry.mylab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_tipo_corpo_selestial")
public class TipoCorpoSelestial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "A descrição não pode ser nula.")
	@Size(max = 200, message = "A Descrição não pode ter mais do que duzentos caracteres.")
	private String descricao;
	
	@OneToOne(mappedBy="tipoCorpoSelestial")
	private CorpoSelestial corpoSelestial;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public CorpoSelestial getCorpoSelestial() {
		return corpoSelestial;
	}
	
	public void setCorpoSelestial(CorpoSelestial corpoSelestial) {
		this.corpoSelestial = corpoSelestial;
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
		TipoCorpoSelestial other = (TipoCorpoSelestial) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
