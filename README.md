Proyecto: Código Limpio a Contenido Audiovisual
Descripción del proyecto
Este proyecto tiene como objetivo la práctica de todos los conceptos revisados a lo largo del segundo semestre de la materia de programación orientada a objetos, así como también asegurar el adecuado manejo de herramientas de trabajo conjunto para programadores.

Cambios Realizados
•	Dentro del apartado de manejo de archivos se agregó, lectura y escritura de datos mediante archivos CSV, se implementó la clase Repositorios con el objetivo de guardar y leer información y se agregaron archivos en contenidos audiovisuales como actores, temporada e investigadores.
•	En cuanto a la refactorización y código limpio se mejoraron los nombres de las clases, métodos y variables, además se redujo en gran porcentaje el código duplicado al dividir responsabilidades en métodos más pequeños y se eliminaron comentarios innecesarios.
•	Tomando en cuenta los principios SOLID, se aplicó la responsabilidad única al separar las tareas de cada clase, se agregaron interfaces pequeñas como Mostrable, Exportable, LectorDatosy EscritorDatos; de igual forma se mantuvo la herencia entre ContenidoAudiovisual y sus subclases, finalmente se reutilizo para lectura y escritura la clase RepositorioCSV.
•	Para el patrón MVC se distribuyó el proyecto de la siguiente manera:
	Modelo: Clases: Pelicula, SerieDeTv, Documental, Actor, Temporada e Investigador
	Vista: La clase VistaConsola, es aquella que muestra el menú y los datos
	Controlador: La clase ControladorContenido, es aquella que conecta la vista con los datos del sistema
•	Las pruebas unitarias se encuentran dentro de la carpeta test y se agregaron con Junit 5. 
Estructura del código 
poo_unidad1
	src
	     poo
		PruebaAudiovisual.java
     uni1a
     		 Actor.java
      		ContenidoAudiovisual.java
      		ControladorContenido.java
     		 Documental.java
      		EscritorDatos.java
      		ExportableCSV.java
      		FabricaContenidoAudiovisual.java
      		Investigador.java
     		 LectorDatos.java
      		Mostrable.java
     		 Pelicula.java
      		RepositorioCSV.java
      		SerieDeTV.java
      		Temporada.java
      		VistaConsola.java
test
                 uni1a
    	 	ClasesRelacionadasTest.java
      		ContenidoAudiovisualTest.java
      		FabricaContenidoAudiovisualTest.java
     		RepositorioCSVTest.java
  	diagrama_clases.png
  	README.md
¿Cómo clonar el repositorio? 
1.	Copiar el URL del repositorio.
2.	Abrir Eclipse, buscar File en la parte superior, clic derecho y buscar Import.
3.	Dar clic en la carpeta Git y seleccionar Projects from Git, dar clic en next.
4.	Seleccionar Clone URI, presionar next y en la sección de Location pegar el URL antes proporcionado.
5.	En el apartado de Authentication ingresar el usuario y la contraseña de GitHub y dar clic en next.
6.	Selecciona todo lo que desees descargar y elige en que carpeta guardarlo, finalmente se importará el proyecto.
¿Cómo clonar el repositorio? 
1.	Abrir el proyecto en Eclipse.
2.	Ir a la clase src/poo/PruebaAudioVisual.java y dar clic derecho sobre el archivo.
3.	Seleccionar Run As > Java Application.
4.	Usar el menú diseñado en la consola para acceder a contenido, actores, temporadas, investigadores o guardar datos.
¿Cómo ejecutar las pruebas?
1.	Verifique que JUNIT 5 esté agregado al proyecto.
2.	Clic sobre la carpeta test y posteriormente seleccionar Run As > JUnit Test.
3.	El resultado que se espera es Errors: 0 – Failures: 0.
