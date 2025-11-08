import 'package:flutter/material.dart';

class PantallaInicio extends StatelessWidget {
  const PantallaInicio({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFFFF1F6),
      appBar: AppBar(
        backgroundColor: const Color(0xFFFFC9D9),
        elevation: 0,
        centerTitle: true,
        title: const Text(
          "Bienvenido al perfil de Angélica",
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
              const SizedBox(height: 30),
              const Text(
                "Mi espacio personal hecho con mucho cariño",
                textAlign: TextAlign.center,
                style: TextStyle(
                  fontSize: 22,
                  fontWeight: FontWeight.w500,
                  color: Color(0xFF7A4E60),
                  letterSpacing: 0.5,
                ),
              ),
              const SizedBox(height: 35),
              ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: const Color(0xFFFFC9D9),
                  foregroundColor: const Color(0xFF7A4E60),
                  padding: const EdgeInsets.symmetric(
                    horizontal: 30,
                    vertical: 15,
                  ),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(20),
                  ),
                  elevation: 2,
                ),
                onPressed: () {
                },
                child: const Text(
                  "Ver mi perfil",
                  style: TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.w600,
                    letterSpacing: 0.5,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
