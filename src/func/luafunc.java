package func;

public class luafunc {

  public luafunc() {
    System.out.println("Funcs logicas iniciadas");
  }

  //metodo estatico wait que se llama para esperar por cierto tiempo durante
  // una accion basicamente se llama para que espere por double segundos
  public static void wait(double secs) {
    try {
      Thread.sleep((long) secs * 1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
  
}
