# Proyecto: Estructuras de Datos - Árboles Binarios

Este proyecto contiene la implementación de Árboles Binarios de Búsqueda (BST) y Árboles de Estructura Jerárquica, cumpliendo con los requerimientos de la actividad práctica de programación en Java y C++.

## Datos:
* **Nombre:** Diego Alexander Curillo Pilamunga
* **Curso:** 3ro "B"
* **Asignatura:** Estructura de Datos
* **Docente:** Ing. José Caiza, Mg

## Contenido del Repositorio
* `Ejercicio.java` / `Ejercicio.cpp`: Implementación principal del árbol de números con menú interactivo. Incluye inserción dinámica y los 4 recorridos (Preorden, Inorden, Postorden y BFS).
* `Ejercicio5.java` / `Ejercicio5.cpp`: Representación de un sistema web modular mediante árboles binarios.

## Guía de Ejecución

### Java
1. Compilar: `javac Ejercicio.java`
2. Ejecutar: `java Ejercicio`

### C++
1. Compilar: `g++ Ejercicio.cpp -o Ejercicio`
2. Ejecutar: `./Ejercicio`

---

## Explicación del Caso Real (Proyecto Final)
Para el sistema web propuesto en el Ejercicio 5, se aplicaron los siguientes criterios de recorrido:

1. **Mostrar el menú principal:** Se utiliza **Preorden**. Esto permite procesar la raíz primero (el nombre del módulo) y luego sus opciones hijas, reflejando cómo un usuario lee un menú de arriba hacia abajo.
2. **Procesar módulos internos primero:** Se utiliza **Postorden**. Es ideal para tareas de mantenimiento o carga de dependencias, donde los sub-módulos deben estar listos o cerrados antes de afectar al módulo padre.
3. **Mostrar módulos nivel por nivel:** Se utiliza **BFS (Amplitud)**. Permite visualizar la anchura del sistema, mostrando todos los módulos principales antes de profundizar en las herramientas de cada uno.

---

## Uso de IA
Se declara el uso de **IA** como herramienta de apoyo en las siguientes tareas:
* **Optimización de algoritmos:** Estructuración de la lógica de la cola (`Queue`) para el recorrido BFS.

*El código fue revisado, probado y validado manualmente por el estudiante para asegurar que cumple con la lógica de negocio solicitada.*

---
> **Nota:** Se agregaron 5 nodos adicionales al árbol base original (1, 3, 18, 22, 25) para cumplir con el punto 3 de la actividad sugerida.
