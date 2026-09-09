package model.domain;

import java.time.LocalDate;

public class Pedido {

    private LocalDate fecha;
    private String estado;
    private Proveedor proveedor;
    
    public Pedido(Proveedor proveedor, String estado){
        this.proveedor = proveedor;
        this.fecha = LocalDate.now();
        this.estado = estado;
        System.out.println("Se creó pedido en la fecha "+ fecha+ "A nombre de "+ proveedor.getProveedorNombre() +
                            "\nCon numero de celular: "+ proveedor.getProveedorTelefono()+" con el estado"+ estado);
    }

}
