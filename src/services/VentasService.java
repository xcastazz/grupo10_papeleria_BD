package services;

import model.domain.Producto;
import model.domain.Venta;
import structures.Pila;

public class VentasService {
    private Pila<Venta> queueVentas = new Pila<>();

    public void realizarVenta(Producto productoAVender,int cantidadAVender){
        Venta ventaPrevia = queueVentas.peek().getDato();
        if (ventaPrevia != null) {
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
        if (sinOperacionesPorDeshacer()) {
            System.out.println("Pila Vacia");
        }
        Venta dato = queueVentas.peek().getDato();
        return dato;
    }

    private boolean sinOperacionesPorDeshacer(){
        if (queueVentas.isEmpty()) {
            System.out.println("Pila Vacia");
            return true;
        } else {
            System.out.println("Pila con elementos");
            return false;
        }
    }

    public int registarVentas(){
        int numeroVentas = queueVentas.getSize();
        return numeroVentas;
    }

}
