
import services.StockService;
import view.MenuListaView;



public class ClaseDePruebaParaTenerStockYa {
    private MenuListaView lista;
    private StockService stockServiceActual;

    public ClaseDePruebaParaTenerStockYa() {
        this.lista = Main.getLista();
        this.stockServiceActual = lista.getStockService();
    }

    public void productosDePrueba(){
        stockServiceActual.registrarProductoEscolar("1444", "Jalea", 1200, 10, "primaria");
        stockServiceActual.registrarProductoOficina("5000", "Gomas", 5000, 5, "THC");
        
    }

}
