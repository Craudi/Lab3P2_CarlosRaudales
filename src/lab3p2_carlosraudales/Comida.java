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
class Comida extends Producto {
      private boolean vencido;
    
    public Comida(String nombre, double precio, boolean vencido) {
        super(nombre, precio);
        this.vencido = vencido;
    }
    
    public boolean estaVencido() {
        return vencido;
    }
    
    public void setVencido(boolean vencido) {
        this.vencido = vencido;
    }
    
    @Override
    public String toString() {
        String estado = vencido ? "Vencido" : "No vencido";
        return "Comida: " + nombre + " - Precio: " + precio + " - Estado: " + estado;
    }
}
