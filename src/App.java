import func.*;
import java.util.Scanner;
import stock.Stock_manager;
import util.*;

public class App {
  
  //Variables y objetos a crear

    public static luafunc Lua = new luafunc();
    public static mth Math = new mth();
    private static Stock_manager gestor = new Stock_manager(Math); //Se crea el stock manager con las matematicas de arriba
    private static boolean debug = false; //Activar true para pruebas
    private static Scanner sc = new Scanner(System.in);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public static void main(String[] args) throws Exception {
    System.out.print("Cargando Assets");

    if (debug) {
    registroPrueba();
    ventaPrueba();
    }

  }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //pruebas para el debug
  private static void registroPrueba(){
    System.out.println("Prueba de registro de producto\n A continuacion ingrese Nombre, Precio, ID y Stock");
    String nombre = sc.nextLine();
    int precio = sc.nextInt();
    int stockID = sc.nextInt();
    int stockQU = sc.nextInt();
    sc.nextLine();
    gestor.registrarProducto(nombre, precio, stockID, stockQU);
  }

  private static void ventaPrueba(){
    System.out.println("Prueba de venta, a continuacion nombre y cantidad del producto a comprar");
    String producto = sc.nextLine();
    int stockQU = sc.nextInt();
    gestor.ventaYStock(producto, stockQU);
  }
/////////////////////////////////////////////////////////////////////////////////////////////////////

  //getters
  public mth getMath(){
    return Math;
  }
  public luafunc getLua(){
    return Lua;
  }

}
