
import view.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        new ClaseDePruebaParaTenerStockYa(menuPrincipal.getStockService(),menuPrincipal.getProveedorService()).productosDePrueba();
        menuPrincipal.iniciar();
    }
    
}
