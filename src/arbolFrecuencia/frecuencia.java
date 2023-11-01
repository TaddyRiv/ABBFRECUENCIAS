/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolFrecuencia;

/**
 *
 * @author taddy
 */
public class frecuencia {
    public class Arbol {
    public Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(int frecuencia, int elemento) {
        raiz = insertar(raiz, frecuencia, elemento);
    }

    private Nodo insertar(Nodo nodo, int frecuencia, int elemento) {
        if (nodo == null) {
            return new Nodo(frecuencia, elemento);
        }
        if (frecuencia < nodo.frecuencia || (frecuencia == nodo.frecuencia && elemento < nodo.elemento)) {
            nodo.izq = insertar(nodo.izq, frecuencia, elemento);
        } else {
            nodo.der = insertar(nodo.der, frecuencia, elemento);
        }
        return nodo;
    }

    // Resto de las funciones (preOrden, inOrden, posOrden, seEncuentra, cantidad, menor, etc.) pueden permanecer sin cambios.

    public void mostrarPorFrecuenciaAscendente() {
        System.out.println("Mostrar elementos por frecuencia de menor a mayor:");
        mostrarPorFrecuenciaAscendente(raiz);
    }

    private void mostrarPorFrecuenciaAscendente(Nodo nodo) {
        if (nodo != null) {
            mostrarPorFrecuenciaAscendente(nodo.izq);
            System.out.println("Elemento: " + nodo.elemento + ", Frecuencia: " + nodo.frecuencia);
            mostrarPorFrecuenciaAscendente(nodo.der);
        }
    }

    public void mostrarPorFrecuenciaDescendente() {
        System.out.println("Mostrar elementos por frecuencia de mayor a menor:");
        mostrarPorFrecuenciaDescendente(raiz);
    }

    private void mostrarPorFrecuenciaDescendente(Nodo nodo) {
        if (nodo != null) {
            mostrarPorFrecuenciaDescendente(nodo.der);
            System.out.println("Elemento: " + nodo.elemento + ", Frecuencia: " + nodo.frecuencia);
            mostrarPorFrecuenciaDescendente(nodo.izq);
        }
    }
}
    
}
