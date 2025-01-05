package org.mihailivadaru.chattiemporeal.servicios;

import org.mihailivadaru.chattiemporeal.entidades.Usuario;
import org.mihailivadaru.chattiemporeal.repositorios.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioUsuario {

    @Autowired
    private RepoUsuario repoUsuario;

    public Optional<Usuario> getUsuarioByNombre(String nombre) {
        return repoUsuario.findByNombre(nombre);
    }

    public Usuario crearUsuario(Usuario usuario) {
        return repoUsuario.save(usuario);
    }
}
