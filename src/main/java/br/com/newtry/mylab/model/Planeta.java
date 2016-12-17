package br.com.newtry.mylab.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_planeta")
public class Planeta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O Diâmetro Equatorial não pode ser nulo.")
	@Column(name = "diametro_equatorial")
	private BigDecimal diametroEquatorial;
	
	@NotNull(message = "A Unidade de Medida do Diâmetro Equatorial, não ser nula.")
	@OneToOne
	@JoinColumn(name = "id_um_diametro_equatorial")
	private UnidadeMedida umDiametroEquatoria;
	
	@NotNull(message = "A Inclinação Axial não pode ser nula.")
	@Column(name = "inclinacao_axial")
	private BigDecimal inclinacaoAxial;
	
	@NotNull(message = "A Unidade de Medida da Inclinação Axial, não pode ser nula")
	@OneToOne
	@JoinColumn(name = "id_um_inclinacao_axial")
	private UnidadeMedida umInclinacaoAxial;
	
	@NotNull(message = "A Area Total não pode ser nula.")
	@Column(name = "area_total")
	private BigDecimal areaTotal;
	
	@NotNull(message = "A Unidade de Medida da Area Total, não pode ser nula.")
	@OneToOne
	@JoinColumn(name = "id_um_area_total")
	private UnidadeMedida umAreaTotal;
	
	@NotNull(message = "A Temperatura Interior não pode ser nula.")
	@Column(name = "temperatura_interior")
	private BigDecimal temperaturaInterior;
	
	@NotNull(message = "A Unidade de Medida da Temperatura Interior, não pode ser nula.")
	@OneToOne
	@JoinColumn(name = "id_um_temperatura_interior")
	private UnidadeMedida umTemperaturaInterior;
	
	@NotNull(message = "A Velocidade de Escape não pode ser nula.")
	@Column(name = "velocidade_escape")
	private BigDecimal velocidadeEscape;
	
	@NotNull(message = "A Unidade de Medida da Velocidade de Escape, não pode ser nula.")
	@OneToOne
	@JoinColumn(name = "id_um_velocidade_escape")
	private UnidadeMedida umVelocidadeEscape;
	
	@NotNull(message = "A Densidade Media não pode ser nula.")
	@Column(name = "densidade_media")
	private BigDecimal densidadeMedia;
	
	@NotNull(message = "A Unidade de Medida da Densidade Média, não pose der nula.")
	@OneToOne
	@JoinColumn(name = "id_um_densidade_media")
	private UnidadeMedida umDensidadeMedia;
	
	// #########################################################################################################################
	// RELAÇÃO COM A COMPOSIÇÃO DA MASSA
	@NotNull(message = "É necessário inserir pelo menos um Elemento para Composição da Massa do Planeta.")
	@OneToMany(mappedBy = "planetaCompMassa")
	private List<ComposicaoMassa> composicaoMassa;
	public List<ComposicaoMassa> getComposicaoMassa() {
		return composicaoMassa;
	}
	
	public void setComposicaoMassa(List<ComposicaoMassa> composicaoMassa) {
		this.composicaoMassa = composicaoMassa;
	}
	// #########################################################################################################################
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getDiametroEquatorial() {
		return diametroEquatorial;
	}
	
	public void setDiametroEquatorial(BigDecimal diametroEquatorial) {
		this.diametroEquatorial = diametroEquatorial;
	}
	
	public UnidadeMedida getUmDiametroEquatoria() {
		return umDiametroEquatoria;
	}
	
	public void setUmDiametroEquatoria(UnidadeMedida umDiametroEquatoria) {
		this.umDiametroEquatoria = umDiametroEquatoria;
	}
	
	public BigDecimal getInclinacaoAxial() {
		return inclinacaoAxial;
	}
	
	public void setInclinacaoAxial(BigDecimal inclinacaoAxial) {
		this.inclinacaoAxial = inclinacaoAxial;
	}
	
	public UnidadeMedida getUmInclinacaoAxial() {
		return umInclinacaoAxial;
	}
	
	public void setUmInclinacaoAxial(UnidadeMedida umInclinacaoAxial) {
		this.umInclinacaoAxial = umInclinacaoAxial;
	}
	
	public BigDecimal getAreaTotal() {
		return areaTotal;
	}
	
	public void setAreaTotal(BigDecimal areaTotal) {
		this.areaTotal = areaTotal;
	}
	
	public UnidadeMedida getUmAreaTotal() {
		return umAreaTotal;
	}
	
	public void setUmAreaTotal(UnidadeMedida umAreaTotal) {
		this.umAreaTotal = umAreaTotal;
	}
	
	public BigDecimal getTemperaturaInterior() {
		return temperaturaInterior;
	}
	
	public void setTemperaturaInterior(BigDecimal temperaturaInterior) {
		this.temperaturaInterior = temperaturaInterior;
	}
	
	public UnidadeMedida getUmTemperaturaInterior() {
		return umTemperaturaInterior;
	}
	
	public void setUmTemperaturaInterior(UnidadeMedida umTemperaturaInterior) {
		this.umTemperaturaInterior = umTemperaturaInterior;
	}
	
	public BigDecimal getVelocidadeEscape() {
		return velocidadeEscape;
	}
	
	public void setVelocidadeEscape(BigDecimal velocidadeEscape) {
		this.velocidadeEscape = velocidadeEscape;
	}
	
	public UnidadeMedida getUmVelocidadeEscape() {
		return umVelocidadeEscape;
	}
	
	public void setUmVelocidadeEscape(UnidadeMedida umVelocidadeEscape) {
		this.umVelocidadeEscape = umVelocidadeEscape;
	}
	
	public BigDecimal getDensidadeMedia() {
		return densidadeMedia;
	}
	
	public void setDensidadeMedia(BigDecimal densidadeMedia) {
		this.densidadeMedia = densidadeMedia;
	}
	
	public UnidadeMedida getUmDensidadeMedia() {
		return umDensidadeMedia;
	}
	
	public void setUmDensidadeMedia(UnidadeMedida umDensidadeMedia) {
		this.umDensidadeMedia = umDensidadeMedia;
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
		Planeta other = (Planeta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
