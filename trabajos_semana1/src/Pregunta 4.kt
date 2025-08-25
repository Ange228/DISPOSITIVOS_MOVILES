import kotlin.random.Random

fun juegoAdivinar() {
  val secreto = Random.nextInt(1, 31)  // 1 a 30
  var intentos = 5

  println("Adivina el número entre 1 y 30. Tienes $intentos intentos.")

  while (intentos > 0) {
    println("Ingresa tu número:")
    val guess = readln().toInt()

    if (guess == secreto) {
      println("Felicitaciones, adivinaste! El número era $secreto.")
      return
    } else if (guess < secreto) {
      println("El número secreto es mayor.")
    } else {
      println("El número secreto es menor.")
    }

    intentos--
    println("Te quedan $intentos intentos.")
  }

  println("Perdistee!. El número era $secreto.")
}

fun main() {
  juegoAdivinar()
}
