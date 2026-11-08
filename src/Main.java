
import view.MenuPrincipal;

public class Main {

    public static void main(String[] args) throws Exception {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        new ClaseDePruebaParaTenerStockYa(menuPrincipal.getStockService(),menuPrincipal.getProveedorService()).productosDePrueba();
        menuPrincipal.iniciar();
    }
    
}
