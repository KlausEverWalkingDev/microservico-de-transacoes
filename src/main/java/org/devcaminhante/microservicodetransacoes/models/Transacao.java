package org.devcaminhante.microservicodetransacoes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.devcaminhante.microservicodetransacoes.enums.TipoDeTransacao;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Transacao{ 
	private @Id @GeneratedValue Long id;
	private TipoDeTransacao tipo;
	private Long contaOrigem;
	private Long contaDestino;
	private BigDecimal valor = new BigDecimal(0);
	private Date data = new Date();
	
	public Transacao(TipoDeTransacao tipo, Long contaOrigem, Long contaDestino, BigDecimal valor) {
		this.tipo = tipo;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
	}

	public Transacao(TipoDeTransacao tipo, Long contaOrigem, BigDecimal valor) {
		this.tipo = tipo;
		this.contaOrigem = contaOrigem;
		
		switch (tipo) {
			case DEPOSITO -> {
				this.valor = this.valor.add(valor);
			}
			case SAQUE -> {
				this.valor = this.valor.subtract(valor);
			}
		}
	}

	public Transacao(TipoDeTransacao tipo, Long contaOrigem) {
		this.tipo = tipo;
		this.contaOrigem = contaOrigem;
	}
}
