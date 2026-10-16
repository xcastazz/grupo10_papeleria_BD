package view;
 
import model.domain.Cliente;
import service.ClienteService;
import utils.ConsoleUtils;
 
public class MenuColaView {
 
    public MenuColaView() {
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
        System.out.println("4. ¿Hay clientes en espera? (isEmpty)");
        System.out.println("5. Cantidad en espera (size)");
        System.out.println("6. Listar la fila (Parte 7)");
        System.out.println("0. Salir");
    }
 
    private void registrarLlegada() {
        String identificacion = ConsoleUtils.leerTexto("Identificación del cliente: ");
        // TODO 1: llamar a clienteService.registrarLlegada y confirmar por consola
    }
 
    private void atender() {
        // TODO 2: si clienteService.sinClientesEnEspera() es true, mostrar
        //         "No hay clientes en espera" y salir del método; si no, llamar a
        //         atenderSiguiente y mostrar al cliente atendido
        //         -- sin este chequeo, un dequeue sobre fila vacía lanza la excepción y cierra el programa
    }
 
    private void consultarSiguiente() {
        // TODO 3: si no hay clientes en espera, mostrar el mismo mensaje del TODO 2;
        //         si hay, llamar a consultarSiguiente y mostrar al cliente que sigue
    }
 
    private void verSiHayEnEspera() {
        // TODO 4: llamar a sinClientesEnEspera y mostrar un mensaje legible
        //         ("No hay clientes en espera" / "Hay clientes en espera")
    }
 
    private void contar() {
        // TODO 5: llamar a contarEnEspera y mostrar el número
    }
 
    private void listar() {
        // TODO 6: se completa en la Parte 7, cuando exista listarEnEspera en el Service
    }
}