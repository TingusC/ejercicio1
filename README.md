# Practica 1: Ficheros

**Repositorio Github:** https://github.com/TingusC/ejercicio1

### Creado por: Carlos Hermoso Delgado

## Enunciado:

Piensa una información que te gustaría guardar en un fichero para poder manejarla. La información a guardar no puede ser referente ni a alumnos, ni a empleados. Tiene que poseer al menos
cinco valores diferentes.
Cada uno de esos 5 elementos a guardar debe tener otros 5 campos:
- Un código (int)
- Un nombre (string)
- Otro campo (string)
- Un campo (float)
- Un quinto valor del tipo que quieras
1. Realizar un programa JAVA (CrearFichero_XXX.java) que cree un fichero (.dat) que guarde
esa información.
2. Realizar un programa JAVA(ModificarFichero_XXX.java) que permita modificar los datos
guardados. El programa recibe desde la línea de comando, el código a modificar, y los campos a modificar. Si el código no existe se mostrará un mensaje indicándolo. Visualiza también los datos antiguos.
3. A partir de los datos del fichero creado XXXX.dat crear un programa JAVA(CrearFicheroXML_XXX.java) que cree un fichero llamado XXXX.XML usando DOM y con acceso aleatorio al fichero dat.
4. Mostrar el fichero XML creado anteriormente usando SAX y DOM (LeerFicheroXML_XXX.java).
5. Convertir el fichero anterior (XXXX.xml) a través de un formato XSLT y un documento HTML
con una tabla que contenga al menos el nombre y la combinación de otros campos.

## Introducción:

Se han realizado los programas en base a datos de juadores de baloncesto. Todos estan guardados en la carpeta de *programas*. Se ejecutan desde el mismo pulsando el play en VS Code o lanzando un comando java desde la ruta del ejercicio1. Se deben ejecutar en el orden del enunciado para poder ya que utilizan los datos de los anteriores.

## Explicación de los programas:

### CrearFichero_CHD:

En este programa simplemente se ha creado un archivo .`dat` con datos de diferentes juadores de la NBA. Se ha utilizado `DataOutputStream` para hacerlo.

### CrearFicheroXML_CHD: 

Para crear el fichero XML a partir del archivo generado en el programa anterior. Primero creamos un acceso de tipo `RandomAccesFile` en solo lectura *"r"*. Posteriormente instaciamos un `DocumentBuilder` para crear un documento. Mediante el random acces file vamos adquiriendo la información guardada en el archivo y la guardamos en un `Element` dentro del documento. Finalmente intanciamos `Transformer` para crear el archivo `.xml` recogiendo el documento y la ruta deseada para el mismo.

### LeerFicheroXML_CHD:

Para leer el fichero se ha utilizado SAX. Como se vio en clase se ha creado una clase `GestionContenido` que extiende de la clase `DefaultHandler` y donde sobreescribimos algunos de sus metodos para adecur la lectura de nuestro documento XMl.

### ConvertirFicheroXML:

Este programa responde al punto 5 del enunciado. En el se transforma nuestro XML a HTML usando un archivo de plantilla XSL. Mediante este transformamos los datos del `.xml` a una tabla dividida por los jugadores. Utilizaremos el `Transformer`, visto en las diapositivas, que recibira el documento base y la plantilla y nos creara el `.html` en la ruta deseada.

## Notas: 

1. El programa de `ModificarFichero` falto por realizar. Tube muchos errores y no llegue acomprender la manera de realizarlo y solucionarlo.

1. Se ha intentado dar continuidad a las pautas dadas por Julian en la asignatura de *PSP*, uso de constantes, simplificacion del codigo mediante metodos, no hardcodear, no rpeticion de codigo...

1. A parte de los documentos y diapositivas del aula virtual he investigado por mi parte para realizar algunos de los ejercicios y la plantilla.