package view;

import model.domain.Producto;

import java.io.Console;
import model.domain.ItemVenta;
import model.domain.Proveedor;
import services.ProveedorService;

import services.StockService;
import utils.*;

public class MenuListaView {
    private StockService stockService = new StockService();
    private ProveedorService proveedorService = new ProveedorService();

    public void iniciar() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = ConsoleUtils.leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> menuAOpciones();
                case 2 -> menuBOpciones();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        ConsoleUtils.cerrar();
    }

    private void menuAOpciones(){
        int opcion;    
        do {
            mostrarMenuA();
            opcion = ConsoleUtils.leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> agregarProveedor();
                case 2 -> buscarProveedorPorNombre();
                case 3 -> buscarProveedorPorIndice();
                case 4 -> actualizarProveedorPorTelefono();
                case 5 -> eliminarProveedorPorNumero();
                case 6 -> proveedorService.recorrerListaProveedores();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        ConsoleUtils.cerrar();
    }

    private void menuBOpciones(){
        int opcion;    
        do {
            mostrarMenuB();
            opcion = ConsoleUtils.leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> buscarProductoPorCodigo();
                case 3 -> buscarProductoPorIndice();
                case 4 -> actualizarProductoPorCodigo();
                case 5 -> eliminarProductoPorCodigo();
                case 6 -> stockService.recorrerListaProductos();
                case 7 -> realizarVenta();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        ConsoleUtils.cerrar();
    }


    private void mostrarMenuPrincipal(){
        System.out.println("1. Gestionar Proveedores");
        System.out.println("2. Gestionar Productos");
    }

    private void mostrarMenuA() {
        System.out.println("1. Registrar Proveedor");
        System.out.println("2. Buscar Proveedor por Nombre");
        System.out.println("3. Buscar Proveedor por indice");
        System.out.println("4. Actualizar Proveedor por Telefono");
        System.out.println("5. Eliminar Proveedor por Telefono");
        System.out.println("6. Listar Proveedores");
        System.out.println("0. Salir");
    }

    private void mostrarMenuB() {
        System.out.println("1. Registrar Producto");
        System.out.println("2. Buscar Producto por Codigo");
        System.out.println("3. Buscar Producto por indice");
        System.out.println("4. Actualizar Producto por Codigo");
        System.out.println("5. Eliminar Producto por Codigo");
        System.out.println("6. Listar Productos");
        System.out.println("0. Salir");
    }

    private void agregarProducto() {
        int Tipo = ConsoleUtils.leerEntero("Seleccione una opcion [1] Producto Escolar || [2] Producto de Oficina");
        String codigo;
        String nombre;
        double precio;
        int cantidadStock;
        String nivelEscolarOCategoria;
        switch (Tipo) {
            case 1:
            codigo = ConsoleUtils.leerTexto("Codigo: ");
            nombre = ConsoleUtils.leerTexto("Nombre: ");
            precio = ConsoleUtils.leerDecimal("Precio: ");
            cantidadStock = ConsoleUtils.leerEntero("Cantidad en el Stock: ");
            nivelEscolarOCategoria = ConsoleUtils.leerTexto("Nivel Escolar");
            stockService.registrarProductoEscolar(codigo,nombre,precio,cantidadStock,nivelEscolarOCategoria);
                break;
            case 2:
            codigo = ConsoleUtils.leerTexto("Codigo: ");
            nombre = ConsoleUtils.leerTexto("Nombre: ");
            precio = ConsoleUtils.leerDecimal("Precio: ");
            cantidadStock = ConsoleUtils.leerEntero("Cantidad en el Stock: ");
            nivelEscolarOCategoria = ConsoleUtils.leerTexto("Categoria");
            stockService.registrarProductoOficina(codigo, nombre, precio, cantidadStock, nivelEscolarOCategoria);
                break;
            default:
                System.out.println("Error seleccione una de las opciones validas");
                break;
        }
        System.out.println("Producto Registrado exitosamente.");
    }

    private void agregarProveedor() {
        String nombre = ConsoleUtils.leerTexto("Nombre: ");
        String telefono = ConsoleUtils.leerTexto("Telefono: ");
        String categoria = ConsoleUtils.leerTexto("Categoria de productos: ");
        proveedorService.registrarProveedor(nombre, telefono, categoria);
        System.out.println("Proveedor creado exitosamente.");
    }


    private Producto buscarProductoPorCodigo() {
        String codigo = ConsoleUtils.leerTexto("Codigo: ");
        return stockService.buscarProductoPorCodigo(codigo);
    }

    private Proveedor buscarProveedorPorNombre() {
        String nombre = ConsoleUtils.leerTexto("Nombre: ");
        return proveedorService.buscarProveedorPorNombre(nombre);
    }

    private void buscarProductoPorIndice() {
        int indice = ConsoleUtils.leerEntero("Indice del producto: ");
        Producto productoABuscar = stockService.buscarProductoPorIndice(indice);
        if (productoABuscar != null) {
            System.out.println("Producto encontrado: " + productoABuscar.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void buscarProveedorPorIndice() {
        int indice = ConsoleUtils.leerEntero("Indice del proveedor: ");
        Proveedor proveedorABuscar = proveedorService.buscarProveedorPorIndice(indice);
        if (proveedorABuscar != null) {
            System.out.println("Producto encontrado: " + proveedorABuscar.getProveedorNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void mostrarMenuActualizarProducto() {
        System.out.println("1. Actualizar Nombre");
        System.out.println("2. Actualizar Precio");
        System.out.println("3. Actualizar Stock");
    }

    private void mostrarMenuActualizarProveedor() {
        System.out.println("1. Actualizar Nombre");
        System.out.println("2. Actualizar Telefono");
        System.out.println("3. Actualizar Direccion");
    }

    private void actualizarProductoPorCodigo() {
        String codigo = ConsoleUtils.leerTexto("Codigo del producto a actualizar: ");
        Producto productoAActualizar = stockService.buscarProductoPorCodigo(codigo);
        if (productoAActualizar == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        mostrarMenuActualizarProducto();
        int opcion = ConsoleUtils.leerEntero("Seleccione una opcion: ");
        switch (opcion) {
            case 1: {
                String nuevoNombre = ConsoleUtils.leerTexto("Nuevo nombre: ");
                stockService.actualizarNombreProducto(productoAActualizar, nuevoNombre);
                break;
            }
            case 2: {
                double nuevoPrecio = ConsoleUtils.leerDecimal("Nuevo precio: ");
                stockService.actualizarPrecioProducto(productoAActualizar, nuevoPrecio);
                break;
            }
            case 3: {
                int nuevoStock = ConsoleUtils.leerEntero("Nueva stock: ");
                stockService.actualizarStockProducto(productoAActualizar, nuevoStock);
                break;
            }
            default:
                System.out.println("Opcion invalida.");
        }
    }

    private void actualizarProveedorPorTelefono() {
        String telefono = ConsoleUtils.leerTexto("Telefono del proveedor a actualizar: ");
        Proveedor ProveedorACambiar = proveedorService.buscarProveedorPorTelefono(telefono);
        if (ProveedorACambiar == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        mostrarMenuActualizarProveedor();
        int opcion = ConsoleUtils.leerEntero("Seleccione una opcion: ");
        switch (opcion) {
            case 1: {
                String nuevoNombre = ConsoleUtils.leerTexto("Nuevo nombre: ");
                proveedorService.actualizarNombreProveedor(ProveedorACambiar, nuevoNombre);
                break;
            }
            case 2: {
                String nuevoTelefono = ConsoleUtils.leerTexto("Nuevo Telefono: ");
                proveedorService.actualizarNombreProveedor(ProveedorACambiar, nuevoTelefono);
                break;
            }
            case 3: {
                String nuevaCategoria = ConsoleUtils.leerTexto("Nueva categoria: ");
                proveedorService.actualizarCategoriaProveedor(ProveedorACambiar, nuevaCategoria);
                break;
            }
            default:
                System.out.println("Opcion invalida.");
        }
    }


    private void eliminarProveedorPorNumero() {
        String telefono = ConsoleUtils.leerTexto("telefono del proveedor a eliminar: ");
        Proveedor proveedorAEliminar = proveedorService.buscarProveedorPorTelefono(telefono);
        if (proveedorAEliminar != null) {
            boolean eliminado = proveedorService.eliminarProveedor(proveedorAEliminar);
            if (eliminado) {
                System.out.println("Producto eliminado exitosamente.");
            } else {
                System.out.println("Error al eliminar el Producto.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void eliminarProductoPorCodigo() {
        String codigo = ConsoleUtils.leerTexto("codigo del producto a eliminar: ");
        Producto productoAEliminar = stockService.buscarProductoPorCodigo(codigo);
        if (productoAEliminar != null) {
            boolean eliminado = stockService.eliminarProducto(productoAEliminar);
            if (eliminado) {
                System.out.println("Producto eliminado exitosamente.");
            } else {
                System.out.println("Error al eliminar el Producto.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private Producto realizarVenta(){
        String nombre = ConsoleUtils.leerTexto("Nombre del producto a vender: ");
        int cantidad = ConsoleUtils.leerEntero("Cantidad del producto a vender: ");
        Producto productoAVender = stockService.buscarProductoPorNombre(nombre);
        ItemVenta VentaNueva = new ItemVenta(productoAVender, cantidad);
        VentaNueva.doItemVenta();
        return productoAVender;
    }

}
    

