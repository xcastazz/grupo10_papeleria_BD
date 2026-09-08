package model.domain;


import java.util.ArrayList;
import java.util.List;


public class Venta {
    private List<ItemVenta> itemsEnVenta;

    public Venta(){
        this.itemsEnVenta = new ArrayList<>();
    }

    public void agregarItem(ItemVenta item) {
        this.itemsEnVenta.add(item);
    }
    public List<ItemVenta> getItems() {
        return itemsEnVenta;
    }

}
