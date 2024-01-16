package org.devcaminhante.microservicodetransacoes.services;

import org.devcaminhante.microservicodetransacoes.enums.TipoDeTransacao;
import org.devcaminhante.microservicodetransacoes.models.Transacao;
import org.devcaminhante.microservicodetransacoes.models.Usuario;
import org.devcaminhante.microservicodetransacoes.repositories.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TransacaoService implements ITransacaoService {
	private final TransacaoRepository transacaoRepository;
	private final UsuarioService usuarioService;

	public TransacaoService(TransacaoRepository transacaoRepository, UsuarioService usuarioService) {
		this.transacaoRepository = transacaoRepository;
		this.usuarioService = usuarioService;
	}
	
	@Override
	public List<Transacao> buscaTodos() {
		return this.transacaoRepository.findAll();
	}

	@Override
	public Transacao insereDeposito(Transacao novaTransacao) {
		novaTransacao.setTipo(TipoDeTransacao.DEPOSITO);
		
		Usuario contaOrigem = this.usuarioService.buscaPorId(novaTransacao.getContaOrigem());
		
		contaOrigem.setSaldo(contaOrigem.getSaldo().add(novaTransacao.getValor()));
		this.usuarioService.substitui(contaOrigem, contaOrigem.getId());
		
		return this.transacaoRepository.save(novaTransacao);
	}

	@Override
	public Transacao insereSaque(Transacao novaTransacao) {
		novaTransacao.setTipo(TipoDeTransacao.SAQUE);

		Usuario contaOrigem = this.usuarioService.buscaPorId(novaTransacao.getContaOrigem());
		BigDecimal saldoAtual = contaOrigem.getSaldo();
		
		if (saldoAtual.compareTo(novaTransacao.getValor()) >= 0) {
			contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(novaTransacao.getValor()));
			this.usuarioService.substitui(contaOrigem, contaOrigem.getId());
			
			return this.transacaoRepository.save(novaTransacao);
		}
		
		return null;
	}

	@Override
	public Transacao insereTransferencia(Transacao novaTransacao) {
		novaTransacao.setTipo(TipoDeTransacao.TRANSFERENCIA);

		Usuario contaOrigem = this.usuarioService.buscaPorId(novaTransacao.getContaOrigem());
		BigDecimal saldoAtualDaContaOrigem = contaOrigem.getSaldo();
		
		Usuario contaDestino = this.usuarioService.buscaPorId(novaTransacao.getContaDestino());

		if (saldoAtualDaContaOrigem.compareTo(novaTransacao.getValor()) >= 0) {
			contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(novaTransacao.getValor()));
			this.usuarioService.substitui(contaOrigem, contaOrigem.getId());
			
			contaDestino.setSaldo(contaDestino.getSaldo().add(novaTransacao.getValor()));
			this.usuarioService.substitui(contaDestino, contaDestino.getId());

			return this.transacaoRepository.save(novaTransacao);
		}

		return null;
	}

	@Override
	public List<Transacao> buscaPorTipo(String tipo) {
		
		return this.transacaoRepository.findAllByTipo(TipoDeTransacao.valueOf(tipo.toUpperCase()));
	}

	@Override
	public List<Transacao> buscaPorContaOrigem(Long contaOrigem) {
		return this.transacaoRepository.findAllByContaOrigem(contaOrigem);
	}

	@Override
	public List<Transacao> buscaPorContaDestino(Long contaDestino) {
		return this.transacaoRepository.findAllByContaDestino(contaDestino);
	}

	@Override
	public List<Transacao> buscaPorValor(BigDecimal valor) {
		return this.transacaoRepository.findAllByValor(valor);
	}

	@Override
	public List<Transacao> buscaPorData(Date data) {
		return this.transacaoRepository.findAllByData(data);
	}
}
