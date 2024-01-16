package org.devcaminhante.microservicodetransacoes.controllers;

import org.devcaminhante.microservicodetransacoes.models.Transacao;
import org.devcaminhante.microservicodetransacoes.services.TransacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController{ 
	private final TransacaoService transacaoService;

	public TransacaoController(TransacaoService transacaoService) {
		this.transacaoService = transacaoService;
	}

	@GetMapping("")
	List<Transacao> buscaTodos() {
		return this.transacaoService.buscaTodos();
	};
	
	@PostMapping("/deposito")
	Transacao insereDeposito(@RequestBody Transacao novaTransacao) {
		return this.transacaoService.insereDeposito(novaTransacao);
	}
	
	@PostMapping("/saque")
	Transacao insereSaque(@RequestBody Transacao novaTransacao) {
		return this.transacaoService.insereSaque(novaTransacao);
	}
	
	@PostMapping("/transferencia")
	Transacao insereTransferencia(@RequestBody Transacao novaTransacao) {
		return this.transacaoService.insereTransferencia(novaTransacao);
	}

	@GetMapping("/{tipo}")
	List<Transacao> buscaTodos(@PathVariable String tipo) {
		return this.transacaoService.buscaPorTipo(tipo);
	};
}
