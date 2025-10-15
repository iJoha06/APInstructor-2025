Proyecto: Sistema de Gestión de Instructores
📘 Descripción

Este proyecto es una aplicación Spring Boot que permite gestionar la información de los instructores de una academia.
Implementa una API RESTful con operaciones CRUD (Crear, Leer, Actualizar y Eliminar) y una base de datos MySQL para la persistencia de datos.

El objetivo es ofrecer una base sólida para proyectos académicos o empresariales que necesiten administrar personal, cursos o datos similares.

-----------------------------------------------------------------------------------------------------------------------------------------------

⚙️ Tecnologías Utilizadas
* Java 17+
* Spring Boot 3.x
    Spring Web
    Spring Data JPA
    mysql-connector-j

🗄️ MySQL Workbench / MySQL Server
🧩 Hibernate (ORM)
🧰 Maven (gestor de dependencias)
💻 Postman (para probar endpoints)

-----------------------------------------------------------------------------------------------------------------------------------------------

Arquitectura del Proyecto - MVC (Model-View-Controller):
src
 └── main
     ├── java
     │   └── pe.negocio
     │       ├── controller     # Controladores REST
     │       ├── model          # Entidades JPA
     │       ├── repository     # Interfaces JPARepository
     │       └── service        # Lógica de negocio
     └── resources
         ├── application.properties
         └── static / templates 
         
-----------------------------------------------------------------------------------------------------------------------------------------------
Endpoints Principales:

     Crear un nuevo instructor:      http://localhost:8090/rest/instructor/agregar

 Listar todos los instructores:      http://localhost:8090/rest/instructor/listar
                                
   Buscar un instructor por ID:      http://localhost:8090/rest/instructor/buscar/1
                                
Editar un instructor existente:      http://localhost:8090/rest/instructor/editar/1
                                
 Eliminar un instructor por ID:      http://localhost:8090/rest/instructor/borrar/1
