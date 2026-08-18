import util.*;
import func.*;

public class App {

  public static void main(String[] args) throws Exception {
    System.out.print("Cargando Assets");
    luafunc Lua = new luafunc();
    mth Math = new mth();
    Cliente maria = new Cliente("Maria", 1245, 200000);
    Cliente carlos = new Cliente("Carlos", 1245, 80000);
    maria.mostrarInfo();
    carlos.mostrarInfo();
  }
}
