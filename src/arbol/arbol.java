/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author taddy
 */
public class arbol {

    private Nodo raiz;
    private List<arbol> arboles;

    public arbol() {
        arboles = new ArrayList<>();
    }

    public void insertar(int elemento) {
        if (raiz == null) {
            raiz = new Nodo(elemento);
        } else {
            insertarRec(raiz, elemento);
        }
    }

    private Nodo insertarRec(Nodo nodo, int elemento) {
        if (nodo == null) {
            return new Nodo(elemento);
        }

        if (elemento < nodo.elem) {
            nodo.izq = insertarRec(nodo.izq, elemento);
        } else if (elemento > nodo.elem) {
            nodo.der = insertarRec(nodo.der, elemento);
        } else {
            nodo.frecuencia++;
        }

        return nodo;
    }

    public void frecuenciMayorMenor() {
        List<Nodo> nodos = new ArrayList<>();
        recorrerArbol(raiz, nodos);

        Collections.sort(nodos, new Comparator<Nodo>() {
            @Override
            public int compare(Nodo nodo1, Nodo nodo2) {
                return nodo2.frecuencia - nodo1.frecuencia;
            }
        });

        for (Nodo nodo : nodos) {
            System.out.println(nodo.elem + ": " + nodo.frecuencia);
        }
    }

    private void recorrerArbol(Nodo nodo, List<Nodo> nodos) {
        if (nodo != null) {
            recorrerArbol(nodo.izq, nodos);
            nodos.add(nodo);
            recorrerArbol(nodo.der, nodos);
        }
    }

    public void mostrarEnterosConFrecuencia() {
        TreeMap<Integer, Integer> enterosFrecuencias = new TreeMap<>();
        obtenerEnterosFrecuencias(raiz, enterosFrecuencias);

        for (Map.Entry<Integer, Integer> entry : enterosFrecuencias.entrySet()) {
            int entero = entry.getKey();
            int frecuencia = entry.getValue();
            System.out.println("Entero: " + entero + ", Frecuencia: " + frecuencia);
        }
    }

    private void obtenerEnterosFrecuencias(Nodo nodo, TreeMap<Integer, Integer> enterosFrecuencias) {
        if (nodo == null) {
            return;
        }

        obtenerEnterosFrecuencias(nodo.izq, enterosFrecuencias);

        enterosFrecuencias.put(nodo.elem, nodo.frecuencia);

        obtenerEnterosFrecuencias(nodo.der, enterosFrecuencias);
    }

    public void calcularFrecuencia() {
        Map<Integer, Integer> frecuencias = new HashMap<>();
        calcularFrecuenciaRec(raiz, frecuencias);
        frecuencias.forEach((elemento, frecuencia)
                -> System.out.println("Elemento: " + elemento + ", Frecuencia: " + frecuencia));
    }

    private void calcularFrecuenciaRec(Nodo nodo, Map<Integer, Integer> frecuencias) {
        if (nodo == null) {
            return;
        }
        frecuencias.put(nodo.elem, nodo.frecuencia);
        calcularFrecuenciaRec(nodo.izq, frecuencias);
        calcularFrecuenciaRec(nodo.der, frecuencias);
    }

    public void mostrarInOrdenAgrupadoPorLongitud() {
        System.out.println("Recorrido inOrden:");
        Map<Integer, List<Integer>> elementosPorLongitud = new TreeMap<>();
        inOrdenRec(raiz, elementosPorLongitud);
        elementosPorLongitud.forEach((longitud, elementos) -> {
            System.out.println("Longitud " + longitud + ":");
            for (Integer elem : elementos) {
                System.out.println("  " + elem);
            }
        });
    }

    private void inOrdenRec(Nodo nodo, Map<Integer, List<Integer>> elementosPorLongitud) {
        if (nodo == null) {
            return;
        }
        inOrdenRec(nodo.izq, elementosPorLongitud);
        List<Integer> elementos = elementosPorLongitud.getOrDefault(contarDigitos(nodo.elem), new ArrayList<>());
        elementos.add(nodo.elem);
        elementosPorLongitud.put(contarDigitos(nodo.elem), elementos);
        inOrdenRec(nodo.der, elementosPorLongitud);
    }

    private int contarDigitos(int num) {
        if (num == 0) {
            return 1; // El número 0 tiene un dígito
        }
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

}
