# Usar una imagen base de Java
FROM openjdk:17-jdk-alpine

# Crear un directorio de trabajo
WORKDIR /app

# Copiar el archivo fuente al contenedor
COPY . /app

# Compilar el código Java
RUN javac ClientApp.java

# Comando de entrada
CMD ["java", "ClientApp"]
