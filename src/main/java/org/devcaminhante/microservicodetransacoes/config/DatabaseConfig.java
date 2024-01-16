package org.devcaminhante.microservicodetransacoes.config;

import org.devcaminhante.microservicodetransacoes.enums.TipoDeTransacao;
import org.devcaminhante.microservicodetransacoes.models.Transacao;
import org.devcaminhante.microservicodetransacoes.models.Usuario;
import org.devcaminhante.microservicodetransacoes.services.TransacaoService;
import org.devcaminhante.microservicodetransacoes.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;


@Configuration
public class DatabaseConfig{ 
	private static final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);
	
	@Bean
	CommandLineRunner iniciaDatabase(UsuarioService usuarioService, TransacaoService transacaoService){
		return args -> {
			// Cria 3 usuários			
			log.info("Carregando" + usuarioService.insere(new Usuario("Klaus Ferreira")));
			log.info("Carregando" + usuarioService.insere(new Usuario("Daya Schemens")));
			log.info("Carregando" + usuarioService.insere(new Usuario("Melissa Monfre")));

			// Todos fazem depósitos totalizando 500 dinheiros cada um em suas próprias contas
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 1L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 1L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 1L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 1L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 1L, new BigDecimal(100))));
			//
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 2L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 2L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 2L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 2L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 2L, new BigDecimal(100))));
			//
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 3L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 3L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 3L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 3L, new BigDecimal(100))));
			log.info("Carregando" + transacaoService.insereDeposito(new Transacao(TipoDeTransacao.DEPOSITO, 3L, new BigDecimal(100))));
			
			// Cada usuário faz transferências para os outros com valores diversos
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 1L, 2L, new BigDecimal(50))));
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 1L, 3L, new BigDecimal(60))));
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 2L, 1L, new BigDecimal(60))));
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 2L, 3L, new BigDecimal(50))));
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 3L, 1L, new BigDecimal(50))));
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 3L, 2L, new BigDecimal(60))));
			//
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 1L, 2L, new BigDecimal(60))));
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 1L, 3L, new BigDecimal(70))));
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 2L, 1L, new BigDecimal(70))));
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 2L, 3L, new BigDecimal(60))));
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 3L, 1L, new BigDecimal(60))));
			log.info("Carregando" + transacaoService.insereTransferencia(new Transacao(TipoDeTransacao.TRANSFERENCIA, 3L, 2L, new BigDecimal(70))));
			
			// http://localhost:8080/swagger-ui/index.html#/usuario-controller
			// http://localhost:8080/swagger-ui/index.html#/transacao-controller
		};
	}
}
