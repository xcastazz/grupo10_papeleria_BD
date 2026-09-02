package model.domain;

public abstract class Producto implements Vendible{
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidadStock;

    public Producto(String codigo, String nombre, double precio, int cantidadStock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    public abstract void vender(int cantidad);

    public abstract double calcularPrecioFinal();

    public String getCodigo() {return codigo;}
    public String getNombre() {return nombre;}
    public double getPrecio() {return precio;}
    public int getStock() {return cantidadStock;}

}
