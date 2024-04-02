# Proyecto con Programacion Orientada a Aspectos

En este rama vemos un proyecto que simula una arquitectura en capas, tenemos las capas de controlador, servicio y data. Para
el ejemplo utilizamos una entidad llamada Producto la cual tiene una informacion basica para hacer un par de operaciones CRUD.
Para uso del ejemplo se utiliza un Array para simular el almacenamiento en BD.

Supongamos que queremos dar trazabilidad entra los metodos de nuestra aplicacion, para esto debemos registrar en cada metodo
el inicio y el fin del metodo, esto con el objetivo de dejar trazabilidad en los logs y posteriormente sirvan para el analisis
de insidentes.

Para lograr lo mencionado anteriormente sin AOP tenemos que ir metodo por metodo logiando el inicio y el fin de cada uno. Esto
da como resultado un codigo un poco mas sucio ya que hay lineas de codigo que interfieren con la fluides de cada uno de nuestros
metodos, ademas de que el metodo empieza a terner un responsabilidad la cual no es de cada metodo que es logiar esta trazabilidad,
Por otro lado vemos que se pueden empezar a repetir lineas de codigo muy similares.

Pero en este caso vamos a hacer uso de la PROGRAMACION ORIENTADA A ASPECTOS para modularizar una responsabilidad transversal de 
nuesto proyecto y llevarla a un modulo/componente completamente independendiente sin tener que modificar nuestro codigo principal.
Para esto lo que hicimos fue utilizar la dependencia de AOP y habilitar las configuracion para que nos permitiera crear un 
Aspecto (Aspect), en este caso este aspecto/clase se encargara de registro de logs de nuestra aplicacion, en este aspecto creamos 
diferentes puntos de corte (pointcut) para expresar e indicar en que puntos de nuestro codigo queremos implementar o ejecutar un 
consejo (Advice), es decir un comportamiento que queremos que se ejecute, en este caso es el registro de logs al principio y despues
de los metodos de las clases controlador, servicio y repositorio.

Con esta implementacion podemos evidencias la forma de modularizar diferentes funcionalidades transversales de nuestro codigo en 
componentes complementamente independientes a nuestro codigo.