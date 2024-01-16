package org.devcaminhante.microservicodetransacoes.services;

import org.devcaminhante.microservicodetransacoes.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUsuarioService {
	List<Usuario> buscaTodos();
	Usuario insere(@RequestBody Usuario novoUsuario);
	Usuario buscaPorId(@PathVariable Long id);
	Usuario substitui(@RequestBody Usuario novoUsuario, @PathVariable Long id);
	void deletaPorId(@PathVariable Long id);
}
