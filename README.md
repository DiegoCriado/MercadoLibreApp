# MercadoLibreApp

Librerias:

Arquitectura y Diseño:
Navigation component -> Dado que es únicamente una aplicación con tres pantallas en donde la función principal
es desplegar un listado de elementos y luego el detalle, me pareció que iba a ser mas eficaz utilizar navigation graph para manejar la navegación de ui,
asi como tambien los datos que envio desde un fragmento a otra al mostrar el detalle. 
ViewModel -> utilize viewModel para trabjar los datos relacionados con la ui de manera optimizada.

Adapter y RecyclerView -> Para desplegar el listado de elementos que consumo desde la API.

Servicios:
Retrofit2: Utilize las librerias de Retrofit para realizar las llamadas a los servicios.
Cortinas: utilize corrutinas manipular las peticiones realizadas a la API.

Views:
Glide -> se utilizo esta librería para las imágenes.
//Circle Img -> se utilizó para dar un aspecto redondo en las imágenes.



