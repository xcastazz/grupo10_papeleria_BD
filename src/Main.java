
import view.MenuListaView;

public class Main {
    private static MenuListaView lista = new MenuListaView();
    public static void main(String[] args) {
        new ClaseDePruebaParaTenerStockYa().productosDePrueba();
        lista.iniciar();
    }

    public static MenuListaView getLista() {
        return lista;
    }

}
