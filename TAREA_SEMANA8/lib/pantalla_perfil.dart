import 'package:flutter/material.dart';

class PantallaPerfil extends StatelessWidget {
  const PantallaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFFFF1F6),
      appBar: AppBar(
        backgroundColor: const Color(0xFFFFC9D9),
        elevation: 0,
        centerTitle: true,
        title: const Text(
          "Mi Perfil",
          style: TextStyle(
            color: Color(0xFF7A4E60),
            fontSize: 24,
            fontWeight: FontWeight.w600,
            letterSpacing: 1,
          ),
        ),
      ),
      body: Center(
        child: SingleChildScrollView(
          padding: const EdgeInsets.symmetric(horizontal: 28.0, vertical: 25),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              CircleAvatar(
                radius: 85,
                backgroundColor: const Color(0xFFFFC9D9),
                child: const CircleAvatar(
                  radius: 80,
                  backgroundImage: NetworkImage(
                    "https://i.imgur.com/EZF5SQZ.png",
                  ),
                ),
              ),
              const SizedBox(height: 25),
              const Text(
                "Perfil de Angelica Valeria",
                textAlign: TextAlign.center,
                style: TextStyle(
                  fontSize: 26,
                  fontWeight: FontWeight.w700,
                  color: Color(0xFF7A4E60),
                  letterSpacing: 1,
                ),
              ),
              const SizedBox(height: 16),
              const Text(
                "Apasionada por los libros, la naturaleza y la tecnología",
                textAlign: TextAlign.center,
                style: TextStyle(
                  fontSize: 16,
                  height: 1.5,
                  color: Color(0xFF8F5F73),
                ),
              ),
              const SizedBox(height: 35),
              Container(
                padding:
                const EdgeInsets.symmetric(vertical: 12, horizontal: 20),
                decoration: BoxDecoration(
                  color: const Color(0xFFFFC9D9),
                  borderRadius: BorderRadius.circular(18),
                  boxShadow: [
                    BoxShadow(
                      color: Colors.pinkAccent.withOpacity(0.2),
                      blurRadius: 8,
                      offset: const Offset(2, 4),
                    ),
                  ],
                ),
                child: Row(
                  mainAxisSize: MainAxisSize.min,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: const [
                    Icon(
                      Icons.email,
                      color: Color(0xFF7A4E60),
                    ),
                    SizedBox(width: 10),
                    Text(
                      "acastilloto@ulasalle.edu.pe",
                      style: TextStyle(
                        color: Color(0xFF7A4E60),
                        fontSize: 16,
                        fontWeight: FontWeight.w500,
                        letterSpacing: 0.5,
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
