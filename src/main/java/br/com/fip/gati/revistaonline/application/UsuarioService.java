package br.com.fip.gati.revistaonline.application;

import java.util.Date;

import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Autor;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.domain.repositorio.UsuarioRepositorio;
import br.com.fip.gati.revistaonline.domain.util.ShaEncrypt;

@Component
public class UsuarioService {
	private UsuarioRepositorio usuarios;
	private Environment env;

	public UsuarioService(UsuarioRepositorio usuarios, Environment env) {
		this.env = env;
		this.usuarios = usuarios;
	}

	public void cadastrarUsuario(Usuario usuario) throws RevistaException {
		if (usuario == null) {
			throw new IllegalArgumentException("usuario == null");
		}

		if (usuario.getAutor() == null) {
			throw new IllegalArgumentException("autor == null");
		}

		if (usuario.getSenha() == null || usuario.getConfirmacaoSenha() == null) {
			throw new IllegalArgumentException("senha/confirmacao senha == null");
		}
		
		if (!usuario.isSenhaConfirmada()) {
			throw new RevistaException("Senhas não conferem");
		}

		usuario.setLogin(usuario.getLogin().trim());
		usuario.setEmail(usuario.getEmail().trim());
		
		usuario.setSenha(ShaEncrypt.hash(usuario.getSenha(), this.env.get("encryption.salt")));
		usuario.setAlterarSenhaProximoAcesso(false);
		usuario.setDtaCadastro(new Date());
		usuario.setDtaUltimoAcesso(new Date());
		usuario.setAtivo();
		usuario.setTentativasLogon(0);
		usuario.setAdmin(false);
		
		if(usuarios.getUsuario(usuario.getLogin()) != null) {
			throw new RevistaException("Login já utilizado por outro usuário");
		}
		
		if(usuarios.getUsuarioPorEmail(usuario.getEmail()) != null) {
			throw new RevistaException("Email já cadastrado por outro usuário");
		}
		
		usuarios.save(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario) {
		Usuario usuariodb = usuarios.load(usuario.getId());
		Autor autordb = usuariodb.getAutor();
		Autor autor = usuario.getAutor();
		
		autordb.setTitulacao(autor.getTitulacao());
		autordb.setPrenome(autor.getPrenome());
		autordb.setNome(autor.getNome());
		autordb.setSobrenome(autor.getSobrenome());
		autordb.setIniciais(autor.getIniciais());
		autordb.setSexo(autor.getSexo());
		autordb.setInstituicao(autor.getInstituicao());
		autordb.setAssinatura(autor.getAssinatura());
		autordb.setLattes(autor.getLattes());
		autordb.setFone(autor.getFone());
		autordb.setCelular(autor.getCelular());
		autordb.setEnderecoPostal(autor.getEnderecoPostal());
		autordb.setResumoBiografia(autor.getResumoBiografia());

		usuarios.update(usuariodb);
	}

}
