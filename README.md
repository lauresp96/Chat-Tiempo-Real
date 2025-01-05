# Proyecto de Chat en Tiempo Real con Spring Boot, Thymeleaf y MySQL

Este es un proyecto de chat en tiempo real implementado utilizando **Spring Boot**, **Thymeleaf** y **MySQL**. El sistema permite a los usuarios enviar mensajes y recibir respuestas automáticas del sistema (representado por un "usuario especial"). Este proyecto es ideal para practicar la integración de tecnologías como Spring Boot, Thymeleaf y el manejo de bases de datos con MySQL.

## Características

- **Envío de mensajes en tiempo real**: Los usuarios pueden enviar mensajes, los cuales se almacenan en una base de datos MySQL.
- **Respuestas automáticas**: El sistema responde automáticamente a los mensajes con una respuesta predefinida.
- **Base de datos MySQL**: Los usuarios y mensajes se almacenan en una base de datos MySQL.
- **Interfaz de usuario con Thymeleaf**: La aplicación utiliza Thymeleaf para renderizar las vistas del frontend.

## Tecnologías Utilizadas

- **Spring Boot**: Framework de desarrollo de aplicaciones en Java.
- **Thymeleaf**: Motor de plantillas para la creación de vistas.
- **MySQL**: Base de datos para almacenar los mensajes y usuarios.
- **Spring Data JPA**: Para la persistencia de datos con MySQL.
- **Java 11+**: Lenguaje de programación utilizado para el backend.

## Funcionalidad

### Enviar mensajes

1. Los usuarios pueden ingresar su nombre y un mensaje en la interfaz de usuario.
2. Los mensajes se guardan en la base de datos y se muestran en la página de chat.

### Respuesta automática

Cuando un usuario envía un mensaje, el sistema genera una **respuesta automática**:

- Si el mensaje contiene la palabra "ayuda", el sistema responde con: `¿Cómo podemos ayudarte?`.
- Si el mensaje contiene la palabra "precio", el sistema responde con: `Nuestros precios están disponibles en el sitio web.`.
- Para otros mensajes, el sistema responde con: `Gracias por tu mensaje, te responderemos pronto.`

### Sistema de usuarios

- Si el usuario que envía el mensaje no existe en la base de datos, se crea un nuevo registro para ese usuario.
- El sistema tiene un **usuario especial** llamado **"Sistema"** que es quien envía las respuestas automáticas.
