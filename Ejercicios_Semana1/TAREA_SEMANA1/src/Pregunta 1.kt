//Pregunta2: Calcular bonos y rendimiento de un colaborador

// Función que recibe los puntos de un colaborador y devuelve su nivel de rendimiento
fun obtenerNivel(puntos: Int): String {
  return when (puntos) {
    in 0..3 -> "Inaceptable"   // Si está entre 0 y 3
    in 4..6 -> "Aceptable"     // Si está entre 4 y 6
    in 7..10 -> "Meritorio"    // Si está entre 7 y 10
    else -> "Puntuación inválida" // Para cualquier número fuera del rango
  }
}

// Función que calcula el bono del colaborador
// Fórmula: salario * (puntos/10)
fun calcularBono(salario: Double, puntos: Int): Double {
  return salario * (puntos / 10.0)
}

// Función principal
fun main() {

  println("Ingrese su salario mensual:")
  val salario = readln().toDouble()


  println("Ingrese su puntuación (0-10):")
  val puntos = readln().toInt()

  // Calculamos el nivel y el bono usando las funciones
  val nivel = obtenerNivel(puntos)
  val bono = calcularBono(salario, puntos)


  println("Nivel de Rendimiento: $nivel")
  println("Cantidad de dinero recibido: $bono")
}
