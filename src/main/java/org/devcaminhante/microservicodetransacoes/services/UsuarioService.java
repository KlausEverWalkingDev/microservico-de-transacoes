package org.devcaminhante.microservicodetransacoes.services;

import org.devcaminhante.microservicodetransacoes.exceptions.UsuarioNotFoundException;
import org.devcaminhante.microservicodetransacoes.models.Usuario;
import org.devcaminhante.microservicodetransacoes.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<Usuario> buscaTodos() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario insere(Usuario novoUsuario) {
		return this.usuarioRepository.save(novoUsuario);
	}

	@Override
	public Usuario buscaPorId(Long id) {
		return this.usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
	}

	@Override
	public Usuario substitui(Usuario novoUsuario, Long id) {
		return this.usuarioRepository.findById(id)
			.map(usuario -> {
				usuario.setNome(novoUsuario.getNome());
				usuario.setSaldo(novoUsuario.getSaldo());

				return this.usuarioRepository.save(usuario);
			}).orElseGet(() -> {
				novoUsuario.setId(id);

				return this.usuarioRepository.save(novoUsuario);
			});
	}

	@Override
	public void deletaPorId(Long id) {
		this.usuarioRepository.deleteById(id);
	}
}
