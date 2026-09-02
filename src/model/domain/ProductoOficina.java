package model.domain;

public class ProductoOficina extends Producto {

    private String categoria;

    public ProductoOficina(String codigo, String nombre, double precio, int cantidadStock, String categoria) {
        super(codigo, nombre, precio, cantidadStock);
        this.categoria = categoria;
    }
    
    public double calcularPrecioFinal(){
        double precioFinal =1;
        return precioFinal;
    }
    public void vender(int cantidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}

}
