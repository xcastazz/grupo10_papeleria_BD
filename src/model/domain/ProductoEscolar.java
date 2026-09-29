package model.domain;

public class ProductoEscolar extends Producto {

    private String nivelEscolar;

    public ProductoEscolar(String codigo, String nombre, double precio, int cantidadStock, String nivelEscolar) {
        super(codigo, nombre, precio, cantidadStock);
        this.nivelEscolar = nivelEscolar;
    }

    @Override 
    public double calcularPrecioFinal(){
        double precio = super.getPrecio();
        
        

        if (nivelEscolar.equals("primaria")) {
            precio = precio*0.90;
            return precio;
        }
        return precio;
    }

    @Override 
    public void vender(int cantidad) {
        
        int cantidadStock = getStock();
        if (cantidad >= 0) {
            System.out.println(cantidad+" encargados");
            if ((cantidadStock - cantidad) > 0) {
                double precio = calcularPrecioFinal() * cantidad;
                super.setStock((cantidadStock - cantidad));
            } else {
                throw new IllegalStateException("Stock insuficiente");
            }
        }

    }
 
    public String getNivelEscolar() {return nivelEscolar;}
}
