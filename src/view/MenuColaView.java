package view;

import services.ProveedorService;
import utils.ConsoleUtils;

public class MenuColaView {

    private final ProveedorService proveedorService;

    public MenuColaView(ProveedorService service) {
        this.proveedorService = service;
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = ConsoleUtils.leerEntero("Elija una opción: ");
            switch (opcion) {
                case 1 -> registrarLlegada();
                case 2 -> atender();
                case 3 -> consultarSiguiente();
                case 4 -> verSiHayEnEspera();
                case 5 -> contar();
                case 6 -> listar();
                case 0 -> System.out.println("Saliendo del menú de colas...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void mostrarOpciones() {
        System.out.println("1. Registrar llegada (enqueue)");
        System.out.println("2. Atender al siguiente (dequeue)");
        System.out.println("3. Ver quién sigue (front)");
        System.out.println("4. ¿Hay pedidos en espera? (isEmpty)");
        System.out.println("5. Cantidad en espera (size)");
        System.out.println("6. Listar la fila");
        System.out.println("0. Salir");
    }

    private void registrarLlegada() {
        String telefono = ConsoleUtils.leerTexto("Teléfono del proveedor: ");
        proveedorService.registrarLlegada(telefono); 
        System.out.println("Pedido registrado en la fila.");
    }

    private void atender() {
        if (proveedorService.sinPedidosEnEspera()) {
            System.out.println("No hay pedidos en espera.");
            return;
        }
        var pedido = proveedorService.atenderSiguiente();
        System.out.println("Pedido atendido: " + pedido.getProveedor().getCategoria());
    }

    private void consultarSiguiente() {
        if (proveedorService.sinPedidosEnEspera()) {
            System.out.println("No hay pedidos en espera.");
            return;
        }
        var pedido = proveedorService.consultarSiguiente();
        System.out.println("Siguiente en la fila: " + pedido.getProveedor().getProveedorNombre());
    }

    private void verSiHayEnEspera() {
        if (proveedorService.sinPedidosEnEspera()) {
            System.out.println("No hay pedidos en espera.");
        } else {
            System.out.println("Hay pedidos en espera.");
        }
    }

    private void contar() {
        System.out.println("Pedidos en espera: " + proveedorService.sinPedidosEnEspera());
    }

    private void listar() {
        System.out.println(proveedorService.listarEnEspera());
    }
}