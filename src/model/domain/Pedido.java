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
        System.out.println("Se creó pedido en la fecha "+ fecha+ " A nombre de "+ proveedor.getProveedorNombre() +
                            "\nCon numero de celular: "+ proveedor.getProveedorTelefono()+" con el estado"+ estado);
    }
    
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
    public Proveedor getProveedor() {return proveedor;}
    public void setProveedor(Proveedor proveedor) {this.proveedor = proveedor;}

}
