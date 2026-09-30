package model.domain;

public class ItemVenta {
    private int cantidad;
    private Producto productoAVender;

    public ItemVenta(Producto productoAVender, int Cantidad){
        if (productoAVender != null) {
            this.productoAVender = productoAVender;  
        } else {
            throw new IllegalStateException("Producto no existe");
        }
        this.cantidad = Cantidad;
    }

    public void doItemVenta(){
        productoAVender.vender(cantidad);
        System.out.println(productoAVender.getNombre());
        System.out.println("Precio total de la venta; "+productoAVender.calcularPrecioFinal()*cantidad);
    }

}
