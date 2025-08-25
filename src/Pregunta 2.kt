import kotlin.random.Random

fun jugarPPT(usuario: String): String {
  val opciones = listOf("piedra", "papel", "tijera")
  val pc = opciones[Random.nextInt(opciones.size)]

  return if (usuario == pc) {
    "Empate. Ambos elegimos $usuario"
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

fun main() {
  println("Elige piedra, papel o tijera:")
  val usuario = readln().lowercase()
  println(jugarPPT(usuario))
}
