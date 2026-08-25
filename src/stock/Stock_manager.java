package stock;

import java.util.ArrayList;
import util.mth;


public class Stock_manager {
    private ArrayList<Object[]> matriz;
    private mth Math;
    private boolean debug = true; //Poner en true para hacer pruebas

    public Stock_manager(mth Mathe){ //Mathe son las matematicas con las que se crea el objeto desde App.java
        matriz = new ArrayList<>();
        this.Math = Mathe;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //Metodos referentes al stock (osea el arraylist con el objeto Producot en matriz[0] y el stock en matriz[1])
   

    //metodo para registrar 
    public void registrarProducto(String name, int precio, int StockID, int stockQU){
        Producto Nuevo = new Producto(name,precio,StockID);
        Object[] fila = new  Object[]{Nuevo,stockQU};
        matriz.add(fila);

        //Solo para debug, esto imprime para ver lo que registra en pruebas
        if (debug){ 
        System.out.println("Producto registrado con exito. con los siguientes \n parametros: \n Nombre: "
                            +Nuevo.getNombre()+"\n Precio: "+Nuevo.getPrecio()+
                            "\n Stock ID: "+Nuevo.getStockID()+
                            "\n con stock de: "+stockQU);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////
    // metodos para buscar sea el producto en el arreglo o el stock del nombre del producto
    public Producto buscarProducto(String nombre) {
        for (Object[] fila : matriz) {
            Producto p = (Producto) fila[0];
            if (p.getNombre().equals(nombre)) {
                return p;
            }
        }
        System.out.println("Producto no encontrado en el stock");
        return null;
    }
    public int buscarStock(String nombre) {
        for (Object[] fila : matriz) {
            Producto p = (Producto) fila[0];
            if (p.getNombre().equals(nombre)) {
                return (int) fila[1]; //retorna la fila 1 de la matriz que es donde esta el stock del producto buscado
            }
        }
        System.out.println("producto no encontrado");
        return -1;
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// metodo de setters o cambios dentro del array (Cambiar stock, actualizar el precio con el setter dentro de produto)
/// (Realizar venta y actualizacion de stock usando Glamp para evitar Stock Negativo)
    public void actualizarPrecio(String nombre, int nuevoP){
        Producto p = buscarProducto(nombre);
        if (p != null) {
            p.cambiarPrecio(nuevoP);
        } else {
            System.out.println("producto no encontrado en el stock");
        }
    }

    public void actualizarStock(String nombre, int nuevoStock){
        Producto p = buscarProducto(nombre);
        int stock = buscarStock(nombre);
        if (p != null) {
            stock = nuevoStock;
        } else {
            System.out.println("producto no encontrado en el stock");
        }
    }

    public void ventaYStock(String nombre, int cantidad){
        Producto p = buscarProducto(nombre);
        int stock = buscarStock(nombre);
        if (p != null) {
            stock = Math.glamp(stock,cantidad);
            actualizarStock(nombre, stock);
        } else {
            System.out.println("producto no encontrado en el stock");
        }
    }


}
