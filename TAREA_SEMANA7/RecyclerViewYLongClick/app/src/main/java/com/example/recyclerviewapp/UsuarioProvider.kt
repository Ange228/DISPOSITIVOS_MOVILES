package com.example.recyclerviewapp

class UsuarioProvider private constructor(){

    companion object{
        val instance: UsuarioProvider = UsuarioProvider()
    }

    val listaUsuario = arrayListOf<Usuario>(
        Usuario("Marta", 20, "marta@gmail.com", "1232"),
        Usuario("Maria", 20, "maria@gmail.com", "1234"),
        Usuario("Juan", 20, "juan@gmail.com", "1230"),
        Usuario("Angela", 20, "angela@gmail.com", "1734"),
        Usuario("Miguel", 20, "miguel@gmail.com", "1834"),
        Usuario("Camila", 20, "camila@gmail.com", "1234"),
        Usuario("Pedro", 20, "pedro@gmail.com", "1214"),
        Usuario("Violeta", 20, "violeta@gmail.com", "1434"),
        Usuario("Carlos", 20, "carlos@gmail.com", "1274"),
        Usuario("Maria", 20, "maria@gmail.com", "1214"),
        Usuario("Karla", 20, "karla@gmail.com", "1534"),
        Usuario("Isabel", 20, "isabel@gmail.com", "1934"),
        Usuario("Roberto", 20, "roberto@gmail.com", "1434"),
        Usuario("Almendra", 20, "almendra@gmail.com", "1834"),
        Usuario("Pedro", 20, "pedro@gmail.com", "1334"),
        Usuario("Juana", 20, "juana@gmail.com", "1632")
    )

}