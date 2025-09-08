// Definimos una clase abstracta "Shape"
// Una clase abstracta sirve como base para que otras clases hereden de ella,
// y obliga a implementar ciertos métodos (en este caso área y perímetro).
abstract class Shape {
    var area: Double = 0.0        // Propiedad común para todas las figuras: área
    var perimetro: Double = 0.0   // Propiedad común para todas las figuras: perímetro

    // Métodos abstractos: las subclases están obligadas a implementarlos
    abstract fun calcularArea()
    abstract fun calcularPerimetro()

    // Metodo común para todas las figuras: mostrar resultados
    fun mostrarResultados(nombre: String) {
        println("Figura: $nombre")
        println("Área: $area")
        println("Perímetro: $perimetro")
        println("---------------------------")
    }
}

// Subclase Cuadrado que hereda de Shape
class Cuadrado(var lado: Double) : Shape() {
    // Constructor secundario que permite inicializar un cuadrado vacío
    constructor() : this(0.0)

    // Implementación de los métodos abstractos de Shape
    override fun calcularArea() {
        area = lado * lado  // Fórmula del área de un cuadrado
    }

    override fun calcularPerimetro() {
        perimetro = 4 * lado  // Fórmula del perímetro de un cuadrado
    }
}

// Subclase Rectángulo que hereda de Shape
class Rectangulo(var base: Double, var altura: Double) : Shape() {
    constructor() : this(0.0, 0.0) // Constructor secundario para inicializar vacío

    override fun calcularArea() {
        area = base * altura  // Fórmula del área de un rectángulo
    }

    override fun calcularPerimetro() {
        perimetro = 2 * (base + altura)  // Fórmula del perímetro de un rectángulo
    }
}

// Subclase Círculo que hereda de Shape
class Circulo(var radio: Double) : Shape() {
    constructor() : this(0.0) // Constructor secundario para inicializar vacío

    override fun calcularArea() {
        area = Math.PI * radio * radio  // Fórmula del área de un círculo: πr²
    }

    override fun calcularPerimetro() {
        perimetro = 2 * Math.PI * radio  // Fórmula del perímetro (circunferencia): 2πr
    }
}

// Función principal donde creamos instancias de las figuras
fun main() {
    // Creamos un cuadrado con lado = 5.0
    val cuadrado = Cuadrado(5.0)
    cuadrado.calcularArea()        // Calculamos el área
    cuadrado.calcularPerimetro()   // Calculamos el perímetro
    cuadrado.mostrarResultados("Cuadrado")

    // Creamos un rectángulo con base 4.0 y altura 6.0
    val rectangulo = Rectangulo(4.0, 6.0)
    rectangulo.calcularArea()
    rectangulo.calcularPerimetro()
    rectangulo.mostrarResultados("Rectángulo")

    // Creamos un círculo con radio 3.0
    val circulo = Circulo(3.0)
    circulo.calcularArea()
    circulo.calcularPerimetro()
    circulo.mostrarResultados("Círculo")
}
