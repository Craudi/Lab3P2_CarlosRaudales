/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3p2_carlosraudales;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author craudales7
 */
public class Lab3P2_CarlosRaudales {
static ArrayList<Producto> productos = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
       List<Compra> comprasRealizadas = new ArrayList<>();
        Compra compra = new Compra();
        
        boolean valk = true;
        
        while(valk == true){
            System.out.println("----------MENU---------");
            System.out.println("1. Agregar comida");
            System.out.println("2. Agregar bebida");
            System.out.println("3. Modificar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar producto");
            System.out.println("6. Generar compra");
            System.out.println("7. Registro compra");
            System.out.println("8. Salir");
            System.out.println("------------------------");
            System.out.println("Ingrese una opcion: ");
            int op = lea.nextInt();
            
            switch(op){
                case 1:{
                    // Agregar comida
                System.out.println("Agregar Comida");
                System.out.print("Nombre: ");
                String nombreComida = lea.next();
                System.out.print("Precio: ");
                double precioComida = lea.nextDouble();
                System.out.print("¿Está vencido? (s/n): ");
                boolean vencido = lea.next().equalsIgnoreCase("s");
                Comida comida = new Comida(nombreComida, precioComida, vencido);
                productos.add(comida);
                }
                break;
                
                case 2:{
                    // Agregar bebida
                System.out.println("Agregar Bebida");
                System.out.print("Nombre: ");
                String nombreBebida = lea.next();
                System.out.print("Precio: ");
                double precioBebida = lea.nextDouble();
                System.out.print("Tamaño en mL: ");
                int tamano = lea.nextInt();
                Bebida bebida = new Bebida(nombreBebida, precioBebida, tamano);
                productos.add(bebida);
                }
                break;
                
                case 3:{
                    System.out.println("Seleccione el producto a modificar:");
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println((i+1) + ". " + productos.get(i).getNombre());
                }
                int seleccion = lea.nextInt() - 1;
                Producto producto = productos.get(seleccion);
                if (producto instanceof Comida) {
                    Comida comida = (Comida) producto;
                    System.out.println("Producto a modificar: " + comida.getNombre() + " (" + comida.getClass().getSimpleName() + ")");
                    System.out.println("Ingrese el nuevo nombre de la comida:");
                    String nuevoNombre = lea.next();
                    System.out.println("Ingrese el nuevo precio de la comida:");
                    double nuevoPrecio = lea.nextDouble();
                    System.out.println("Ingrese el nuevo estado de vencimiento de la comida (true si está vencido, false si no):");
                    boolean nuevoVencido = lea.nextBoolean();
                    comida.setNombre(nuevoNombre);
                    comida.setPrecio(nuevoPrecio);
                    comida.setVencido(nuevoVencido);
                    System.out.println("Comida modificada correctamente.");
                }else if (producto instanceof Bebida) {
                    Bebida bebida = (Bebida) producto;
                    System.out.println("Producto a modificar: " + bebida.getNombre() + " (" + bebida.getClass().getSimpleName() + ")");
                    System.out.println("Ingrese el nuevo nombre de la bebida:");
                    String nuevoNombre = lea.next();
                    System.out.println("Ingrese el nuevo precio de la bebida:");
                    double nuevoPrecio = lea.nextDouble();
                    System.out.println("Ingrese el nuevo tamaño en mL de la bebida:");
                    int nuevoTamano = lea.nextInt();
                    bebida.setNombre(nuevoNombre);
                    bebida.setPrecio(nuevoPrecio);
                    bebida.setTamano(nuevoTamano);
                }else{
                    System.out.println("El producto no se encuentra!!");
                }
                }
                break;
                
                case 4:{
                   eliminarProducto(lea); 
                }
                break;
                
                case 5:{
                    System.out.println("Lista de productos:");
                    for (int i = 0; i < productos.size(); i++) {
                    Producto producto = productos.get(i);
                    System.out.println((i + 1) + ". " + producto.toString());
        }
                }
                break;
                
                case 6:{
                  generarCompra(lea);  
                }
                break;
                
                case 7:{
                    
                
                }
                break;
                
                case 8:{
                    valk = false;
                    System.out.println("Saliendo...");
                }    
                    break;
                    
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
                    
            }// fin switch
        }// fin while
    }
    
    public static void generarCompra( Scanner scanner) {
        
        double total = 0;
        boolean seguirComprando = true;
        do {
            System.out.println("Lista de productos:");
            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i+1) + ". " + productos.get(i));
            }
            System.out.println("Seleccione un producto:");
            int seleccion = scanner.nextInt();
            Producto seleccionado = productos.get(seleccion-1);
            productos.add(seleccionado);
            total += seleccionado.getPrecio();
            System.out.println("Producto agregado: " + seleccionado);
            System.out.println("Desea seguir comprando? (s/n):");
            seguirComprando = scanner.next().equalsIgnoreCase("s");
        } while (seguirComprando);
        System.out.println("Productos comprados:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
        System.out.println("Total de la compra: " + total);
    }
    
    private static void eliminarProducto(Scanner scanner) {
        System.out.println("Lista de Productos:");

        // Mostrar la lista de productos con su respectivo indice
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(i + ". " + productos.get(i));
        }

        System.out.print("Ingrese el numero del producto a eliminar: ");
        int indice = scanner.nextInt();

        if (indice < 0 || indice >= productos.size()) {
            System.out.println("Indice invalido. Intente de nuevo.");
        } else {
            productos.remove(indice);
            System.out.println("El producto se ha eliminado exitosamente.");
        }
    }
    
    
}
    

