# PROYECTO I

# INTEGRANTES (Grupo 7)

- EMANUEL FELICIANO OROZCO CIFUENTES <br> 7690-23-6103
- ANGEL AURELIO TZI CUCUL <br> 7690-23-3711
- ANGEL STEVE MOREJON MARTINEZ <br>  7690-23-21973

## DESCRIPCIÓN 

Este proyecto consiste en el desarrollo de una aplicación en Java que permite ingresar una expresión matemática en notación infija, validarla, transformarla y evaluarla mediante el uso de estructuras de datos como pilas y árboles binarios de expresión.

La aplicación es capaz de trabajar con operaciones básicas como suma, resta, multiplicación, división, potencia y raíz, además de soportar variables que son evaluadas mediante valores proporcionados por el usuario.

La aplicación Calculadora con Árbol de Expresión es un programa desarrollado en Java que permite al usuario ingresar expresiones matemáticas en notación infija para analizarlas, procesarlas y obtener su resultado.

El sistema implementa estructuras de datos, específicamente árboles binarios de expresión, para representar de forma jerárquica cada operación matemática. A partir de la expresión ingresada, el programa realiza una conversión a notación postfija, construye el árbol correspondiente y ejecuta distintos recorridos (inorden, preorden y postorden) para mostrar la estructura de la expresión.

## OBJETIVO

El objetivo principal del proyecto es aplicar conceptos fundamentales de:
- Implementar árboles binarios de expresión  
- Aplicar el uso de pilas para evaluación de expresiones  
- Convertir expresiones de notación infija a postfija  
- Evaluar expresiones matemáticas  
- Desarrollar una interfaz gráfica en Java  

## ESTRUCTURA

| Clase                | Función principal                          |
|---------------------|--------------------------------------------|
| Proyecto1           | Clase principal (ejecución del programa)   |
| Nodo                | Representa cada nodo del árbol             |
| Pila                | Implementación de pila genérica            |
| ArbolDeExpresiones  | Conversión y construcción del árbol        |
| Evaluador           | Evalúa la expresión postfija               |
| GraficaDeInterfaz   | Interfaz gráfica del sistema               |
| DibujoDeArbol       | Dibuja el árbol de forma gráfica           |

### Clase Poyecto1:

Se encarga de iniciar la aplicación y ejecutar la interfaz gráfica mediante `SwingUtilities`.
- Crear la interfaz gráfica (ventana)
- Gestionar los eventos del usuario
- Coordinar el flujo de ejecución del programa

