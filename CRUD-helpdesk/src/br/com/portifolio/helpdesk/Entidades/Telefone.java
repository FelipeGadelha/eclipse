package br.com.portifolio.helpdesk.Entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.portifolio.helpdesk.Enuns.TipoTelefone;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numero;
	
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipoTelefone;
	
	@ManyToOne(fetch = FetchType.EAGER)          
	@JoinColumn(name="usuario", nullable = false)
	private Usuario usuario = new Usuario();
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoTelefone getTipo() {
		return tipoTelefone;
	}

	public void setTipo(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	
		
}
