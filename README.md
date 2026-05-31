# Proyecto: Código Limpio a Contenido Audiovisual
## Descripción del proyecto
Este proyecto tiene como objetivo aplicar los conceptos revisados durante el segundo semestre de la materia de Programación Orientada a Objetos.  
El sistema permite gestionar contenido audiovisual, incluyendo películas, series de TV, documentales, actores, temporadas e investigadores. Además, se aplicaron principios de código limpio, refactorización, SOLID, patrón MVC, manejo de archivos CSV y pruebas unitarias con JUnit 5.
## Cambios realizados
### Manejo de archivos
Se agregó la lectura y escritura de datos mediante archivos CSV, para esto se implementó la clase `RepositorioCSV`, encargada de guardar y leer información del sistema, también se agregaron archivos CSV con datos de:
- Contenidos audiovisuales
- Actores
- Temporadas
- Investigadores

### Refactorización y código limpio
Se mejoraron los nombres de clases, métodos y variables para que sean más claros y representen mejor su propósito, también se redujo el código duplicado al separar responsabilidades en métodos más pequeños y reutilizables y los comentarios innecesarios fueron eliminados para mantener el código más limpio y fácil de leer.
### Principios SOLID
Se aplicaron principios SOLID para mejorar la estructura del sistema:
- **SRP:** Cada clase tiene una responsabilidad específica.
- **OCP:** El sistema permite agregar nuevos tipos de contenido sin modificar gran parte del código existente.
- **LSP:** Las clases `Pelicula`, `SerieDeTV` y `Documental` pueden usarse como objetos de tipo `ContenidoAudiovisual`.
- **ISP:** Se agregaron interfaces específicas como `Mostrable`, `LectorDatos` y `EscritorDatos`.
- **DIP:** se reutilizó `RepositorioCSV` para la lectura y escritura de datos, evitando depender directamente de implementaciones dispersas.

### Patrón MVC
El proyecto fue organizado siguiendo el patrón MVC:
- **Modelo:** Contiene las clases principales del sistema, como `Pelicula`, `SerieDeTV`, `Documental`, `Actor`, `Temporada` e `Investigador`.
- **Vista:** la clase `VistaConsola` muestra el menú y los datos al usuario.
- **Controlador:** la clase `ControladorContenido` conecta la vista con los datos del sistema.

### Pruebas unitarias
Se agregaron pruebas unitarias con JUnit 5 dentro de la carpeta `test`, estas pruebas verificaron funcionalidades principales del sistema, como:
- Creación de objetos.
- Relaciones entre clases.
- Lectura y escritura de datos.
- Funcionamiento del repositorio CSV.

## Estructura del código
```text
poo_unidad1/
├── src/
│   └── poo/
│       ├── PruebaAudioVisual.java
│       └── unia/
│           ├── Actor.java
│           ├── ContenidoAudiovisual.java
│           ├── ControladorContenido.java
│           ├── Documental.java
│           ├── EscritorDatos.java
│           ├── ExportableCSV.java
│           ├── FabricaContenidoAudiovisual.java
│           ├── Investigador.java
│           ├── LectorDatos.java
│           ├── Mostrable.java
│           ├── Pelicula.java
│           ├── RepositorioCSV.java
│           ├── SerieDeTV.java
│           ├── Temporada.java
│           └── VistaConsola.java
├── test/
│   └── unia/
│       ├── ClasesRelacionadasTest.java
│       ├── ContenidoAudiovisualTest.java
│       ├── FabricaContenidoAudiovisualTest.java
│       └── RepositorioCSVTest.java
├── diagrama_clases.png
└── README.md
```

## Cómo ejecutar el proyecto
1. Abrir el proyecto en Eclipse.
2. Ir a la clase `src/poo/PruebaAudioVisual.java`.
3. Dar clic derecho sobre el archivo.
4. Seleccionar `Run As > Java Application`.
5. Usar el menú de consola para acceder a contenidos, actores, temporadas, investigadores o guardar datos.

## Cómo ejecutar las pruebas
1. Verificar que JUnit 5 esté agregado al proyecto.
2. Dar clic derecho sobre la carpeta `test`.
3. Seleccionar `Run As > JUnit Test`.
4. El resultado esperado es: `Errors: 0 Failures: 0`.
