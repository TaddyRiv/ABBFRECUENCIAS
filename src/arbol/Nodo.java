/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author taddy
 */
public class Nodo {

    public Nodo izq;
    public int elem;
    public Nodo der;
    public int frecuencia;

    public Nodo(int x) {
        izq = der = null;
        this.elem = elem;
        frecuencia = 1;
    }

//    public boolean esHoja() {
//        return izq == null && der == null;
//    }
}
