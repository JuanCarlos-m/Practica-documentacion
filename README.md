# Practica Documentacion.

## Descripción
Este es un programa para simular el funcionamiento de un sistema de gestion de compraventa de productos de una tienda.
El programa guarda los productos almacenados en archivos de texto .txt

## Clases del programa:

* **Cargar ficheros**:
  La clase cargarFicheros consiste en metodos estaticos centrados en abrir los ficheros para ser leidos y editados por el programa.
  El metodo abrirFicheros solo puede ser llamado por su propia clase, y su funcion es abrir los ficheros y extraer sus datos.
  Tres metodos, leerUsuarios, leerImperedecero, y leerPerecedero convierten los datos del fichero en objetos que puedan ser utiles para el programa.
* **Empleado**:
  La clase Empleado aloja el código de acceso, nombre, contraseña y el numero de ventas del empleado.
* **Producto**:
  La clase Producto aloja el código, la descripción, el precio y las unidades de los productos. Es una clase abstracta.
* **Perecedero**:
  La clase Perecedero hereda de Producto, almacena adicionalmente el dato de los días que le quedan al producto para caducar. 
  Posee una clase privada estática, a la que la clase llama en su constructor para calcular el precio final del producto en base a los días restantes de caducidad.
* **Imperecedero**
  La clase Imperecedero hereda de Producto y solo posee un constructor, a la hora de construir el objeto, hace el calculo entre el precio y el descuento que el producto tiene en el fichero.
  
 ## Funcionamiento:
 
 El programa se ejecuta desde consola, una vez iniciado preguntará por el codigo de acceso y contraseña del empleado:
 
 ```
 El programa esta iniciandose...
Bienvenido al programa de tienda.
Introduzca codigo de acceso y contraseña: 
Codigo de acceso:
 ```
 
 Cuando el usuario inicie sesión puede preparar el pedido, o cambiar su contraseña.
 El acceso a estos menus consiste en introducir por teclado el numero de la opcion deseada.
 
 ```
 Bienvenido usuario
¿Que desea hacer?
1 - Hacer pedido.
2 - Cambiar contraseña.
3 - Salir.
 ```
 
 La realizacion del pedido es sencilla:
 
 1. Se nos presenta un menu para añadir productos, ver el estado del pedido, o finalizarlo y pasar a caja.
 ```
 Elija una opcion:
1 - Añadir un producto.
2 - Visualizar precio total.
3 - Finalizar pediddo.
 ```
 
 2. Nos realizará otra pregunta:
 
 ```
 ¿Que tipo de producto busca?
1 - Imperecedero
2 - Perecedero
 ```
 
 3. Nos listará los productos disponibles
 
 ```
ref: 9494 | Descripcion: Lejia Neutrex | Precio: 4.05€ | Unidades restantes: 9
ref: 6434 | Descripcion: Atun en conserva | Precio: 2.4000000000000004€ | Unidades restantes: 15
ref: 777 | Descripcion: Palo de fregona | Precio: 2.25€ | Unidades restantes: 1
Introduzca el codigo del producto deseado:
 ```
 4. Tras introducir el codigo nos pedirá la cantidad.
```
Introduzca el codigo del producto deseado:
9494
Introduzca la cantidad deseada:
5
```

Tras este proceso, el producto que hemos pedido queda almacenado en memoria y volvemos al menú anterior.
Una vez seleccionados todos los productos podemos **finalizar el pedido**, imprimirá por consola el recibo y modificará los ficheros que almacenan los productos disponibles.

```
Elija una opcion:
1 - Añadir un producto.
2 - Visualizar precio total.
3 - Finalizar pediddo.
3
Factura:
Le ha atendido: usuario
Detalles del pedido:

ref: 9494 | Descripcion: Lejia Neutrex | Precio: 4.05€ | Cantidad: 5 | Precio total:20.25€
Total: 20.25€
```

