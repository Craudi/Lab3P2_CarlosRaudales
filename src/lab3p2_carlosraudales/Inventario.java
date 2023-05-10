/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3p2_carlosraudales;
import java.util.ArrayList;
/**
 *
 * @author craudales7
 */
public class Inventario {
    private ArrayList<Comida> comidas;
    private ArrayList<Bebida> bebidas;
    
    public Inventario() {
        // Inicializamos las listas vacías
        comidas = new ArrayList<Comida>();
        bebidas = new ArrayList<Bebida>();
    }
    
    // Método para agregar una nueva comida al inventario
    public void agregarComida(String nombre, double precio, boolean vencido) {
        Comida nuevaComida = new Comida(nombre, precio, vencido);
        comidas.add(nuevaComida);
    }
    
    // Método para agregar una nueva bebida al inventario
    public void agregarBebida(String nombre, double precio, int tamaño) {
        Bebida nuevaBebida = new Bebida(nombre, precio, tamaño);
        bebidas.add(nuevaBebida);
    }
    
    // Método para mostrar la lista completa de productos
    public void mostrarProductos() {
        System.out.println("Comidas:");
        for (Comida comida : comidas) {
            System.out.println(comida);
        }
        System.out.println("Bebidas:");
        for (Bebida bebida : bebidas) {
            System.out.println(bebida);
        }
    }
}
