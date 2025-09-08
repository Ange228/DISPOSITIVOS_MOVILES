// Se usa abstract para obligar a las subclases a implementar mostrarDetalles()
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles() // Metodo abstracto (cada subclase lo implementa distinto)
}

// Hereda de Material y añade propiedades específicas
class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,          // Propiedad adicional: género literario
    val numPaginas: Int          // Propiedad adicional: número de páginas
) : Material(titulo, autor, anioPublicacion) {

    // Implementación obligatoria de mostrarDetalles()
    override fun mostrarDetalles() {
        println("Libro: $titulo")
        println("Autor: $autor")
        println("Año: $anioPublicacion")
        println("Genero: $genero")
        println("Número de paginas: $numPaginas")
        println("---------------------------")
    }
}

// Subclase que representa una Revista
// Hereda de Material y añade propiedades específicas
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,            // ISSN identifica publicaciones periódicas
    val volumen: Int,            // Volumen de la revista
    val numero: Int,             // Número específico de la revista
    val editorial: String        // Editorial que publica la revista
) : Material(titulo, autor, anioPublicacion) {
    // Implementación obligatoria de mostrarDetalles()
    override fun mostrarDetalles() {
        println("Revista: $titulo")
        println("Autor: $autor")
        println("Año: $anioPublicacion")
        println("ISSN: $issn")
        println("Volumen: $volumen, Número: $numero")
        println("Editorial: $editorial")
        println("---------------------------")
    }
}

// El usuario se define como data class porque solo contiene datos simples
data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
)
// Esta interfaz define las operaciones que debe tener cualquier biblioteca
// Se separa "qué hace" de "cómo lo hace"
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material)
    fun devolverMaterial(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservados(usuario: Usuario)
}

// Implementación concreta de la interfaz IBiblioteca
class Biblioteca : IBiblioteca {
    // Lista mutable de materiales que están disponibles para préstamo
    private val materialesDisponibles = mutableListOf<Material>()

    // Lista de usuarios registrados
    private val usuarios = mutableListOf<Usuario>()

    // Mapa que relaciona cada usuario con la lista de materiales que tiene en préstamo
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    // Registrar un material en la biblioteca
    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Material registrado: ${material.titulo}")
    }

    // Registrar un usuario en la biblioteca
    override fun registrarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
        prestamos[usuario] = mutableListOf() // Inicializa lista de préstamos vacía
        println("Usuario registrado: ${usuario.nombre} ${usuario.apellido}")
    }

    // Metodo para prestar un material a un usuario
    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)   // Se quita de disponibles
            prestamos[usuario]?.add(material)       // Se añade a préstamos del usuario
            println("${material.titulo} prestado a ${usuario.nombre}")
        } else {
            println("El material no está disponible.")
        }
    }

    // Metodo para devolver un material
    override fun devolverMaterial(usuario: Usuario, material: Material) {
        if (prestamos[usuario]?.contains(material) == true) {
            prestamos[usuario]?.remove(material)    // Se quita de préstamos del usuario
            materialesDisponibles.add(material)     // Vuelve a estar disponible
            println("${material.titulo} devuelto por ${usuario.nombre}")
        } else {
            println("El usuario no tiene este material en préstamo.")
        }
    }
    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        if (materialesDisponibles.isEmpty()) {
            println("No hay materiales disponibles.")
        } else {
            materialesDisponibles.forEach { it.mostrarDetalles() }
        }
    }
    override fun mostrarMaterialesReservados(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre}:")
        val materiales = prestamos[usuario]
        if (materiales.isNullOrEmpty()) {
            println("No tiene materiales en préstamo.")
        } else {
            materiales.forEach { it.mostrarDetalles() }
        }
    }
}

fun main() {
    val biblioteca = Biblioteca()
    val libro1 = Libro("El Principito", "Antoine de Saint-Exupéry", 1943, "Fábula", 120)
    val libro2 = Libro("1984", "George Orwell", 1949, "Distopía", 328)
    val revista1 = Revista("National Geographic", "Varios", 2023, "1234-5678", 12, 4, "NatGeo")
    val usuario1 = Usuario("Carlos", "Gómez", 25)
    val usuario2 = Usuario("Ana", "Pérez", 30)

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(libro2)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.prestarMaterial(usuario1, libro1)
    biblioteca.prestarMaterial(usuario2, revista1)
    biblioteca.mostrarMaterialesReservados(usuario1)
    biblioteca.mostrarMaterialesReservados(usuario2)
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.devolverMaterial(usuario1, libro1)
    biblioteca.mostrarMaterialesDisponibles()
}
