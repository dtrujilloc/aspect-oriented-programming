# AOP - Aspect Oriented Programming (Programacion Oriendtada a Aspectos)
La programacion oriendata a aspectos es un poderozo paradigma que permite complementar la programacion orienta a objetos.

Este paradigma esta enfocado en la modularizacion de operaciones transversales, es decir, en agrupar las operaciones
que se necesiten hacer en diferentes parates de su codigo y tenerlas separadas en un modulo completamente independiente a 
su codigo.

Supongamos que usted tiene un Clase la cual se encarga de realizar las operacion criticas e importantes en su codigo y es
de suma importancia registrar en los logs los valores de los atributos que llegan a cada metodo y la respuesta
de cada uno de ellos con el objetivo de dejar una trazabilidad. Si penzamos una manera rapida de hacer lo mencionado
anteriormente, llegamos a la conclusion de que es necesario colocar una linea de codigo al principio y al final de cada 
uno de los metodos, con el objetivo de imprimir o registar en los logs los valores que son necesarios. Esta forma nos 
permitiria solucionar la necesidad que se plantea, pero nos obligaria a escribir lineas de codigo que contaminan la legibilidad
de nuestro codigo.

Pues con la programacion orientada a aspectos podemos dar una solucion mas modular y sin contaminar nuestro codigo con lineas
de codigo que tal vez se puedan repetir en multiples secciones de nuestro codigo. Basicamente con la AOP podemos indicar en
que secciones/partes de nuestro codigo queremos que se ejecuten ciertos comportamientos que son transversales en nuestra
aplicacion.

algunos conceptos basicos e importantes en la AOP son:
- Aspect (Aspecto): Hace referencia a la Clase que encapsula o modulariza las acciones que queremos implementar de manera
transversal.
- Advice (Consejo): Es la accion que queremos que se realice en cierto seccion o punto de nuestro codigo. Basicamente son
los metodos que estan dentro de nuestros Aspectos. Estos se pueden ejecutar antes, despues, alrededor y despues del lanzamiento.
- Pointcut (punto de corte): Es una expresion que indica que punto de nuestro codigo se aplicara el consejo programado.
- Joint Point (Punto de union): Es un punto especifico en la ejecucion del codigo, como un metodo, un constructor, un acceso a
parametros.

En este respositorio construiremos un proyecto basico en una arquitectura de capas, en una rama, haremos la construccion sin utilizar
AOP y especificaremos y registraremos logs de trazabilidad en los metodos de las diferentes capas. Por ultimo, en otra rama,
construiremos el mismo proyecto haciendo uso de la AOP para identificar como se utiliza y el gran beneficio que puede tener
este paradigma en nuestros proyectos.