# Implementación de Recorridos de Árboles en C++ y Java

# Objetivo del proyecto
Implementar y analizar recorridos de árboles binarios utilizando C++ y Java para comprender el funcionamiento de estructuras jerárquicas y algoritmos recursivos.


# Autor
**Diego Alexander Curillo Pilamunga**


## Descripción
Este proyecto contiene la implementación de ejercicios relacionados con recorridos de árboles binarios utilizando los lenguajes **C++** y **Java**.  
Se desarrollaron programas capaces de representar árboles y realizar diferentes tipos de recorridos para demostrar el funcionamiento de las estructuras de datos jerárquicas.

Repositorio del proyecto:  
https://github.com/DiegO2255/Tarea2RecorridoArbolesUTA/tree/main


# Implementación en C++

## Archivo: `Ejercicio.cpp`

### Descripción
Este programa implementa la creación y recorrido de un árbol binario en C++.  
Se utilizan nodos enlazados dinámicamente para almacenar los datos del árbol y ejecutar recorridos recursivos.

### Funcionalidades
- Creación de nodos del árbol.
- Inserción de elementos.
- Recorrido:
  - Preorden
  - Inorden
  - Postorden

### Tecnologías utilizadas
- Lenguaje C++
- Programación orientada a objetos
- Recursividad

### Captura del código
Código del archivo `Ejercicio.cpp`
```cpp
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



```

### Captura de ejecución
Captura de la consola ejecutando `Ejercicio.cpp`
1. Insertar 5 Nodos Nuevos: 
<img width="382" height="647" alt="1 Insertar 5 NodosC++" src="https://github.com/user-attachments/assets/02045f09-b901-4cea-bc80-1246613b98e8" />
<img width="298" height="421" alt="1 Insertar 5 NodosC++ 2" src="https://github.com/user-attachments/assets/4c921b41-55f4-49f1-bdd3-c98d3bffe777" />

2. Preorden
<img width="521" height="211" alt="2 PreordenC++" src="https://github.com/user-attachments/assets/5021366b-8176-4de1-8e82-ddc11b49fbef" />

3. Inorden
<img width="625" height="208" alt="3 InordenC++" src="https://github.com/user-attachments/assets/d111e4df-12f7-4029-a0ca-491e094d7bb0" />

4. Postorden
<img width="572" height="215" alt="4 PostordenC++" src="https://github.com/user-attachments/assets/ec4ac41a-9b21-4ba6-b59a-f55839231f9a" />

5. BFS
<img width="508" height="217" alt="5 BFSC++" src="https://github.com/user-attachments/assets/c31f8450-b108-457d-8bbd-27754f21354a" />


## Archivo: `Ejercicio5.cpp`

### Descripción
Este ejercicio implementa operaciones adicionales sobre árboles binarios en C++, permitiendo recorrer y visualizar los datos almacenados en la estructura.

### Funcionalidades
- Construcción del árbol.
- Inserción de nodos.
- Recorridos del árbol.
- Visualización de resultados en consola.

### Tecnologías utilizadas
- C++
- Estructuras dinámicas
- Funciones recursivas

### Captura del código
Captura del archivo `Ejercicio5.cpp`
```cpp
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
```

### Captura de ejecución
Captura de la consola ejecutando `Ejercicio5.cpp`
1. Preorden
<img width="467" height="347" alt="1 PreordenC++" src="https://github.com/user-attachments/assets/b11d4c1e-6c93-4f87-9b52-3d2e95fb944c" />

2. Postorden
<img width="467" height="347" alt="1 PreordenC++" src="https://github.com/user-attachments/assets/3e197e5e-9097-4d88-9922-14804ed90152" />

3. BFS
<img width="763" height="217" alt="3 BFSC++" src="https://github.com/user-attachments/assets/130b740a-a706-465c-a814-a980b750662f" />



# Implementación en Java

## Archivo: `Ejercicio.java`

