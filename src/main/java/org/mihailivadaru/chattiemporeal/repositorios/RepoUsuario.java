package org.mihailivadaru.chattiemporeal.repositorios;

import org.mihailivadaru.chattiemporeal.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoUsuario extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombre(String nombre);
}
