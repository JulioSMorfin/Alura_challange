# Conversor de Monedas

Este es un programa en Java para convertir montos de USD a otras monedas utilizando la API de tasas de cambio.

## Requisitos

- Java 11 o superior
- Maven para gestión de dependencias (opcional)

## Configuración del Proyecto

1. **Descarga de Gson:**
   - Descarga el archivo JAR de Gson desde [Maven Repository - Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson) y colócalo en la carpeta `lib/` de tu proyecto.

2. **Compilación y Ejecución:**
   - Desde la terminal en Visual Studio Code o en tu terminal de sistema, ejecuta los siguientes comandos:

     ```bash
     javac -cp .:lib/gson-2.8.8.jar src/main/java/com/example/currencyconverter/App.java
     java -cp .:lib/gson-2.8.8.jar com.example.currencyconverter.App
     ```

## Fases del Proyecto

1. **Fase 1: Configuración Inicial del Proyecto**
   - Crea la estructura de directorios y archivos básicos.
   - Configura el entorno de desarrollo.

2. **Fase 2: Configuración de HttpClient**
   - Implementa HttpClient para realizar solicitudes a la API de tasas de cambio.

3. **Fase 3: Personalización de HttpRequest**
   - Personaliza las solicitudes HttpRequest para incluir parámetros específicos.

4. **Fase 4: Manejo de HttpResponse**
   - Gestiona las respuestas HttpResponse para analizar los elementos recibidos.

5. **Fase 5: Análisis de la Respuesta JSON con Gson**
   - Utiliza Gson para convertir la respuesta JSON en objetos Java y realizar operaciones con los datos.

6. **Fase 6: Interfaz de Usuario y Conversión de Moneda**
   - Implementa una interfaz de usuario para que el usuario pueda realizar conversiones de moneda de manera interactiva.

7. **Fase 7: Pruebas y Optimización**
   - Realiza pruebas exhaustivas para garantizar el correcto funcionamiento del programa.
   - Optimiza el código según sea necesario.

## Contribución

Si tienes sugerencias o mejoras para este proyecto, por favor crea un pull request o abre un issue.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.
