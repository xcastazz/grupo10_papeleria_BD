package view;

import model.domain.Producto;
import services.StockService;
import services.VentasService;
import utils.ConsoleUtils;

public class MenuPilaView {
        private VentasService ventaService;
        private StockService stockService;

        public MenuPilaView(VentasService ventaService, StockService stockService) {
            this.ventaService = ventaService;
            this.stockService = stockService;
        }

        public void iniciar() {
                    int opcion;
        do {
            mostrarMenuC();
            opcion = ConsoleUtils.leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> realizarVenta();
                case 2 -> ventaService.consultarUltimaOperacion();
                case 3 -> consultarVentas();
                case 4 -> ventaService.confirmarVenta();
                case 5 -> consultarOperacionPorConfirmar();
                case 6 -> ventaService.rechazarVenta();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
        }

            private void mostrarMenuC() {
        System.out.println("1. Realizar Venta");
        System.out.println("2. Revisar la ultima Operacion");
        System.out.println("3. Consultar Operaciones totales");
        System.out.println("4. Confirmar la Ultima Operacion");
        System.out.println("5. ¿Hay Operaciones Por Confirmar?");
        System.out.println("6. Revertir Ultima Operacion");
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
        continuarVenta();
        return productoAVender;
    }

    private void consultarOperacionPorConfirmar(){
        boolean flag = ventaService.sinOperacionesPorDeshacer();
        if (flag) {
            System.out.println("No Se encuentran Ventas Recientes Por Confirmar");
        } else {
            System.out.println("Se Encontró una Venta Pendiente de confirmacion:");
            ventaService.consultarUltimaOperacion();
        }
    }

    private void continuarVenta(){
        ventaService.consultarUltimaOperacion();
        int Opcion = ConsoleUtils.leerEntero("Venta Concluida? [1] Si || [2] Continuar Comprando || [3] No ");
        switch (Opcion) {
            case 1:
                System.out.println("Venta Concluida");
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
        System.out.println("Actualmente hay "+ventasCantidad+" Operaciones Realizadas");
    }
}
