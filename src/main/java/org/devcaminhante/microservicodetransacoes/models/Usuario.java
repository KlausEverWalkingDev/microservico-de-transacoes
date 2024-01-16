package org.devcaminhante.microservicodetransacoes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Usuario { 
	private @Id @GeneratedValue Long id;
	private @NonNull String nome;
	private BigDecimal saldo = BigDecimal.valueOf(0);
	
	public Usuario(@NonNull String nome) {
		this.nome = nome;
	}
}
