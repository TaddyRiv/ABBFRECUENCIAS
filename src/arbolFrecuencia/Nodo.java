/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolFrecuencia;

/**
 *
 * @author taddy
 */
public class Nodo {
    public int frecuencia;
    public int elemento;
    public Nodo izq;
    public Nodo der;

    public Nodo(int frecuencia, int elemento) {
        this.frecuencia = frecuencia;
        this.elemento = elemento;
        this.izq = null;
        this.der = null;
    }
}
