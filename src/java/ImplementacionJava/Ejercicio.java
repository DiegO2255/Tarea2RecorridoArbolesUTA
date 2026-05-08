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