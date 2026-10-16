package view;

import model.domain.Producto;
import model.domain.Venta;
import services.VentasService;
import utils.ConsoleUtils;

public class MenuPilaView {
        private VentasService ventaService = new VentasService();
        public void iniciar() {
                    int opcion;
        do {
            mostrarMenuC();
            opcion = ConsoleUtils.leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> realizarVenta();
                case 2 -> consultarVentas();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
        }

            private void mostrarMenuC() {
        System.out.println("1. Realizar Venta");
        System.out.println("2. Consultar Ventas totales");
        System.out.println("0. Salir");
    }

            private Producto realizarVenta(){
        String nombre = ConsoleUtils.leerTexto("Nombre del producto a vender: ");
        if (stockService.buscarProductoPorNombre(nombre) == null) {
            return null;
        }
        int cantidad = ConsoleUtils.leerEntero("Cantidad del producto a vender: ");
        Producto productoAVender = stockService.buscarProductoPorNombre(nombre);
        if (ventaService.sinOperacionesPorDeshacer() == false) {
            ventaService.continuarVenta(productoAVender, cantidad);
        } else {
            ventaService.realizarVenta(productoAVender, cantidad);
        }
        confirmarVenta();
        return productoAVender;
    }

    private void confirmarVenta(){
        int Opcion = ConsoleUtils.leerEntero("Venta confirmada? [1] Si || [2] Continuar Comprando || [3] No ");
        Venta ventaAConfirmar = ventaService.consultarUltimaOperacion();
        switch (Opcion) {
            case 1:
                ventaAConfirmar.setConfirmada(true);
            break;
            case 2:
                realizarVenta();
            break;
            case 3:
                ventaService.rechazarVenta();
            break;
            default:
                break;
        }
    } 

    private void consultarVentas(){
        int ventasCantidad = ventaService.registarVentas();
        System.out.println("Actualmente hay "+ventasCantidad+ "Operaciones Realizadas");
    }
}
