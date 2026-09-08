package model.domain;

public class ItemVenta {
    private int cantidad;
    private Producto productoAVender;

    public ItemVenta(Producto p_vA, int Qu){
        System.out.println(p_vA.getNombre());

        if (p_vA != null) {
            this.productoAVender = p_vA;  
        } else {
            throw new IllegalStateException("Producto no existe");
        }
        this.cantidad = Qu;
    }

    public void doItemVenta(){
        productoAVender.vender(cantidad);
    }

}
