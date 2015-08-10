# Proceso de creacion de MovieApp

* Lo primero es indicar que el minimo sdk soportado es el 16

* Primero se definió la estructura del activity principal, en la cual se colocó un textView con un boton dentro de un Relativelayout para escribir el nombre del actor y buscar las peliculas relacionadas a ese autor

* Luego en el mismo layout del activity se colocaron dos frameslayout uno para cargar un fragment desde el cual se toma el nombre del author y se llama a un metodo del Api service el cual recibe como parametro el nombre del author, este se encarga de hacer el request al API y devuelve un id de author

* En el fragment encargado del hacer la peticion para obtener el id, en el metodo success se crea otro fragment que es el que contiene el recycler view con la informacion de las peliculas, se evalua si ya esta creado en el framelayout si no existe se agrega a traves de un FragmentManager y si existe simplemente se reemplaza.

* Adicionalmente en se tiene un package llamado rest donde se encuentran todas las clases para establecer comunicacion con el servidor (en este caso usando retrofit), lo primero en ese package es definir la interface que permite listar todos los metodos a traves de los cuales se accede a los distintos endpoints que ofrezca el API en este caso solo se cuenta con dos endpoints para las tareas requeridas

* Luego de esto se definió el modelo de respuesta que es llamado en el callback de cada peticion en este caso se crearon dos modelos en el package models uno llamado AuthorIdResponse y otro llamado MovieListResponse en los cuales se define el formato de la respuesta del servidor

* Adicionalmente dentro del package rest se creo un adapter que permite configurar retrofit a traves de la creacion de ua instancia de la clase RestAdapter, adiocionalmente esa clase invoca a la interface y se crea un metodo a traves del cual se accede directamente al servicio de retrofit desde donde se invoque

* Dentro del package deserializer se creo una clase que permite crear un custom parser para tratar el json que llega como respuesta a las peticiones a traves de retrofit, y ese deserializaser se agrega a la configuracion Adapter

* Tambien se crearon 2 clases para la definicion de constantes utilizadas en las peticiones y en el deserializer

* En el package model se creo un modelo que tiene todos los datos que se mostraran en la lista de peliculas (nombre, average, imagen, etc)


