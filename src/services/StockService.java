package services;

import java.io.*;
import model.domain.Producto;
import model.domain.ProductoEscolar;
import model.domain.ProductoOficina;
import model.structures.ListaSimple;
import model.structures.Nodo;


public class StockService {
    private static final String ARCHIVO_PRODUCTOS = "data/productos.txt";
    private static final String SEPARADOR = ";";
    private ListaSimple<Producto> matrizProducto;

    public StockService() {
        System.out.println(cargarProductos());
    }



    public Producto registrarProductoEscolar(String codigo, String nombre, double precio, int cantidadStock, String nivelEscolar){
        Producto Nuevo = new ProductoEscolar(codigo, nombre, precio, cantidadStock, nivelEscolar);
        matrizProducto.insertarFinal(Nuevo);
        persistir();
        return Nuevo;
    }

    public Producto registrarProductoOficina(String codigo, String nombre, double precio, int cantidadStock, String categoria){
        Producto Nuevo = new ProductoOficina(codigo, nombre, precio, cantidadStock, categoria);
        matrizProducto.insertarFinal(Nuevo);
        persistir();
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
                System.out.println("Error al eliminar el producto.");
                return false;
            }
        } else {
            System.out.println("producto no encontrado.");
            return false;
        }
    }

    public String cargarProductos() {
        File archivo = new File(ARCHIVO_PRODUCTOS);
        matrizProducto = new ListaSimple<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(SEPARADOR);
                if (campos.length != 6) {
                    continue;
                }
                switch (campos[0]) {
                    case "1":
                        registrarProductoEscolar(campos[1], campos[2],Double.parseDouble(campos[3]),Integer.parseInt(campos[4]),campos[5]);
                        break;
                    case "2":
                        registrarProductoOficina(campos[1], campos[2],Double.parseDouble(campos[3]),Integer.parseInt(campos[4]),campos[5]);
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            return "No existe " + ARCHIVO_PRODUCTOS + "; se inicia con la lista de productos en el stock vacía";
        } catch (IOException e) {
            return "No se pudo leer: " + e.getMessage();
        }
        return "Se cargaron " + matrizProducto.getTamano() + " clientes. "; // las cuentas cuelgan de sus clientes
    }

    public void persistir() {
        try {
            escribirProductos();
        } catch (IOException e) {
            System.out.println("No se pudieron guardar los productos en el archivo: " + e.getMessage());
        }
    }


    private void escribirProductos() throws IOException {
        File carpeta = new File(ARCHIVO_PRODUCTOS).getParentFile();
        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }

        String texto = "";
        Nodo<Producto> actual = matrizProducto.getHead();
        while (actual != null) {
            Producto productoActual = actual.getDato();
            if (productoActual instanceof ProductoEscolar) {
                texto += String.join(SEPARADOR,
                    String.valueOf("1"),
                    productoActual.getCodigo(),
                    productoActual.getNombre(),
                    String.valueOf(productoActual.getPrecio()),
                    String.valueOf(productoActual.getStock()),
                    String.valueOf(((ProductoEscolar) productoActual).getNivelEscolar())) + "\n";
            } else if (productoActual instanceof ProductoOficina) {
                texto += String.join(SEPARADOR,
                    String.valueOf("2"),
                    productoActual.getCodigo(),
                    productoActual.getNombre(),
                    String.valueOf(productoActual.getPrecio()),
                    String.valueOf(productoActual.getStock()),
                    String.valueOf(((ProductoOficina) productoActual).getCategoria())) + "\n";
            }
            
            actual = actual.getSiguiente();
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARCHIVO_PRODUCTOS))) {
            escritor.write(texto);
        }
    }


}
