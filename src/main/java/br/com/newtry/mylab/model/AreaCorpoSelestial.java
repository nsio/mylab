package br.com.newtry.mylab.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.newtry.mylab.model.enuns.TipoArea;

@Entity
@Table(name="tb_area_corpo_selestial")
public class AreaCorpoSelestial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_corpo_selestial")
	private CorpoSelestial corpoSelestialArea;
	
	@OneToOne
	@JoinColumn(name = "id_um_area")
	private UnidadeMedida umAreaCorpoSelestial;
	
	private BigDecimal area;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tp_area")
	private TipoArea tipoAreaCorpoSelestial;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public CorpoSelestial getCorpoSelestialArea() {
		return corpoSelestialArea;
	}
	
	public void setCorpoSelestialArea(CorpoSelestial corpoSelestialArea) {
		this.corpoSelestialArea = corpoSelestialArea;
	}
	
	public UnidadeMedida getUmAreaCorpoSelestial() {
		return umAreaCorpoSelestial;
	}
	
	public void setUmAreaCorpoSelestial(UnidadeMedida umAreaCorpoSelestial) {
		this.umAreaCorpoSelestial = umAreaCorpoSelestial;
	}
	
	public BigDecimal getArea() {
		return area;
	}
	
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	
	public TipoArea getTipoAreaCorpoSelestial() {
		return tipoAreaCorpoSelestial;
	}
	
	public void setTipoAreaCorpoSelestial(TipoArea tipoAreaCorpoSelestial) {
		this.tipoAreaCorpoSelestial = tipoAreaCorpoSelestial;
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
		AreaCorpoSelestial other = (AreaCorpoSelestial) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
