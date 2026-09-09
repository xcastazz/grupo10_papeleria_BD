package model.domain;


import java.util.ArrayList;
import java.util.List;


public class Venta {
    private List<ItemVenta> itemsEnVenta;

    public Venta(){
        this.itemsEnVenta = new ArrayList<>();
    }
    
    public void encargarItem(Producto encargo, int cantidad){
        ItemVenta nuevaVenta = new ItemVenta(encargo, cantidad);
        System.out.println("Se registra un nuevo producto para la venta: "+encargo+" encargados: "+ cantidad);
        agregarItem(nuevaVenta);
        nuevaVenta.doItemVenta();
    }

    private void agregarItem(ItemVenta item) {
        this.itemsEnVenta.add(item);
    }
    public List<ItemVenta> getItems() {
        return itemsEnVenta;
    }

}
