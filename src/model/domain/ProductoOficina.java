package model.domain;

public class ProductoOficina extends Producto {

    private String categoria;

    public ProductoOficina(String codigo, String nombre, double precio, int cantidadStock, String categoria) {
        super(codigo, nombre, precio, cantidadStock);
        this.categoria = categoria;
    }
    
    @Override 
    public double calcularPrecioFinal(){
        double precio = (super.getPrecio() * 1.08);
        return precio;
    }
    
    @Override 
    public void vender(int cantidad) {
        int cantidadStock = getStock();
        if (cantidad > 0) {
            if (cantidad > cantidadStock) {
                super.setStock((cantidadStock - cantidad));
            } else {
                throw new IllegalStateException("Stock insuficiente");
            }
        }

    }

    
    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}

}
