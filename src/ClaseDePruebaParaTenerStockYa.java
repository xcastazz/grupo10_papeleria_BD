
import services.StockService;



public class ClaseDePruebaParaTenerStockYa {
    private StockService stockServiceActual;

    public ClaseDePruebaParaTenerStockYa(StockService servicio) {
        this.stockServiceActual = servicio; 
    }

    public void productosDePrueba(){
        stockServiceActual.registrarProductoEscolar("1444", "Jalea", 1200, 10, "primaria");
        stockServiceActual.registrarProductoOficina("5000", "Gomas", 5000, 5, "THC");
        
    }

}
