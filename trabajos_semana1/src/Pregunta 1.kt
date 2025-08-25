fun obtenerNivel(puntos: Int): String {
  return when (puntos) {
    in 0..3 -> "Inaceptable"
    in 4..6 -> "Aceptable"
    in 7..10 -> "Meritorio"
    else -> "Puntuación inválida"
  }
}

fun calcularBono(salario: Double, puntos: Int): Double {
  return salario * (puntos / 10.0)
}

fun main() {
  println("Ingrese su salario mensual:")
  val salario = readln().toDouble()

  println("Ingrese su puntuación (0-10):")
  val puntos = readln().toInt()

  val nivel = obtenerNivel(puntos)
  val bono = calcularBono(salario, puntos)

  println("Nivel de Rendimiento: $nivel")
  println("Cantidad de dinero recibido: $bono")
}
