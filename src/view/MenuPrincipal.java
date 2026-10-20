package view;


import services.ProveedorService;
import services.StockService;
import services.VentasService;
import utils.ConsoleUtils;

public class MenuPrincipal {
    private VentasService ventaService = new VentasService();
    private StockService stockService = new StockService();
    private ProveedorService proveedorService = new ProveedorService();


    private MenuListaView lista = new MenuListaView(stockService, proveedorService);
    private MenuPilaView pilas = new MenuPilaView(ventaService, stockService);
    private MenuColaView colas = new MenuColaView(proveedorService);

    public void iniciar(){
        int opcion;
        do { 
            MostrarOpciones();
        opcion = ConsoleUtils.leerEntero("Ingrese una opcion para continuar");
            switch (opcion) {
                case 1:
                    lista.iniciar();
                    break;
                case 2:
                    pilas.iniciar();
                    break;
                case 3:
                    colas.iniciar();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    private void MostrarOpciones(){
        System.out.println("========= Menu Principal =============");
        System.out.println("=========    Opciones    =============");
        System.out.println("1. Lista Simple \n(Gestion de Productos Y Proveedores)");
        System.out.println("2. Pilas (Realizar y Gestionar Ventas)");
        System.out.println("3. Colas (Gestion de Pedidos de Proveedores)");
        System.out.println("0. Salir Del sistema");
    }

    public VentasService getVentaService() {
        return ventaService;
    }

    public StockService getStockService() {
        return stockService;
    }

    public ProveedorService getProveedorService() {
        return proveedorService;
    }

    

}
