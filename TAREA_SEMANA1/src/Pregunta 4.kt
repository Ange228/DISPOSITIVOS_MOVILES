// Pregunta 4: Juego de adivinar número con 5 intentos usando Math.random()
fun juegoAdivinar() {
  // Generamos un número entre 1 y 30
  // Math.random() devuelve un Double entre 0.0 y 1.0
  // Lo multiplicamos por 30 -> rango 0.0 hasta 29.999...
  // Convertimos a Int y sumamos 1 -> rango final 1 a 30


  val secreto = (Math.random() * 30).toInt() + 1

  var intentos = 5  // El jugador tiene 5 intentos disponibles

  println("Adivina el número entre 1 y 30. Tienes $intentos intentos.")

  // Ciclo que se repite mientras queden intentos
  while (intentos > 0) {
    println("Ingresa tu número:")
    val guess = readln().toInt()  // Leemos el número ingresado por el usuario

    // Comparamos la respuesta con el número secreto
    if (guess == secreto) {
      println("Felicitaciones, adivinaste! El número era $secreto.")
      return  // Salimos de la función porque ya ganó
    } else if (guess < secreto) {
      println("El número secreto es mayor.")
    } else {
      println("El número secreto es menor.")
    }

    intentos--
    println("Te quedan $intentos intentos.")
  }

  //mostramos que perdió
  println("Perdiste. El número era $secreto.")
}

// Función principal
fun main() {
  juegoAdivinar()
}