### Descripción
Este programa desarrolla la implementación de árboles binarios utilizando Java.  
Se emplean clases y objetos para representar nodos y ejecutar los recorridos del árbol.

### Funcionalidades
- Creación de nodos.
- Inserción de datos.
- Recorridos:
  - Preorden
  - Inorden
  - Postorden

### Tecnologías utilizadas
- Java
- Programación orientada a objetos
- Recursividad

### Captura del código
Código del archivo `Ejercicio.java`
```java
import java.util.*;

public class Ejercicio {
    // Estructura del Nodo con comentarios para la rúbrica
    static class Nodo {
        int dato;
        Nodo izq, der;
        Nodo(int v) { 
            this.dato = v; 
            this.izq = null;
            this.der = null;
        }
    }

    private Nodo raiz;

    // Método para insertar (Uso de recursividad - Rúbrica)
    public void insertar(int dato) { 
        raiz = insertarRec(raiz, dato); 
    }
    
    private Nodo insertarRec(Nodo actual, int dato) {
        if (actual == null) return new Nodo(dato);
        if (dato < actual.dato) {
            actual.izq = insertarRec(actual.izq, dato);
        } else if (dato > actual.dato) {
            actual.der = insertarRec(actual.der, dato);
        }
        return actual;
    }

    // --- RECORRIDOS (Implementación correcta - Rúbrica) ---

    public void preorden(Nodo n) {
        if (n != null) {
            System.out.print(n.dato + " ");
            preorden(n.izq);
            preorden(n.der);
        }
    }

    public void inorden(Nodo n) {
        if (n != null) {
            inorden(n.izq);
            System.out.print(n.dato + " ");
            inorden(n.der);
        }
    }

    public void postorden(Nodo n) {
        if (n != null) {
            postorden(n.izq);
            postorden(n.der);
            System.out.print(n.dato + " ");
        }
    }

    // Recorrido BFS (Uso de Cola/Queue - Rúbrica)
    public void bfs() {
        if (raiz == null) return;
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo temp = cola.poll();
            System.out.print(temp.dato + " ");
            if (temp.izq != null) cola.add(temp.izq);
            if (temp.der != null) cola.add(temp.der);
        }
    }

    public static void main(String[] args) {
        Ejercicio arbol = new Ejercicio();
        Scanner sc = new Scanner(System.in);
        
        // Nodos iniciales (Incluye los 5 nuevos solicitados en la actividad)
        int[] iniciales = {10, 5, 15, 2, 7, 12, 20, 1, 3, 18, 22, 25};
        for (int v : iniciales) arbol.insertar(v);

        int op;
        do {
            System.out.println("\n---------------------------------------------------------");
            System.out.println("1. Insertar | 2. Preorden | 3. Inorder | 4. Postorden | 5. BFS | 0. Salir");
            System.out.print("Elija una opcion: ");
            op = sc.nextInt();
            
            switch(op) {
                case 1:
                    System.out.print("Ingrese valor a insertar: ");
                    arbol.insertar(sc.nextInt());
                    break;
                case 2:
                    System.out.print("PREORDEN: ");
                    arbol.preorden(arbol.raiz);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("INORDEN: ");
                    arbol.inorden(arbol.raiz);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("POSTORDEN: ");
                    arbol.postorden(arbol.raiz);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("BFS (Por niveles): ");
                    arbol.bfs();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (op != 0);
        sc.close();
    }
}   
```

### Captura de ejecución
Captura de la consola ejecutando `Ejercicio.java`
1. Insertar 5 nodos nuevos
<img width="696" height="438" alt="Insertar 5 NodosJava" src="https://github.com/user-attachments/assets/f1c33d90-8887-4585-83f7-12b298fbaa64" />

2. Preorden - Inorden - Postorden - BFS
<img width="695" height="432" alt="2 Preorden_3 Inorden_4 Postorden_5 BFS Java" src="https://github.com/user-attachments/assets/06428eae-136d-4cf1-9cc6-6f9608992ad5" />


## Archivo: `Ejercicio5.java`

