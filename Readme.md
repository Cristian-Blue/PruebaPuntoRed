# Veci - Prueba técnica Punto Red

Esta aplicación hace parte de la prueba técnica de punto red realizada con el framework spring, utilizando como base 
datos PostgrestSQL y realizando el consumo de una api externa proporcionada por la empresa, además proporcionando un
sistema de autenticación y control de seguridad por Authorization Bearer para las rutas protegidas

# Tabla de contenido

- [Introducción](#Veci---Prueba-técnica-Punto-Red)
- [Características](#Caracteristicas)
- [Estructura del proyecto](#Estructura-del-proyecto)
- [Instalación](#Instalación)
- [Ejecución](#Ejecución)
- [Estructura del Proyecto](#estructura-del-proyecto)

# Caracteristicas

- Sistema de inicio de sesión
- Recargas a números colombianos
- Consulta de recargas históricas
- Validación de campos
- Notificación de procesos
- Consumo de API externa punto red

# Estructura del proyecto

```bash
RecargasApp/
├── public/
├── src/
│   ├── main/
│   │   ├── java/prueba/            # Paquete principal de la aplicación
│   │   │   ├── config/             # Configuraciones de cors y seguridad
│   │   │   ├── controller/         # Controladores y rutas
│   │   │   ├── dto/                # Objetos generales utilizados
│   │   │   ├── model/              # Objetos relacionados a la base de datos
│   │   │   ├── repository/         # Consultas a base de datos
│   │   │   ├── services/           # Cosumo de servicio externo
│   │   ├── resources/              # Configuraciones generales  
├── .gitignore                      # Archivos ignorados por Git
├── pom.xml                         # Metadátos de la aplicación
├── README.md                       # Documentación del proyecto
└── ...
```

# Instalación

## Requerimientos

- Java (22)
- spring-boot (3.3.5)
- Maven

### Descarga del repositorio

```
    git clone https://github.com/Cristian-Blue/PruebaPuntoRed.git
    cd PruebaPuntoRed
```

### instalación

Configuración de variables de entorno **application.properties**
```
spring.application.name=Prueba

# CONNECTION DB
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=

# CONNECTION SERVICE PUNTO RED
puntored.api.end-pont=
puntored.x.api.key=

```

Comando de instalación
```
    mvn clean install
    mvn spring-boot:run
```

# Scripts
- **mvn spring-boot:run** : Ejecución en modo desarrollo
- **mvn clean package** : Construcción de archivo JAR
- **mvn test** : Ejecución testing


