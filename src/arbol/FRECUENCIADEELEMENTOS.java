/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbol;

/**
 *
 * @author taddy
 */
public class FRECUENCIADEELEMENTOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        arbol lista = new arbol();
        
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);
        lista.insertar(1);
        System.out.println("Recorrido Inorder del arbol: ");
        lista.mostrarEnterosConFrecuencia();
    }
    
}
