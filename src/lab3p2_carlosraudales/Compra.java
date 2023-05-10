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
public class Compra {
    private ArrayList<Producto> productos;
    private double total;
    
    public Compra() {
        productos = new ArrayList<>();
        total = 0.0;
    }
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        total += producto.getPrecio();
    }
    
    public void eliminarProducto(int indice) {
        Producto productoEliminado = this.productos.remove(indice);
        this.total -= productoEliminado.getPrecio();
    }
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public double getTotal() {
        return total;
    }
}
