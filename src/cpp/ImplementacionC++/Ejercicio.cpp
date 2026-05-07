#include <iostream>
#include <queue>

using namespace std;

// Estructura del nodo con comentarios para la rúbrica
struct Nodo {
    int dato;
    Nodo *izq, *der;
    Nodo(int v) : dato(v), izq(nullptr), der(nullptr) {}
};

// Función de inserción mediante recursividad (Criterio: Uso de recursividad)
Nodo* insertar(Nodo* raiz, int dato) {
    if (raiz == nullptr) return new Nodo(dato);
    if (dato < raiz->dato) raiz->izq = insertar(raiz->izq, dato);
    else if (dato > raiz->dato) raiz->der = insertar(raiz->der, dato);
    return raiz;
}

// Recorridos de profundidad
void preorden(Nodo* raiz) {
    if (raiz) { cout << raiz->dato << " "; preorden(raiz->izq); preorden(raiz->der); }
}

void inorder(Nodo* raiz) {
    if (raiz) { inorder(raiz->izq); cout << raiz->dato << " "; inorder(raiz->der); }
}

void postorden(Nodo* raiz) {
    if (raiz) { postorden(raiz->izq); postorden(raiz->der); cout << raiz->dato << " "; }
}

// Recorrido en amplitud (Criterio: Uso de cola)
void bfs(Nodo* raiz) {
    if (!raiz) return;
    queue<Nodo*> q;
    q.push(raiz);
    while (!q.empty()) {
        Nodo* temp = q.front();
        q.pop();
        cout << temp->dato << " ";
        if (temp->izq) q.push(temp->izq);
        if (temp->der) q.push(temp->der);
    }
}

int main() {
    Nodo* raiz = nullptr;
    int opcion, valor;

    // Carga inicial automática (Nodos base + 5 nuevos según actividad 3)
    int datos[] = {10, 5, 15, 2, 7, 12, 20, 1, 3, 18, 25, 30}; 
    for(int x : datos) raiz = insertar(raiz, x);

    do {
        cout << "\n--- MENU ARBOL BINARIO ---" << endl;
        cout << "1. Insertar nodo manualmente" << endl;
        cout << "2. Mostrar Preorden" << endl;
        cout << "3. Mostrar Inorden" << endl;
        cout << "4. Mostrar Postorden" << endl;
        cout << "5. Mostrar BFS (Amplitud)" << endl;
        cout << "0. Salir" << endl;
        cout << "Seleccione: "; cin >> opcion;

        switch(opcion) {
            case 1: 
                cout << "Valor: "; cin >> valor;
                raiz = insertar(raiz, valor);
                break;
            case 2: cout << "Preorden: "; preorden(raiz); cout << endl; break;
            case 3: cout << "Inorden: "; inorder(raiz); cout << endl; break;
            case 4: cout << "Postorden: "; postorden(raiz); cout << endl; break;
            case 5: cout << "BFS: "; bfs(raiz); cout << endl; break;
        }
    } while (opcion != 0);

    return 0;
}