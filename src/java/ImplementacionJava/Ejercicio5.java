import java.util.*;

public class Ejercicio5 {
    static class Modulo {
        String nombre;
        Modulo izq, der;
        Modulo(String n) { this.nombre = n; }
    }

    public static void preorden(Modulo m) {
        if (m != null) {
            System.out.println("Modulo: " + m.nombre);
            preorden(m.izq);
            preorden(m.der);
        }
    }

    public static void postorden(Modulo m) {
        if (m != null) {
            postorden(m.izq);
            postorden(m.der);
            System.out.println("Finalizando sub-modulo: " + m.nombre);
        }
    }

    public static void bfs(Modulo raiz) {
        if (raiz == null) return;
        Queue<Modulo> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Modulo actual = cola.poll();
            System.out.print("[" + actual.nombre + "] ");
            if (actual.izq != null) cola.add(actual.izq);
            if (actual.der != null) cola.add(actual.der);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Armado del árbol
        Modulo sistema = new Modulo("Sistema Web");
        sistema.izq = new Modulo("Usuarios");
        sistema.der = new Modulo("Inventario");
        sistema.izq.izq = new Modulo("Registrar");
        sistema.izq.der = new Modulo("Buscar");
        sistema.der.izq = new Modulo("Productos");
        sistema.der.der = new Modulo("Reportes");

        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n--- MENU SISTEMA WEB ---");
            System.out.println("1. Mostrar Jerarquia (Preorden)");
            System.out.println("2. Procesar Modulos (Postorden)");
            System.out.println("3. Mapa de Niveles (BFS)");
            System.out.println("0. Salir");
            System.out.print("Elija una opcion: ");
            op = sc.nextInt();

            switch (op) {
                case 1 -> preorden(sistema);
                case 2 -> postorden(sistema);
                case 3 -> bfs(sistema);
            }
        } while (op != 0);
    }
}