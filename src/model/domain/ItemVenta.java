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

    public String mostrarAtributos() {
    StringBuilder sb = new StringBuilder();
    sb.append("   || ================ \n");
    sb.append("   || Nombre del Producto: ").append(productoAVender.getNombre()).append("\n");
    sb.append("   || Cantidad Del Producto: ").append(cantidad).append("\n");
    sb.append("   || Precio Total: ").append(productoAVender.calcularPrecioFinal())
      .append(" (").append(productoAVender.getPrecio()).append(" * ").append(cantidad).append(") \n");
    sb.append("   || ================ \n");
    return sb.toString();
}


    public void revertirStockItemVenta(boolean Flag){
        if (Flag) {
                        System.out.println("Revertida la venta de; "+productoAVender.calcularPrecioFinal()*cantidad
                                +"\n Para las unidades:"+cantidad+" Del producto: "+productoAVender.getNombre()
                                +" Codigo: "+productoAVender.getCodigo()
                                +"\nStock Actual vs Stock nuevo "+ productoAVender.getStock()+" / "+ (productoAVender.getStock() + cantidad));
            productoAVender.setStock(productoAVender.getStock() + cantidad);

        } else {
            System.out.println("No hay ventas para revertir");
        }
    }

}
