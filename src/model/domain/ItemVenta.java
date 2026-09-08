package model.domain;

public class ItemVenta {
    private int cantidad;
    private Producto productoAVender;

    public ItemVenta(int Qu, Producto p_vA){
        this.cantidad = Qu;
        this.productoAVender = p_vA;    
    }


}
