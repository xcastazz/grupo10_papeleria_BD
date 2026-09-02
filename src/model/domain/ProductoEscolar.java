package model.domain;

public class ProductoEscolar extends Producto {

    private String nivelEscolar;

    public ProductoEscolar(String codigo, String nombre, double precio, int cantidadStock, String nivelEscolar) {
        super(codigo, nombre, precio, cantidadStock);
        this.nivelEscolar = nivelEscolar;
    }
    public double calcularPrecioFinal(){
        double precioFinal =1;
        return precioFinal;
    }
    public void vender(int cantidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
    public String getCategoria() {return nivelEscolar;}
}
