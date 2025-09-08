// Definimos la clase CuentaBancaria como data class porque maneja datos principales del objeto
// Tiene propiedades: limite_Retiro, saldo_actual, nombre y monto_retiro
data class CuentaBancaria (
  var limite_Retiro: Int,       // Límite máximo de dinero que se puede retirar
  var saldo_actual: Float,      // Saldo disponible en la cuenta
  var nombre: String,           // Nombre del dueño de la cuenta
  var monto_retiro: Float = 0f  // Monto que se desea retirar (inicializado en 0)
) {
  // Metodo para mostrar la información de la cuenta al usuario
  fun mostrarInfo() {
    println("Bienvenido a tu cuenta bancaria $nombre")
    println("Tu limite de retiro es: $limite_Retiro")
    println("Tu saldo es: $saldo_actual")
  }

  // Metodo para realizar un retiro de dinero
  fun retiro(){
    print("Ingresa el monto a retirar: ")
    val input = readLine()                  // Leemos la entrada del usuario desde consola
    val monto = input?.toFloatOrNull()      // Convertimos a Float, si no se puede devuelve null

    // Validación: si el monto no es un número válido, se detiene el proceso
    if (monto == null){
      println("El monto debe ser un número.")
      return
    }

    monto_retiro = monto // Guardamos el valor ingresado en la propiedad de la clase

    // Validación: si el monto es mayor que el saldo, no se puede retirar
    if(monto_retiro > saldo_actual)
      println("Lo sentimos, saldo insuficiente en tu cuenta")
    else
      saldo_actual -= monto_retiro // Se descuenta el monto del saldo
    println("Retiro exitoso de: $monto_retiro tu saldo es: $saldo_actual")
  }
}

// Funcion principal donde se prueba la clase CuentaBancaria
fun main() {
  // Se crea una instancia de la clase con valores iniciales
  val c = CuentaBancaria(999, 20.50f, "Carlos")

  // Se actualizan manualmente algunas propiedades
  c.saldo_actual = 50.0f
  c.nombre = "Carlos"

  // Se llama a mostrarInfo() para imprimir datos de la cuenta
  c.mostrarInfo()

  // Se llama a retiro() para interactuar con el usuario y retirar dinero
  c.retiro()
}