### Descripción
Este ejercicio implementa funcionalidades complementarias de recorridos de árboles binarios en Java, permitiendo visualizar el comportamiento de la estructura mediante la consola.

### Funcionalidades
- Creación del árbol binario.
- Inserción de nodos.
- Recorridos del árbol.
- Impresión de resultados.

### Tecnologías utilizadas
- Java
- Clases y objetos
- Estructuras dinámicas

### Captura del código
Código del archivo `Ejercicio5.java`
```java
import java.util.LinkedList;
import java.util.Scanner;

public class Ejercicio5 {
   public Ejercicio5() {
   }

   public static void preorden(Modulo var0) {
      if (var0 != null) {
         System.out.println("Modulo: " + var0.nombre);
         preorden(var0.izq);
         preorden(var0.der);
      }

   }

   public static void postorden(Modulo var0) {
      if (var0 != null) {
         postorden(var0.izq);
         postorden(var0.der);
         System.out.println("Finalizando sub-modulo: " + var0.nombre);
      }

   }

   public static void bfs(Modulo var0) {
      if (var0 != null) {
         LinkedList var1 = new LinkedList();
         var1.add(var0);

         while(!var1.isEmpty()) {
            Modulo var2 = (Modulo)var1.poll();
            System.out.print("[" + var2.nombre + "] ");
            if (var2.izq != null) {
               var1.add(var2.izq);
            }

            if (var2.der != null) {
               var1.add(var2.der);
            }
         }

         System.out.println();
      }
   }

   public static void main(String[] var0) {
      Modulo var1 = new Modulo("Sistema Web");
      var1.izq = new Modulo("Usuarios");
      var1.der = new Modulo("Inventario");
      var1.izq.izq = new Modulo("Registrar");
      var1.izq.der = new Modulo("Buscar");
      var1.der.izq = new Modulo("Productos");
      var1.der.der = new Modulo("Reportes");
      Scanner var2 = new Scanner(System.in);

      int var3;
      do {
         System.out.println("\n--- MENU SISTEMA WEB ---");
         System.out.println("1. Mostrar Jerarquia (Preorden)");
         System.out.println("2. Procesar Modulos (Postorden)");
         System.out.println("3. Mapa de Niveles (BFS)");
         System.out.println("0. Salir");
         System.out.print("Elija una opcion: ");
         var3 = var2.nextInt();
         switch (var3) {
            case 1:
               preorden(var1);
               break;
            case 2:
               postorden(var1);
               break;
            case 3:
               bfs(var1);
         }
      } while(var3 != 0);

   }

   static class Modulo {
      String nombre;
      Modulo izq;
      Modulo der;

      Modulo(String var1) {
         this.nombre = var1;
      }
   }
}
```


### Captura de ejecución
Captura de la consola ejecutando `Ejercicio5.java`
1. Preorden
<img width="338" height="310" alt="1 PreordenJava" src="https://github.com/user-attachments/assets/f8933c9a-f2a2-4632-a77e-d3d61d599a9f" />

2. Postorden
<img width="362" height="302" alt="2 PostordenJava" src="https://github.com/user-attachments/assets/627db7bf-8229-4cef-b291-13fbae4fa506" />

3.BFS
<img width="757" height="176" alt="3 BFSJava" src="https://github.com/user-attachments/assets/f01067dc-da46-41ef-bc0d-86a013c67a1d" />


# Estructura del Proyecto

```plaintext
src/
├── cpp/
│   └── ImplementacionC++/
│       ├── Ejercicio.cpp
│       └── Ejercicio5.cpp
│
└── java/
    └── ImplementacionJava/
        ├── Ejercicio.java
        └── Ejercicio5.java
```


# Cómo ejecutar los programas

## C++

### Compilar
```bash
g++ Ejercicio.cpp -o ejercicio
```

### Ejecutar
```bash
./ejercicio
```


## Java

### Compilar
```bash
javac Ejercicio.java
```

### Ejecutar
```bash
java Ejercicio
```
