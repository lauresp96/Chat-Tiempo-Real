package org.mihailivadaru.chattiemporeal.repositorios;

import org.mihailivadaru.chattiemporeal.entidades.Mensaje;
import org.mihailivadaru.chattiemporeal.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoMensaje extends JpaRepository<Mensaje, Long> {

    List<Mensaje> findByUsuario(Usuario usuario);
    List<Mensaje> findAllByOrderByFechaAsc();
}
