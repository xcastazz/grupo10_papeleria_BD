package stock;

public class Producto {

    private String Nombre;
    private int Precio;
    private int StockID;

    public Producto(String name, int price, int stockID){
        this.Nombre = name;
        this.Precio = price;
        this.StockID = stockID;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////
    //getters para retornar valores
    public String getNombre(){
     return Nombre;
    }

    public int getPrecio(){
        return Precio;
    }

    public int getStockID(){
        return StockID;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////
    //setters para cambiar valores, solo precio porque nombre y stockID seran unicos por producto
    public void cambiarPrecio(int precio){
        this.Precio = precio;
    }

}
