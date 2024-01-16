package org.devcaminhante.microservicodetransacoes.controllers;

import org.devcaminhante.microservicodetransacoes.models.Usuario;
import org.devcaminhante.microservicodetransacoes.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/")
	List<Usuario> buscaTodos() {
		return this.usuarioService.buscaTodos();
	};
	
	@PostMapping("/")
	Usuario insere(@RequestBody Usuario novoUsuario) {
		return this.usuarioService.insere(novoUsuario);
	}
	
	@GetMapping("/{id}")
	Usuario buscaPorId(@PathVariable Long id) {
		return this.usuarioService.buscaPorId(id);
	}
	
	@PutMapping("/{id}")
	Usuario substitui(@RequestBody Usuario novoUsuario, @PathVariable Long id) {
		return this.usuarioService.substitui(novoUsuario, id);
	}
	
	@DeleteMapping("/{id}")
	void deletaPorId(@PathVariable Long id) {
		this.usuarioService.deletaPorId(id);
	}
}
