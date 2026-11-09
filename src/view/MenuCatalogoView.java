package view;
 
import model.domain.Producto;
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
                case 2 -> System.out.println(catalogoService.listarProductosEnOrden());
                case 3 -> System.out.println(catalogoService.listarProductosEnOrdenInverso());
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
 
    private void registrar(){
        int tipo = ConsoleUtils.leerEntero("Ingrese el Tipo de Producot [1] Escolar || [2] Oficina");
        String codigo;
        String nombre;
        double precio;
        int cantidadStock;
        String Categoria;
        switch (tipo) {
            case 1:
                codigo = ConsoleUtils.leerTexto("Codigo: ");
                nombre = ConsoleUtils.leerTexto("Nombre: ");
                precio = ConsoleUtils.leerDecimal("Precio: ");
                Categoria = ConsoleUtils.leerTexto("Nivel Escolar");
                cantidadStock = ConsoleUtils.leerEntero("Cantidad de Stock: ");
                catalogoService.registrarProducto(tipo, codigo, nombre, precio, cantidadStock, Categoria);
                break;
            case 2:
                codigo = ConsoleUtils.leerTexto("Codigo: ");
                nombre = ConsoleUtils.leerTexto("Nombre: ");
                precio = ConsoleUtils.leerDecimal("Precio: ");
                Categoria = ConsoleUtils.leerTexto("Categoria");
                cantidadStock = ConsoleUtils.leerEntero("Cantidad de Stock: ");
                catalogoService.registrarProducto(tipo, codigo, nombre, precio, cantidadStock, Categoria);
                break;
            default:
                System.out.println("Tipo incorrecto");
                break;
        }
    }

    private void verAnterior() {
        if (catalogoService.estaVacioCatalogo()) {
            
        }
        if (catalogoService.hayProductoAnterior()) {
            catalogoService.verProductoAnterior();   
        }
        System.out.println("No hay producto anterior");
        // TODO 1: preguntar al Service si el catálogo tiene productos y si existe uno anterior
        //         (agregue hayProductoAnterior / hayProductoSiguiente si lo necesita);
        //         si no, mostrar un mensaje y volver al menú
        //         -- la View no usa try / catch: el chequeo previo evita la excepción
    }

        private void verSiguiente() {
        if (catalogoService.estaVacioCatalogo()) {
            
        }
        if (catalogoService.hayProductoSiguiente()) {
            catalogoService.verProductoSiguiente(); 
        } else {
            System.out.println("No hay producto Siguiente");
        }
    }

    private void retirar(){
        if (catalogoService.estaVacioCatalogo()) {
            
        }
        if (!catalogoService.hayProductoSiguiente()) {
            System.out.println("No hay producto A Retirar");
        }
        Producto productoARetirar = catalogoService.retirarProducto();
            System.out.println("---- Producto Retirado ----");
            System.out.println("Código : " + productoARetirar.getCodigo());
            System.out.println("Nombre : " + productoARetirar.getNombre());
            System.out.println("Precio : " + productoARetirar.getPrecio());
            System.out.println("Stock : " + productoARetirar.getStock());
            System.out.println("---------------------------");
    }

    private void guardarTodo() {
        catalogoService.persistir();
        // TODO 2: llamar a guardarProductos del Service e imprimir el texto que devuelve
    }
 
    // registrar, verSiguiente y retirar: complételos usted con el mismo patrón
}