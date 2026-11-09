package model.domain;
import model.structures.ListaDoble;

public class CatalogoNavegable {
    private String Nombre;
    private ListaDoble<Producto> productos;
    public CatalogoNavegable(String nombre) {
        // TODO 3: validar que nombre no sea null ni vacío (IllegalArgumentException)
        if (nombre == "" || nombre == null) {
            throw new IllegalArgumentException("Nombre Vacio o No existe");
        }
        this.Nombre = nombre;
        this.productos = new ListaDoble<Producto>();
        // TODO 4: asignar nombre
        // TODO 5: crear la lista vacía; sin esta línea, la primera inserción
        //         lanza NullPointerException
    }
    
    // TODO 6: getNombre()
    // TODO 7: getProductos() que devuelve la lista

    public String getNombre() {
        return Nombre;
    }

    public ListaDoble<Producto> getProductos() {
        return productos;
    }
    
}
