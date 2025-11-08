import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Navegación Inferior',
      theme: ThemeData(primarySwatch: Colors.pink),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _selectedIndex = 0;
  String _nombreUsuario = "Invitado";

  // Lista de páginas
  late final List<Widget> _pages = [
    const Center(child: Text('Inicio', style: TextStyle(fontSize: 24))),
    const Center(child: Text('Usuarios', style: TextStyle(fontSize: 24))),
    const Center(child: Text('Configuración', style: TextStyle(fontSize: 24))),
    _buildPerfilTab(),
  ];

  // Función para construir el tab Perfil (porque necesita usar el estado)
  Widget _buildPerfilTab() {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text('Nombre: $_nombreUsuario', style: const TextStyle(fontSize: 22)),
          const SizedBox(height: 20),
          ElevatedButton(
            onPressed: () async {
              final nombre = await Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => const EditarPerfilScreen()),
              );
              if (nombre != null && nombre.toString().isNotEmpty) {
                setState(() {
                  _nombreUsuario = nombre;
                });
              }
            },
            child: const Text('Editar perfil'),
          ),
        ],
      ),
    );
  }

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Ejemplo BottomNavigationBar')),
      body: _pages[_selectedIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _selectedIndex,
        onTap: _onItemTapped,
        selectedItemColor: Colors.pink,
        unselectedItemColor: Colors.grey,
        type: BottomNavigationBarType.fixed,
        items: const [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Inicio'),
          BottomNavigationBarItem(icon: Icon(Icons.people), label: 'Usuarios'),
          BottomNavigationBarItem(icon: Icon(Icons.settings), label: 'Config'),
          BottomNavigationBarItem(icon: Icon(Icons.person), label: 'Perfil'),
        ],
      ),
    );
  }
}

class EditarPerfilScreen extends StatefulWidget {
  const EditarPerfilScreen({super.key});

  @override
  State<EditarPerfilScreen> createState() => _EditarPerfilScreenState();
}

class _EditarPerfilScreenState extends State<EditarPerfilScreen> {
  final TextEditingController _controller = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Editar perfil')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _controller,
              decoration: const InputDecoration(labelText: 'Nombre'),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context, _controller.text);
              },
              child: const Text('Guardar'),
            ),
          ],
        ),
      ),
    );
  }
}
