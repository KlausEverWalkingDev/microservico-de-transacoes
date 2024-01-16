package org.devcaminhante.microservicodetransacoes.services;

import org.devcaminhante.microservicodetransacoes.enums.TipoDeTransacao;
import org.devcaminhante.microservicodetransacoes.models.Transacao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ITransacaoService {
	List<Transacao> buscaTodos();
	Transacao insereDeposito(@RequestBody Transacao novaTransacao);
	Transacao insereSaque(@RequestBody Transacao novaTransacao);
	Transacao insereTransferencia(@RequestBody Transacao novaTransacao);
	List<Transacao> buscaPorTipo(@PathVariable String tipo);
	List<Transacao> buscaPorContaOrigem(@PathVariable Long contaOrigem);
	List<Transacao> buscaPorContaDestino(@PathVariable Long contaDestino);
	List<Transacao> buscaPorValor(@PathVariable BigDecimal valor);
	List<Transacao> buscaPorData(@PathVariable Date data);
}
