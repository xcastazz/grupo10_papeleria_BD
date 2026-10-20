package model.domain;

import structures.Cola;

public class PedidosPendientes {
    private String descripcion;
    private Cola<Pedido> colaPedidos;

    public PedidosPendientes(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía");
        }
        this.descripcion = descripcion;
        this.colaPedidos = new Cola<>();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Cola<Pedido> getFila() {
        return colaPedidos;
    }
}