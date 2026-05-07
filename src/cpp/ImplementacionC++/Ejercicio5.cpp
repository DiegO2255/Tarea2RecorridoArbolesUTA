#include <iostream>
#include <string>
#include <queue>

using namespace std;

struct Modulo {
    string nombre;
    Modulo *izq, *der;
    Modulo(string n) : nombre(n), izq(nullptr), der(nullptr) {}
};

// Funciones de recorrido (Criterios de rúbrica)
void mostrarMenu(Modulo* m) { // Preorden
    if (m) {
        cout << " -> " << m->nombre << endl;
        mostrarMenu(m->izq);
        mostrarMenu(m->der);
    }
}

void procesarInternos(Modulo* m) { // Postorden
    if (m) {
        procesarInternos(m->izq);
        procesarInternos(m->der);
        cout << "[OK] Modulo '" << m->nombre << "' procesado." << endl;
    }
}

void mostrarNiveles(Modulo* raiz) { // BFS (Uso de cola)
    if (!raiz) return;
    queue<Modulo*> q;
    q.push(raiz);
    while (!q.empty()) {
        Modulo* actual = q.front();
        q.pop();
        cout << "[" << actual->nombre << "] ";
        if (actual->izq) q.push(actual->izq);
        if (actual->der) q.push(actual->der);
    }
    cout << endl;
}

int main() {
    // Construcción del árbol del proyecto
    Modulo* raiz = new Modulo("Sistema Web");
    raiz->izq = new Modulo("Usuarios");
    raiz->der = new Modulo("Inventario");
    raiz->izq->izq = new Modulo("Registrar");
    raiz->izq->der = new Modulo("Buscar");
    raiz->der->izq = new Modulo("Productos");
    raiz->der->der = new Modulo("Reportes");

    int op;
    do {
        cout << "\n--- MENU PROYECTO FINAL (ARBOLES) ---" << endl;
        cout << "1. Ver estructura del menu (Preorden)" << endl;
        cout << "2. Ejecutar procesamiento de modulos (Postorden)" << endl;
        cout << "3. Ver mapa del sitio por niveles (BFS)" << endl;
        cout << "0. Salir" << endl;
        cout << "Opcion: "; cin >> op;

        switch(op) {
            case 1: cout << "\nESTRUCTURA HIERARQUICA:\n"; mostrarMenu(raiz); break;
            case 2: cout << "\nLOG DE PROCESAMIENTO:\n"; procesarInternos(raiz); break;
            case 3: cout << "\nVISTA POR NIVELES:\n"; mostrarNiveles(raiz); break;
        }
    } while (op != 0);

    return 0;
}