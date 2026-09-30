package services;

import model.domain.Producto;
import model.domain.ProductoEscolar;
import model.domain.ProductoOficina;
import model.domain.Proveedor;
import structures.ListaSimple;
import structures.Nodo;

public class ProveedorService {
    private ListaSimple<Proveedor> matrizProveedor = new ListaSimple<>();

    public Proveedor registrarProveedor(String nombreProveedor, String telefonoProveedor, String categoriaProductos){
        Proveedor Nuevo = new Proveedor(nombreProveedor, telefonoProveedor, categoriaProductos);
        matrizProveedor.insertarFinal(Nuevo);
        return Nuevo;
    }


    public Proveedor buscarProveedorPorNombre(String Nombre) {
        Nodo<Proveedor> proveedorActual = matrizProveedor.getHead();
        while (proveedorActual != null) {
            if (proveedorActual.getDato().getProveedorNombre().equals(Nombre)) {
                return proveedorActual.getDato();
            }
            proveedorActual = proveedorActual.getSiguiente();
        }
        System.out.println("Dato no encontrado");
        return null;
    }

    public Proveedor buscarProveedorPorTelefono(String Telefono) {
        Nodo<Proveedor> proveedorActual = matrizProveedor.getHead();
        while (proveedorActual != null) {
            if (proveedorActual.getDato().getProveedorTelefono().equals(Telefono)) {
                return proveedorActual.getDato();
            }
            proveedorActual = proveedorActual.getSiguiente();
        }
        System.out.println("Dato no encontrado");
        return null;
    }

    public Proveedor buscarProveedorPorIndice(int indice) {
        Proveedor ProveedorEncontrador = matrizProveedor.buscarPorIndice(indice);
        if (ProveedorEncontrador != null) {
            return ProveedorEncontrador;
        }
        return null;
    }

    public void recorrerListaProveedores() {
        Nodo<Proveedor> actual = matrizProveedor.getHead();
        System.out.println("===        Proveedores        ===");
        for (int i = 0; i < matrizProveedor.getTamano(); i++) {
            Proveedor proveedorActual = actual.getDato();
            System.out.println("Indice: " + i );
            System.out.println("Nombre : " + proveedorActual.getProveedorNombre());
            System.out.println("Telefono : " + proveedorActual.getProveedorTelefono());
            System.out.println("Categoria : " + proveedorActual.getCategoria());
            System.out.println("--------------------------------");
            actual = actual.getSiguiente();
        }
    }

    public void actualizarNombreProveedor(Proveedor ProveedorACambiar, String nuevoNombre) {
        if (ProveedorACambiar != null) {
            ProveedorACambiar.actualizarNombre(nuevoNombre);
            System.out.println("Nombre del Proveedor actualizado exitosamente.");
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }

    public void actualizarTelefonoProveedor(Proveedor proveedorAEncontrar, String telefonoNuevo) {
        if (proveedorAEncontrar != null) {
            proveedorAEncontrar.actualizarTelefono(telefonoNuevo);
            System.out.println("Telefono del proveedor actualizado exitosamente.");
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }

    public void actualizarCategoriaProveedor(Proveedor proveedorAEncontrar, String categoriaNueva) {
        if (proveedorAEncontrar != null) {
            proveedorAEncontrar.actualizarCategoria(categoriaNueva);;
            System.out.println("Categoria del proveedor actualizada exitosamente.");
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }

    public boolean eliminarProveedor(Proveedor proveedorAEliminar) {
        if (proveedorAEliminar != null) {
            boolean eliminado = matrizProveedor.eliminar(proveedorAEliminar);
            if (eliminado) {
                System.out.println("Proveedor eliminado exitosamente.");
                return true;
            } else {
                System.out.println("Error al eliminar el Proveedor.");
                return false;
            }
        } else {
            System.out.println("Proveedor no encontrado.");
            return false;
        }
    }

}
