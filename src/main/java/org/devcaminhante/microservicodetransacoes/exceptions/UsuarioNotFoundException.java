package org.devcaminhante.microservicodetransacoes.exceptions;

public class UsuarioNotFoundException extends RuntimeException {
	public UsuarioNotFoundException(Long id) {
		super("Não encontrado usuário com o id " + id);
	}
}
