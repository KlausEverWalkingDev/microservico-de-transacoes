package org.devcaminhante.microservicodetransacoes.enums;

import lombok.Getter;

@Getter
public enum TipoDeTransacao{ 
	CONSULTA("consulta"),
	DEPOSITO("deposito"),
	SAQUE("saque"),
	TRANSFERENCIA("transferencia");
	
	public final String tipoDeTransacao;
	
	private TipoDeTransacao(String tipoDeTransacao) {
		this.tipoDeTransacao = tipoDeTransacao;
	}
}
