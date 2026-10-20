
import services.ProveedorService;
import services.StockService;



public class ClaseDePruebaParaTenerStockYa {
    private StockService stockServiceActual;
    private ProveedorService proveedorServiceActual;
    public ClaseDePruebaParaTenerStockYa(StockService servicio, ProveedorService proveedorService) {
        this.stockServiceActual = servicio; 
        this.proveedorServiceActual = proveedorService;
    }

    public void productosDePrueba(){
        stockServiceActual.registrarProductoEscolar("1444", "Lapices", 1200, 10, "primaria");
        stockServiceActual.registrarProductoOficina("5000", "Grapadoras", 5000, 5, "Oficina");
        stockServiceActual.registrarProductoOficina("5000", "Marcador", 400, 100, "primaria");
        proveedorServiceActual.registrarProveedor("Dimitri", "444123456", "Oficina");
        proveedorServiceActual.registrarProveedor("Nadya", "123456789","primaria");
        proveedorServiceActual.ordenarPedidoProveedor("444123456");
        proveedorServiceActual.ordenarPedidoProveedor("123456789");
    }

}
