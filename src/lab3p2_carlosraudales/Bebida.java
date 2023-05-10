/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3p2_carlosraudales;

/**
 *
 * @author craudales7
 */
 class Bebida extends Producto{
    private int tamano;
    
    public Bebida(String nombre, double precio, int tamano) {
        super(nombre, precio);
        this.tamano = tamano;
    }
    
    public int getTamano() {
        return tamano;
    }
    
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    @Override
    public String toString() {
        return "Bebida: " + nombre + " - Precio: " + precio + " - Tamaño: " + tamano + "mL";
    }
}
