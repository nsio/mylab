package br.com.newtry.mylab.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.newtry.mylab.model.enuns.TipoElemento;

// VEJA AS ANOTAÇÕES, SÃO BEANS VALIDATIONS, SÃO VALIDAÇÕES QUE ACONTECEM NO SERVIDOR.
@Entity
@Table(name="tb_tabela_periodica")
public class ElementoTabelaPeriodica {
	
	/* 
	 * PARA O CASO DE STRING, É MELHOR ANOTAR COM @NotEmpty
	 * 
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O Número Atômico não pode ser nulo.")
	@Column(name="nr_atomico")
    private BigDecimal nrAtomico;
	
	@NotEmpty(message = "O Símbolo não pode ser nulo.")
	@Size(max = 10, message="O símbolo não pode conter mais do que dez caracteres.")
	private String simbolo;
    
	@NotEmpty(message = "O Nome do Elemento não pode ser nulo.")
	@Size(max = 50, message="O símbolo não pode conter mais do que cinquenta caracteres.")
	@Column(name="nm_elemento")
    private String nmElemento;
    
	@NotNull(message = "A Massa Atomica não pode ser nulo.")
	@Column(name="massa_atomica")
    private BigDecimal massaAtomica;
    
	@NotEmpty(message = "A Distribuição não pode ser nulo.")
	@Size(max = 60, message="O símbolo não pode conter mais do que sessenta caracteres.")
	private String distribuicao;
    
	@NotNull(message = "A Linha não pode ser nulo.")
	private Integer linha;
    
	@NotNull(message = "A Coluna não pode ser nulo.")
	private Integer coluna;
    
	@NotEmpty(message = "A Família não pode ser nulo.")
	@Size(max = 10, message="O símbolo não pode conter mais do que sessenta caracteres.")
	private String familia;
    
	@NotNull(message = "O Tipo do Elemento não pode ser nulo.")
	@Column(name="tp_elemento")
    @Enumerated(EnumType.STRING)
    private TipoElemento tipoElemento;
    
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
	public BigDecimal getNrAtomico() {
		return nrAtomico;
	}
	public void setNrAtomico(BigDecimal nrAtomico) {
		this.nrAtomico = nrAtomico;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	public String getNmElemento() {
		return nmElemento;
	}
	public void setNmElemento(String nmElemento) {
		this.nmElemento = nmElemento;
	}
	public BigDecimal getMassaAtomica() {
		return massaAtomica;
	}
	public void setMassaAtomica(BigDecimal massaAtomica) {
		this.massaAtomica = massaAtomica;
	}
	public String getDistribuicao() {
		return distribuicao;
	}
	public void setDistribuicao(String distribuicao) {
		this.distribuicao = distribuicao;
	}
	public Integer getLinha() {
		return linha;
	}
	public void setLinha(Integer linha) {
		this.linha = linha;
	}
	public Integer getColuna() {
		return coluna;
	}
	public void setColuna(Integer coluna) {
		this.coluna = coluna;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public TipoElemento getTipoElemento() {
		return tipoElemento;
	}
	public void setTipoElemento(TipoElemento tipoElemento) {
		this.tipoElemento = tipoElemento;
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
		ElementoTabelaPeriodica other = (ElementoTabelaPeriodica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
