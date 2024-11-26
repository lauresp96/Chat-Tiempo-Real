package org.mihailivadaru.chattiemporeal.servicios;

import org.mihailivadaru.chattiemporeal.entidades.Mensaje;
import org.mihailivadaru.chattiemporeal.entidades.Usuario;
import org.mihailivadaru.chattiemporeal.repositorios.RepoMensaje;
import org.mihailivadaru.chattiemporeal.repositorios.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioChat {


    @Autowired
    private RepoUsuario repoUsuario;

    @Autowired
    private RepoMensaje repoMensaje;

    // Nombre especial para el sistema
    private static final String USUARIO_SISTEMA = "Sistema";

    public List<Mensaje> obtenerMensajes() {
        return repoMensaje.findAllByOrderByFechaAsc();
    }

    public void enviarMensaje(String nombreUsuario, String textoMensaje) {
        // Buscar o crear el usuario del cliente
        Usuario usuario = repoUsuario.findByNombre(nombreUsuario)
                .orElseGet(() -> {
                    Usuario nuevoUsuario = new Usuario();
                    nuevoUsuario.setNombre(nombreUsuario);
                    return repoUsuario.save(nuevoUsuario);
                });

        // Crear y guardar el mensaje del usuario
        Mensaje mensaje = new Mensaje();
        mensaje.setUsuario(usuario);
        mensaje.setMensaje(textoMensaje);
        repoMensaje.save(mensaje);

        // Obtener o crear el usuario "Sistema"
        Usuario sistema = repoUsuario.findByNombre(USUARIO_SISTEMA)
                .orElseGet(() -> {
                    Usuario nuevoSistema = new Usuario();
                    nuevoSistema.setNombre(USUARIO_SISTEMA);
                    return repoUsuario.save(nuevoSistema);
                });

        // Respuesta automática del sistema
        String respuestaAutomatica = obtenerRespuestaAutomatica(textoMensaje);

        // Guardar el mensaje de respuesta automática enviado por el "Sistema"
        Mensaje mensajeAuto = new Mensaje();
        mensajeAuto.setUsuario(sistema);
        mensajeAuto.setMensaje(respuestaAutomatica);
        repoMensaje.save(mensajeAuto);
    }


    private String obtenerRespuestaAutomatica(String mensaje) {
        if (mensaje.toLowerCase().contains("ayuda")) {
            return "¿Cómo podemos ayudarte?";
        } else if (mensaje.toLowerCase().contains("precio")) {
            return "Nuestros precios están disponibles en el sitio web.";
        } else {
            return "Gracias por tu mensaje, te responderemos pronto.";
        }
    }
}