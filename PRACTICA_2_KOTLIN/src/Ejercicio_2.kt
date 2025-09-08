// Definimos una clase de datos (data class) llamada Producto
// Una data class se usa porque representa principalmente datos, y nos da automáticamente métodos útiles (toString, equals, etc.)
data class Producto(
    private var _precio: Float,      // Propiedad privada para almacenar el precio real, evitando acceso directo
    private var _descuento: Float,   // Propiedad privada para el descuento, también controlada
    var precio_final: Float = 0f     // Propiedad pública que se calculará después
) {
    // Aqui se valida los valores correctos con getter y setter
    var precio: Float
        get() = _precio  // Getter devuelve el valor de _precio
        set(value) {
            // Validamos que el precio sea mayor a 0 antes de asignar
            if (value > 0) _precio = value
            else println("El precio debe ser mayor a 0.")
        }

    // Propiedad calculada con getter y setter para el descuento
    var descuento: Float
        get() = _descuento  // Getter devuelve el valor de _descuento
        set(value) {
            // Validamos que el descuento esté entre 0 y 1 (0% a 100%)
            if (value in 0.0..1.0) _descuento = value
            else println("El descuento debe estar entre 0 y 1.")
        }

    // Funcion para calcular el precio final aplicando el descuento
    fun calcularPrecioFinal() {
        // Fórmula: precio final = precio - (precio * descuento)
        precio_final = precio - (precio * descuento)
    }

    // Funcion para mostrar toda la información del producto
    fun mostrarInfo() {
        println("Bienvenido a Minizo")
        println("Escoja el producto que desea comprar: ")
        listaProductos()  // Llamamos a una función externa que lista los productos disponibles
        println("Precio del producto: $precio")
        println("Descuento aplicado: ${descuento * 100}%") // Mostramos el descuento en porcentaje
        calcularPrecioFinal()  // Llamamos al cálculo del precio final
        println("Precio final: $precio_final") // Mostramos el resultado
    }
}

// Funcion que muestra un listado de productos disponibles
fun listaProductos() {
    // Usamos una lista inmutable con nombres de productos
    val productos = listOf("1. Short casual", "2. Camisa oversize", "3. Zapatilla samba")
    // Iteramos sobre la lista para imprimir cada producto
    productos.forEach { println(it) }
}

// Funcion principal que se ejecuta al iniciar el programa
fun main() {
    // Creamos una instancia de la clase Producto con precio y descuento inicial
    val p = Producto(19.90f, 0.1f)
    p.mostrarInfo()
}
