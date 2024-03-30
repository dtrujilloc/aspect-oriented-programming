# Proyecto sin Programacion Orientada a Aspectos

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