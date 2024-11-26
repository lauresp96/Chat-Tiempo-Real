package org.mihailivadaru.chattiemporeal.controladores;

import org.mihailivadaru.chattiemporeal.servicios.ServicioChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorChat {


    @Autowired
    private ServicioChat servicioChat;

    @GetMapping("/")
    public String obtenerChat(Model model) {
        model.addAttribute("mensajes", servicioChat.obtenerMensajes());
        return "chat";
    }

    @PostMapping("/enviar")
    public String enviarMensaje(@RequestParam String nombreUsuario, @RequestParam String mensaje) {
        servicioChat.enviarMensaje(nombreUsuario, mensaje);
        return "redirect:/";
    }
}
