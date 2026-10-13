package model.domain;

import structures.ListaSimple;


public class Venta {
    private Boolean confirmada;
    private ListaSimple<ItemVenta> itemsEnVenta;

    public Venta(){
        this.itemsEnVenta = new ListaSimple<>();
        this.confirmada = false;
    }
    
    public void encargarItem(Producto encargo, int cantidad){
        ItemVenta nuevaVenta = new ItemVenta(encargo, cantidad);
        System.out.println("Se registra un nuevo producto para la venta: "+encargo+" encargados: "+ cantidad);
        agregarItem(nuevaVenta);
        nuevaVenta.doItemVenta();
    }

    private void agregarItem(ItemVenta item) {
        itemsEnVenta.insertarInicio(item);
    }
    public ListaSimple<ItemVenta> getItems() {
        return itemsEnVenta;
    }

    public void revertirVenta(){
        if (!confirmada) {
            for (int index = 0; index < itemsEnVenta.getTamano(); index++) {
                ItemVenta itemActual = itemsEnVenta.buscarPorIndice(index);
                itemActual.revertirStockItemVenta(true);
            }
        } else {
            System.out.println("La venta confirmada no se puede revertir");
        }
        System.out.println("Venta Revertida y stock revertido");
    }

    public Boolean getConfirmada() {
        return confirmada;
    }
    public void setConfirmada(Boolean confirmada) {
        System.out.println("Venta Confirmada");
        this.confirmada = confirmada;
    }

}
