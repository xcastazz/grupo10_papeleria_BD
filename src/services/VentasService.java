package services;

import model.domain.Producto;
import model.domain.Venta;
import structures.Pila;

public class VentasService {
    private Pila<Venta> queueVentas = new Pila<>();


    public void continuarVenta(Producto productoAVender,int cantidadAVender){
        Venta ventaActual = queueVentas.peek().getDato();
        ventaActual.encargarItem(productoAVender, cantidadAVender);
    }

    public void confirmarVenta(){
        if (sinOperacionesPorDeshacer() == false) {
            Venta ventaAConfirmnar = queueVentas.peek().getDato();
            ventaAConfirmnar.setConfirmada(true);
            System.out.println(" Venta Confirmada Correctamente \n Detalles de la Venta:");
            consultarUltimaOperacion();
        } else {
            System.out.println(" Ventas Ya confirmadas Previamente");
        }
    }

    public void realizarVenta(Producto productoAVender,int cantidadAVender){
        Venta nuevaVenta = new Venta();
        nuevaVenta.encargarItem(productoAVender, cantidadAVender);
        queueVentas.push(nuevaVenta);
    }

    public boolean rechazarVenta(){
        if (sinOperacionesPorDeshacer()) {
            System.out.println("Error Al Intentar Rechazar La Venta");
            return false; 
        }
        Venta ventaARevertir = queueVentas.peek().getDato();
        ventaARevertir.revertirVenta();
        queueVentas.pop();
        return true;
    }

    public Venta consultarUltimaOperacion(){
        if (queueVentas.isEmpty()) {
            System.out.println("Pila Vacía sin Operaciones");
            return null;
        } else {
        Venta dato = queueVentas.peek().getDato();
        System.out.println("||===    Datos de la ultima operacion Realizada    ===");
        String texto = dato.MostrarItemVenta();
        System.out.println(texto);
        return dato;
        }
    }

    public boolean sinOperacionesPorDeshacer(){
        if (queueVentas.isEmpty()) {
            System.out.println("Pila Vacia y sin Operaciones");
            return true;
        } else if (queueVentas.peek().getDato().getConfirmada() == false ) {
            System.out.println("Pila con ventas sin confirmar");
            return false;
        } else {
            System.out.println("Pila con ventas confirmadas ya");
            return true;
        }
    }

    public int registarVentas(){
        int numeroVentas = queueVentas.getSize();
        return numeroVentas;
    }

    public String listarOperaciones() {
    if (queueVentas.isEmpty()) {
        return "No hay operaciones por deshacer";
    }

    Pila<Venta> auxiliar = new Pila<>();
    StringBuilder sb = new StringBuilder();
    int contador = 0;

    while (!queueVentas.isEmpty()) {
        Venta v = queueVentas.peek().getDato();
        queueVentas.pop();
        sb.append(contador++).append(". ")
          .append(v.MostrarItemVenta())
          .append("\n");
        auxiliar.push(v);
    }

    while (!auxiliar.isEmpty()) {
        Venta v = auxiliar.peek().getDato();
        auxiliar.pop();
        queueVentas.push(v);
    }

    return sb.toString();
}


}
