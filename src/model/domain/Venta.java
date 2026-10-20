package model.domain;

import structures.ListaSimple;
import structures.Nodo;


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

    public String MostrarItemVenta() {
        StringBuilder sb = new StringBuilder();
        Nodo<ItemVenta> actual = itemsEnVenta.getHead();

    sb.append("||===       Datos de Venta        ===\n");
    sb.append(" ||=== Venta Confirmada? ").append(confirmada).append("\n");
    for (int i = 0; i < itemsEnVenta.getTamano(); i++) {
            ItemVenta productoActual = actual.getDato();
            sb.append("Indice: " + i );
            sb.append(productoActual.mostrarAtributos());
            actual = actual.getSiguiente();
        }
    sb.append(" ||==================================\n");
    sb.append("||===================================\n");
    return sb.toString();
}


    public Boolean getConfirmada() {
        return confirmada;
    }
    public void setConfirmada(Boolean confirmada) {
        this.confirmada = confirmada;
    }


}
