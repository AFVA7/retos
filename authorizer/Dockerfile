# imagen base de Java
FROM openjdk:17-jdk-slim

# directorio de trabajo dentro del contenedor
WORKDIR /app

# Se copia el archivo JAR generado en el contenedor
COPY build/libs/authorizer-0.0.1-SNAPSHOT.jar /app/authorizer.jar

# se expone el puerto en el que corre la aplicación
EXPOSE 80

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "authorizer.jar"]
