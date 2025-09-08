//Pregunta2: Piedra, papel o tijera

import kotlin.random.Random

// Función que recibe la elección del usuario y juega contra la compu
fun jugarPPT(usuario: String): String {
  val opciones = listOf("piedra", "papel", "tijera")
  val pc = opciones[Random.nextInt(opciones.size)]  // se elige aleatoriamente

  // Comparamos jugadas
  return if (usuario == pc) {
    "Empate. Ambos eligieron $usuario"
  } else if (
    (usuario == "piedra" && pc == "tijera") ||
    (usuario == "papel" && pc == "piedra") ||
    (usuario == "tijera" && pc == "papel")
  ) {
    "Ganaste! Tú: $usuario, Yo: $pc"
  } else {
    "Perdiste! Tú: $usuario, Yo: $pc"
  }
}

// Función principal
fun main() {
  println("Elige piedra, papel o tijera:")
  val usuario = readln().lowercase()   // Convertimos a minúsculas para comparar
  println(jugarPPT(usuario))
}
