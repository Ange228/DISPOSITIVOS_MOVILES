fun suma(a: Double, b: Double) = a + b
fun resta(a: Double, b: Double) = a - b
fun multiplicar(a: Double, b: Double) = a * b
fun dividir(a: Double, b: Double): Double {
  return if (b != 0.0) a / b else Double.NaN
}

fun main() {
  var opcion: Int
  do {
    println("""
            = Menú =
            1. Suma
            2. Resta
            3. Multiplicación
            4. División
            5. Salir
        """.trimIndent())

    opcion = readln().toInt()

    if (opcion in 1..4) {
      println("Ingrese primer número:")
      val num1 = readln().toDouble()
      println("Ingrese segundo número:")
      val num2 = readln().toDouble()

      val resultado = when (opcion) {
        1 -> suma(num1, num2)
        2 -> resta(num1, num2)
        3 -> multiplicar(num1, num2)
        4 -> dividir(num1, num2)
        else -> 0.0
      }
      println("Resultado: $resultado")
    } else if (opcion != 5) {
      println("Opción inválida")
    }

  } while (opcion != 5)

  println("Saliendo de la calculadora...")
}
