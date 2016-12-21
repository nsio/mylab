package br.com.newtry.mylab.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_composicao_massa")
public class ComposicaoMassa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_corpo_selestial")
	private CorpoSelestial corpoSelestialCompMassa;
	
	@OneToOne
	@JoinColumn(name = "id_elemento")
	private ElementoTabelaPeriodica elementoCompMassa;
	
	@NotNull(message = "O valor da Composição da Massa não pode ser nulo.")
	@Column(name = "composicao_massa")
	private BigDecimal composicao;
	
	@OneToOne
	@JoinColumn(name = "id_um_composicao_massa")
	private UnidadeMedida unidadeMedida;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public CorpoSelestial getCorpoSelestialCompMassa() {
		return corpoSelestialCompMassa;
	}
	
	public void setCorpoSelestialCompMassa(CorpoSelestial corpoSelestialCompMassa) {
		this.corpoSelestialCompMassa = corpoSelestialCompMassa;
	}
	
	public ElementoTabelaPeriodica getElementoCompMassa() {
		return elementoCompMassa;
	}
	
	public void setElementoCompMassa(ElementoTabelaPeriodica elementoCompMassa) {
		this.elementoCompMassa = elementoCompMassa;
	}
	
	public BigDecimal getComposicao() {
		return composicao;
	}
	
	public void setComposicao(BigDecimal composicao) {
		this.composicao = composicao;
	}
	
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}
	
	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
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
		ComposicaoMassa other = (ComposicaoMassa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
