# AEMET Tiempo - Android App
This project is done by a student from IES Politécnico Jesús Marín.

Mariano Fernández Rodero

# RoadMAP AEMET Mariano
## Version 0.6.1
* Añadidas todas las localidades de España.

## Version 0.6
* Añadidas imágenes a cada una de las filas del RecyclerView.
* Editada la clase `Tiempo` para seleccionar el temporal que hacer y devolver el ID del `drawable`.
* Editadas las clases `TemporalAdapter` y `TemporalViewHolder` para recoger los datos y exponer la foto en el RecycleView.
* Editada la clase `Respuesta` para recoger el dato del tiempo que hace en ese día en la localidad.
* Mínima optimización para la clase `Respuesta`.
* Remodelado el layout `activity_main` por completo.
* Retocado  el layout `recycler_activity`.
* Añadidas nuevas fuentes de letra.
* Añadidas imágenes que se mostrarán en el RecyclerView.

## Version 0.5.7
* Añadida la vista responsive.

## Version 0.5.6
* Mejoras de rendimiento.
* Fixeo parcial en algunos bugs a la hora de la búsqueda.

## Version 0.5.5
* Cambiados algunos `imports`

## Version 0.5.4
* Realizada mini mejora del rendimiento de búsqueda clases `MainController` y `MainActivity`

## Version 0.5.3
* Eliminados 2 modelos duplicados.

## Version 0.5.2
* Optimizado para mejor comprensión el parseo del `JSON` de la AEMET.

## Version 0.5.1
* Optimización de el gestor de búsqueda a la hora de la conversión de el `EditText` a `String`.

## Version 0.5
* Retirado texto hardcodeado del `EditText`.
* Cambiado de `ConstraintLayout` a `LinearLayout` el layout de `recycler_activity`.
* Creada la clase `Peticion` para pedir los datos metereológicos a la AEMET. 
* Creada la clase `Respuesta` para parsear el JSON que nos devuelva el `MainController`.
* Creadas las clases `TemporalAdapter` y `TemporalViewHolder` para mostrar los datos en el RecyclerView.
* Creada la clase `Fecha` para obtener el día de la semana que obtengamos de la clase `Respuesta`, parseado en JSON.
* Movida la clase `Respuesta` del paquete `Model` al paquete `Controller`.

## Version 0.4.1
* Creada la clase `Tiempo`

## Version 0.4
* Implementado el GSON en el `build.gradle`
* Retoques en las clases `MainActivity`, `Respuesta`, `Peticion` y `MainController`
* Eliminado el css añadido en el paquete `/res/assets`