package model.domain;

import java.time.LocalDate;

public class Pedido {

    private LocalDate fecha;
    private String estado;
    private Proveedor proveedor;
    
    public Pedido(String estado){
        this.fecha = LocalDate.now();
        this.estado = estado;
    }

}