![image alt](https://github.com/Aurongy/ProyectoI/blob/1fb0de21e731f3bfd275a3d4a559abec4d4b3560/src/image-1.png)

### Clase Nodo

Representa cada nodo del árbol de expresión.
- Un valor (operador o operando)
- Nodo izquierda: referencia al hijo izquierdo
- Nodo derecha: referencia al hijo derecho

### Clase Pila
Implementa una pila genérica utilizando `ArrayList`.
Se utiliza en:
- Conversión de expresiones (infijo a postfijo)
- Construcción del árbol
- Evaluación de la expresión

Sus operaciones principales son:
- Insertar (`push`)
- Eliminar (`pop`)
- Consultar el último elemento (`top`)
- Verificar si está vacía (`isEmpty`)

### Clase ArbolDeExpresiones

Se encarga de construir y recorrer el árbol de expresión.
Es una de las clases principales del sistema.

Se encarga de:
- Convertir la expresión de infija a postfija
- Construir el árbol de expresión
- Realizar recorridos del árbol (inorden, preorden y postorden)

Métodos principales:

- construirArbol(String expr) <br>
Construye el árbol a partir de la expresión en notación postfija.

- infijoAPostfijo(String expr) <br>
Convierte una expresión infija a postfija usando una pila.

- inorden(Nodo n, StringBuilder sb) <br>
Recorrido: izquierda → raíz → derecha

- preorden(Nodo n, StringBuilder sb) <br>
Recorrido: raíz → izquierda → derecha

- postorden(Nodo n, StringBuilder sb) <br>
Recorrido: izquierda → derecha → raíz

### Clase Evaluador
Se encarga de evaluar la expresión en formato postfijo.

Funciona mediante:
- Uso de una pila para almacenar valores
- Aplicación de operadores matemáticos
- Sustitución de variables por valores ingresados

Devuelve el resultado final de la expresión.

### Clase GraficaDeInterfaz
Es la interfaz gráfica del sistema.

Permite:
- Ingresar la expresión matemática
- Mostrar los resultados
- Interactuar con el usuario

También coordina el flujo general del programa al llamar a las demás clases.

### Clase `DibujoDeArbol`

Se encarga de representar gráficamente el árbol de expresión.

Características:
- Dibuja nodos como círculos
- Conecta los nodos con líneas
- Diferencia operadores y operandos mediante colores

![image alt](https://github.com/Aurongy/ProyectoI/blob/c9d93e4b8b740a568d20a378d870cd432462e987/src/image-4.png) 


### Clase Validador

Se encarga de verificar si la expresión ingresada es válida.

Método:

esValido(String expr)

Validaciones:

- Caracteres permitidos

- Paréntesis balanceados

- Formato correcto de la expresión

### Integración del sistema

Todas las clases trabajan en conjunto de la siguiente manera:

1. `Proyecto1` inicia la aplicación  
2. `GraficaDeInterfaz` recibe la entrada del usuario  
3. `ArbolDeExpresiones` procesa la expresión  
4. `Evaluador` calcula el resultado  
5. `DibujoDeArbol` muestra el árbol gráficamente 

## FUNCIONAMIENTO

Solo contenga caracteres permitidos

| Operador | Descripción        |
|----------|--------------------|
| +        | Suma               |
| -        | Resta              |
| *        | Multiplicación     |
| /        | División           |
| ^        | Potencia           |
| √        | Raíz cuadrada      |

### EJEMPLO:
### Expresión ingresada

a + (b * c) - (d / (e + √f)) ^ g

![image alt](https://github.com/Aurongy/ProyectoI/blob/dd390c8236ee9625e3bd584ff71e776279e0e1b4/src/image-7.png)

### 1. Identificación de variables

El sistema detecta las variables presentes en la expresión:

a, b, c, d, e, f, g

### 2. Asignación de valores (ejemplo)

- a = 2  
- b = 3  
- c = 4  
- d = 20  
- e = 5  
- f = 9  
- g = 2  

### 3. Conversión a postfijo

Expresión infija:

a + (b * c) - (d / (e + √f)) ^ g  

Expresión postfija:

a b c * + d e f √ + / g ^ -

### 4. Construcción del árbol

Se construye el árbol de expresión donde:

- Los operandos (a, b, c, d, e, f, g) son hojas  
- Los operadores (+, -, *, /, ^, √) son nodos internos  

### 5. Recorridos del árbol

- **Inorden:**  
a + b * c - d / e + √ f ^ g  

- **Preorden:**  
a * b c ^ / d + e √ f g  

- **Postorden:**  
a b c * + d e f √ + / g ^ -  

### 6. Evaluación paso a paso

1. √f = √9 = 3  
2. e + √f = 5 + 3 = 8  
3. d / (e + √f) = 20 / 8 = 2.5  
4. (d / (e + √f)) ^ g = 2.5² = 6.25  
5. b * c = 3 * 4 = 12  
6. a + (b * c) = 2 + 12 = 14  
7. Resultado final = 14 - 6.25 = **7.75**

### Resultado final

![image alt](https://github.com/Aurongy/ProyectoI/blob/2e7f6862ee272e15e775d4fd9c3623cbde7d4b59/src/image-6.png)

![image alt](https://github.com/Aurongy/ProyectoI/blob/715f841487b839164f984ed993f57f43b645d180/src/image-8.png)

### Resumen

- Postfijo: a b c * + d e f √ + / g ^ -  
- Resultado: 7.75

## REQUISITO

- Java JDK 8 o superior  
- Entorno de desarrollo (IDE) como:
  - NetBeans  
  - IntelliJ IDEA  
  - Eclipse  
- Sistema operativo:
  - Windows, Linux o macOS  

### Requisitos de Ejecución

- Tener Java instalado y configurado correctamente  
- Compilar el archivo `.java`  
- Ejecutar la clase principal `AppCompleta`  

### Dependencias

El proyecto utiliza únicamente librerías estándar de Java:

- `javax.swing` → interfaz gráfica  
- `java.awt` → diseño de la interfaz  
- `java.util` → estructuras de datos (Stack, List, Map, Set)  

### Conocimientos Requeridos

Para comprender o modificar el proyecto se recomienda conocer:

- Programación en Java  
- Estructuras de datos (árboles y pilas)  
- Expresiones matemáticas  
- Programación orientada a objetos

## CONCLUSIÓN

El desarrollo de este proyecto permitió aplicar de manera práctica conceptos fundamentales de programación, como el uso de estructuras de datos (pilas y árboles binarios) para el procesamiento de expresiones matemáticas.

A través de la implementación del árbol de expresiones, se logró representar de forma estructurada las operaciones matemáticas, facilitando su análisis y evaluación mediante recorridos como inorden, preorden y postorden. Asimismo, el uso de la notación postfija permitió simplificar el proceso de cálculo evitando ambigüedades en la prioridad de operadores.

La integración de una interfaz gráfica hizo posible una interacción más amigable con el usuario, permitiendo ingresar expresiones, visualizar resultados y observar el árbol de forma gráfica, lo cual mejora la comprensión del funcionamiento interno del sistema.
