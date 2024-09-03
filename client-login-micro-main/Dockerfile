# Usar una imagen base de Node.js
FROM node:22-alpine

# Crear un directorio para la aplicación
WORKDIR /app

# Copiar los archivos del proyecto
COPY . .

# Instalar dependencias y construir la aplicación
RUN npm install
RUN npm run build

# Instalar un servidor estático para servir la aplicación
RUN npm install -g serve

# Exponer el puerto en el que corre la aplicación
EXPOSE 3000

# Comando para ejecutar el servidor estático
CMD ["serve", "-s", "dist","-l", "3000"]