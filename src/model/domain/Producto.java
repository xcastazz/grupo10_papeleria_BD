package model.domain;

public abstract class Producto implements Vendible{
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidadStock;

    public Producto(String codigo, String nombre, double precio, int cantidadStock) {
        this.codigo = codigo;
        this.nombre = nombre;
        
        if (precio > 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("Precio no vàlido");
        }

        if (cantidadStock >= 0) {
            this.cantidadStock = cantidadStock;        
        } else {            
            throw new IllegalArgumentException("Stock no valido");
        }

    }

    @Override 
    public abstract void vender(int cantidad);

    public String getCodigo() {return codigo;}
    public String getNombre() {return nombre;}
    public double getPrecio() {return precio;}
    public int getStock() {return cantidadStock;}

    public void setStock(int stockActual){this.cantidadStock = stockActual;}

}
