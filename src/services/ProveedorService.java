package services;

import model.domain.Pedido;
import model.domain.PedidosPendientes;
import model.domain.Proveedor;
import structures.Cola;
import structures.ListaSimple;
import structures.Nodo;

public class ProveedorService {

    private ListaSimple<Proveedor> matrizProveedor = new ListaSimple<>();
    private final PedidosPendientes ventanillaPedidos = new PedidosPendientes("Ventanilla de Pedidos 1");

    public Proveedor registrarProveedor(String nombreProveedor, String telefonoProveedor, String categoriaProductos){
        Proveedor Nuevo = new Proveedor(nombreProveedor, telefonoProveedor, categoriaProductos);
        matrizProveedor.insertarFinal(Nuevo);
        return Nuevo;
    }

    public void ordenarPedidoProveedor(String telefono){
        Proveedor proveedorALlamar = buscaProveedorOFallar(telefono);
        proveedorALlamar.registrarPedido("Ordenado");
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

    private Proveedor buscaProveedorOFallar(String Telefono){
        Proveedor proveedor = buscarProveedorPorTelefono(Telefono);
        if (proveedor == null) {
            throw new IllegalArgumentException("El Proveedor con Telefono " + Telefono + " no existe");
        }
        return proveedor;
    }

    
    public void registrarLlegada(String telefono) {
        Proveedor recienLlegado = buscaProveedorOFallar(telefono); // propaga excepción si no existe
        Pedido pedidoRecienLlegado = recienLlegado.getPedidosLista();
        ventanillaPedidos.getFila().enqueue(pedidoRecienLlegado);
    }

    public Pedido atenderSiguiente() {
        // Si la cola está vacía, NoSuchElementException se propaga (no se atrapa aquí)
        return ventanillaPedidos.getFila().dequeue();
    }

    public Pedido consultarSiguiente() {
        return ventanillaPedidos.getFila().front();
    }

    public boolean sinPedidosEnEspera() {
        return ventanillaPedidos.getFila().isEmpty();
    }

    public int contarEnEspera() {
        return ventanillaPedidos.getFila().size();
    }
    public String listarEnEspera() {
        Cola<Pedido> fila = ventanillaPedidos.getFila();
        if (fila.isEmpty()) {
            return "No hay pedidos en espera";
        }
        StringBuilder texto = new StringBuilder();
        int total = fila.size();
        for (int i = 1; i <= total; i++) {
            Pedido pedido = fila.dequeue();
            texto.append(i).append(". ")
                 .append(pedido.getProveedor().getCategoria())
                 .append("\n");
            fila.enqueue(pedido);
        }
        return texto.toString();
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
            proveedorActual.imprimirInfo();
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
