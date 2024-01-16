package org.devcaminhante.microservicodetransacoes.repositories;

import org.devcaminhante.microservicodetransacoes.enums.TipoDeTransacao;
import org.devcaminhante.microservicodetransacoes.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
	List<Transacao> findAllByTipo(TipoDeTransacao tipo);
	List<Transacao> findAllByContaOrigem(Long contaOrigem);
	List<Transacao> findAllByContaDestino(Long contaDestino);
	List<Transacao> findAllByValor(BigDecimal valor);
	List<Transacao> findAllByData(Date date);
}

