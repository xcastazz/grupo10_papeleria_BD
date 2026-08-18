package func;

public class luafunc {

  public luafunc() {
    System.out.println("Funcs logicas iniciadas");
  }

  public static void wait(double secs) {
    try {
      Thread.sleep((long) secs);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
