import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFFFF1F6),
      appBar: AppBar(
        backgroundColor: const Color(0xFFFFC9D9),
        elevation: 0,
        title: const Text(
          "Hobbies de Angélica",
          style: TextStyle(
            color: Color(0xFF7A4E60),
            fontSize: 24,
            fontWeight: FontWeight.w600,
            letterSpacing: 1,
          ),
        ),
        centerTitle: true,
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              hobbyItem(Icons.book, "Leer libros de psicología"),
              hobbyItem(Icons.videogame_asset, "Jugar en la naturaleza"),
              hobbyItem(Icons.music_note, "Escuchar música clásica"),
            ],
          ),
        ),
      ),
    );
  }

  Widget hobbyItem(IconData icono, String texto) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 14),
      child: Row(
        mainAxisSize: MainAxisSize.min,
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Container(
            padding: const EdgeInsets.all(10),
            decoration: BoxDecoration(
              color: const Color(0xFFFFC9D9),
              borderRadius: BorderRadius.circular(16),
            ),
            child: Icon(
              icono,
              size: 26,
              color: const Color(0xFF7A4E60),
            ),
          ),
          const SizedBox(width: 15),
          Text(
            texto,
            style: const TextStyle(
              fontSize: 18,
              color: Color(0xFF7A4E60),
              fontWeight: FontWeight.w500,
              letterSpacing: 0.5,
            ),
          ),
        ],
      ),
    );
  }
}
