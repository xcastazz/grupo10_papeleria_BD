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

    public void realizarVenta(Producto productoAVender,int cantidadAVender){
        if (queueVentas.peek() != null) {
            Venta ventaPrevia = queueVentas.peek().getDato();
            ventaPrevia.setConfirmada(true);
        }
        Venta nuevaVenta = new Venta();
        nuevaVenta.encargarItem(productoAVender, cantidadAVender);
        queueVentas.push(nuevaVenta);
    }

    public boolean rechazarVenta(){
        if (sinOperacionesPorDeshacer()) {
            System.out.println("Pila Vacia");
            return false; 
        }
        Venta ventaARevertir = queueVentas.peek().getDato();
        ventaARevertir.revertirVenta();
        queueVentas.pop();
        return true;
    }

    public Venta consultarUltimaOperacion(){
        Venta dato = queueVentas.peek().getDato();
        return dato;
    }

    public boolean sinOperacionesPorDeshacer(){
        if (queueVentas.isEmpty()) {
            System.out.println("Pila Vacia");
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

}
