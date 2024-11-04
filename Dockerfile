# Usar una imagen base con Java
FROM openjdk:22

# Directorio donde se colocará la aplicación en el contenedor
WORKDIR /app

# Copiar el archivo jar del proyecto al directorio /app en el contenedor
COPY out/artifacts/Prueba_jar/Prueba.jar /app/ms-spring-security-jwt.jar

# Exponer el puerto que usa la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/ms-spring-security-jwt.jar"]