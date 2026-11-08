package view;
 
import service.ProductoService;
import services.CatalogoService;
import utils.ConsoleUtils;
 
public class MenuCatalogoView {
    private final CatalogoService catalogoService;
 
    public MenuCatalogoView(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }
 
    public void iniciar() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = ConsoleUtils.leerEntero("Elija una opción: ");
            switch (opcion) {
                case 1 -> registrar();
                case 2 -> System.out.println(productoService.listarProductosEnOrden());
                case 3 -> System.out.println(productoService.listarProductosEnOrdenInverso());
                case 4 -> verAnterior();
                case 5 -> verSiguiente();
                case 6 -> retirar();
                case 7 -> guardarTodo();
                case 0 -> guardarTodo();
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
 
    private void mostrarOpciones() {
        System.out.println("1. Registrar producto en el catálogo");
        System.out.println("2. Listar del primero al último");
        System.out.println("3. Listar del último al primero");
        System.out.println("4. Hojear producto anterior");
        System.out.println("5. Hojear producto siguiente");
        System.out.println("6. Retirar el producto que estoy mirando");
        System.out.println("7. Guardar");
        System.out.println("0. Guardar y salir");
    }
 
    private void verAnterior() {
        // TODO 1: preguntar al Service si el catálogo tiene productos y si existe uno anterior
        //         (agregue hayProductoAnterior / hayProductoSiguiente si lo necesita);
        //         si no, mostrar un mensaje y volver al menú
        //         -- la View no usa try / catch: el chequeo previo evita la excepción
    }
 
    private void guardarTodo() {
        // TODO 2: llamar a guardarProductos del Service e imprimir el texto que devuelve
    }
 
    // registrar, verSiguiente y retirar: complételos usted con el mismo patrón
}