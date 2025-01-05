package org.mihailivadaru.chattiemporeal.controladores;


import org.mihailivadaru.chattiemporeal.entidades.Usuario;
import org.mihailivadaru.chattiemporeal.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario servicioUsuario;

    @GetMapping("/{nombre}")
    public Optional<Usuario> obtenerUsuario(@PathVariable String nombre) {
        return servicioUsuario.getUsuarioByNombre(nombre);
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return servicioUsuario.crearUsuario(usuario);
    }
}
