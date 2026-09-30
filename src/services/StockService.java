package services;

import model.domain.Producto;
import model.domain.ProductoEscolar;
import model.domain.ProductoOficina;
import structures.ListaSimple;
import structures.Nodo;

public class StockService {
    private ListaSimple<Producto> matrizProducto = new ListaSimple<>();

    public Producto registrarProductoEscolar(String codigo, String nombre, double precio, int cantidadStock, String nivelEscolar){
        Producto Nuevo = new ProductoEscolar(codigo, nombre, precio, cantidadStock, nivelEscolar);
        matrizProducto.insertarFinal(Nuevo);
        return Nuevo;
    }

    public Producto registrarProductoOficina(String codigo, String nombre, double precio, int cantidadStock, String categoria){
        Producto Nuevo = new ProductoOficina(codigo, nombre, precio, cantidadStock, categoria);
        matrizProducto.insertarFinal(Nuevo);
        return Nuevo;
    }


    public Producto buscarProductoPorCodigo(String codigo) {
        Nodo<Producto> productoActual = matrizProducto.getHead();
        while (productoActual != null) {
            if (productoActual.getDato().getCodigo().equals(codigo)) {
                return productoActual.getDato();
            }
            productoActual = productoActual.getSiguiente();
        }
        System.out.println("Dato no encontrado");
        return null;
    }

        public Producto buscarProductoPorNombre(String nombre) {
        Nodo<Producto> productoActual = matrizProducto.getHead();
        while (productoActual != null) {
            if (productoActual.getDato().getNombre().equals(nombre)) {
                return productoActual.getDato();
            }
            productoActual = productoActual.getSiguiente();
        }
        System.out.println("Dato no encontrado");
        return null;
    }

    public Producto buscarProductoPorIndice(int indice) {
        Producto clienteEncontrado = matrizProducto.buscarPorIndice(indice);
        if (clienteEncontrado != null) {
            return clienteEncontrado;
        }
        return null;
    }

    public void recorrerListaProductos() {
        Nodo<Producto> actual = matrizProducto.getHead();
        System.out.println("===        Stock        ===");
        for (int i = 0; i < matrizProducto.getTamano(); i++) {
            Producto productoActual = actual.getDato();
            System.out.println("Indice: " + i );
            System.out.println("Código : " + productoActual.getCodigo());
            System.out.println("Nombre : " + productoActual.getNombre());
            System.out.println("Precio : " + productoActual.getPrecio());
            System.out.println("Stock : " + productoActual.getStock());
            System.out.println("---------------------------");
            actual = actual.getSiguiente();
        }
    }

    public void actualizarNombreProducto(Producto producto, String nuevoNombre) {
        if (producto != null) {
            producto.setNombre(nuevoNombre);
            System.out.println("Nombre del Producto actualizado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void actualizarStockProducto(Producto productoAEncontrar, int stockNuevo) {
        if (productoAEncontrar != null) {
            productoAEncontrar.setStock(stockNuevo);;
            System.out.println("Stock del Producto actualizado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void actualizarPrecioProducto(Producto productoAEncontrar, double nuevoPrecio) {
        if (productoAEncontrar != null) {
            productoAEncontrar.setPrecio(nuevoPrecio);
            System.out.println("Precio del producto actualizada exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public boolean eliminarProducto(Producto productoAEliminar) {
        if (productoAEliminar != null) {
            boolean eliminado = matrizProducto.eliminar(productoAEliminar);
            if (eliminado) {
                System.out.println("Producto eliminado exitosamente.");
                return true;
            } else {
                System.out.println("Error al eliminar el cliente.");
                return false;
            }
        } else {
            System.out.println("Cliente no encontrado.");
            return false;
        }
    }

}
