package br.com.portifolio.helpdesk.Testes;

import java.util.ArrayList;
import java.util.List;

import br.com.portifolio.helpdesk.Entidades.Telefone;
import br.com.portifolio.helpdesk.Entidades.Usuario;
import br.com.portifolio.helpdesk.Enuns.Status;
import br.com.portifolio.helpdesk.Enuns.TipoTelefone;
import br.com.portifolio.helpdesk.Repositorios.RepositorioUsuario;


public class TesteSalvar {

	public static void main(String[] args) {
		
		
		RepositorioUsuario<Usuario> repositorioUsuario = new RepositorioUsuario<Usuario>();

		Usuario usuario = new Usuario();
		
		usuario.setCPF("546654");
		usuario.setEMail("Isabella@hotmail.com");
		usuario.setNome("Felipe");
		usuario.setSenha("64353");
		usuario.setStatus(Status.ATIVO);
		
		Telefone telefone1 = new Telefone();
		telefone1.setNumero("23233232");
		telefone1.setTipo(TipoTelefone.RESIDENCIAL);
		
		Telefone telefone2 = new Telefone();
		telefone2.setNumero("65656565");
		telefone2.setTipo(TipoTelefone.COMERCIAL);
		
		List<Telefone> listaTelefones = new ArrayList<Telefone>();
		listaTelefones.add(telefone1);
		listaTelefones.add(telefone2);
		
		usuario.setTelefones(listaTelefones);
		
		
		if(repositorioUsuario.salvar(usuario) == true) {
			
			System.out.println("Usuario cadastrado com sucesso.");
		}else {
			System.out.println("Falha ao cadastrar Usuario");
		}
		System.out.println(usuario.getNome());
		
		for (Telefone telefone : listaTelefones) {
			System.out.println(telefone.getNumero());
		}		
	}
}















