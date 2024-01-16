package org.devcaminhante.microservicodetransacoes.repositories;

import org.devcaminhante.microservicodetransacoes.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
