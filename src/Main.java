
import utils.ConsoleUtils;
import view.MenuListaView;
import view.MenuPilaView;

public class Main {
    private static MenuListaView lista = new MenuListaView();
    private static MenuPilaView pilas = new MenuPilaView();
    public static void main(String[] args) {
        
        int opcion = ConsoleUtils.leerEntero("Ingrese una opcion para continuar");
        new ClaseDePruebaParaTenerStockYa().productosDePrueba();
        switch (opcion) {
            case 1:
                lista.iniciar();
                break;
            case 2:
                pilas.iniciar();
                break;
            default:
                break;
        }
    }

    public static MenuListaView getLista() {
        return lista;
    }

}
