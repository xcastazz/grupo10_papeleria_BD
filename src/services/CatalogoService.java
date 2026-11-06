package services;
import model.domain.*;

public class CatalogoService {
    // Dentro de ProductoService (ajuste los nombres a su dominio)
// Imports necesarios: model.domain.CatalogoProductos y model.domain.ProductoBancario

// Un solo catálogo por Service: si se creara uno nuevo en cada método,
// cada operación vería una lista distinta
    private final CatalogoNavegable catalogo = new CatalogoNavegable("Catálogo de productos");

    public void registrarProducto(String codigo, String nombre, String tipo, double tasaAnual, String Categoria) {
    // TODO 1: crear el ProductoBancario con sus cuatro campos
    // TODO 2: insertarlo al final de la lista
    }
 
public String listarProductosEnOrdenInverso() {
    // TODO 1: si la lista está vacía, devolver "No hay productos en el catálogo"
    // TODO 2: devolver lo que arma recorrerAtras de la lista (un producto por línea)
    //         -- ProductoBancario debe sobrescribir toString para que cada línea se lea bien
    return null; // reemplazar
}
 
public Producto verProductoAnterior() {
    // TODO 1: pedir a la lista (catalogo.getProductos()) el anterior con anterior() y devolverlo
    //         -- el cursor vive en la lista: el Service no guarda posiciones
    return null; // reemplazar
}
 
public Producto retirarProducto() {
    // TODO 1: retirar de la lista el producto que se está mirando con retirarActual()
    //         (sin producto seleccionado deja salir NoSuchElementException: no la atrape aquí)
    // TODO 2: devolver el producto retirado
    return null; // reemplazar
}

}
