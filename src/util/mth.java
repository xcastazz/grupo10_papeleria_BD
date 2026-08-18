package util;

import java.util.concurrent.TimeUnit;

import func.luafunc;

public class mth {
  private boolean debug = true;

  public mth() {
    System.out.println("Math Iniciada");

    if (debug) {
      debugPrint();
    }

  }

  // Solo para debug ojo, metodos privados para prueba
  private void debugger(int val, int v1, int v2) {
    if (debug) {
      System.out.println("Exito, valor retornado de V1: " + v1 +
          " Y V2:" + v2 + " Es: " + val);
    }
  }

  private void debugger(double val, double v1, double v2) {
    if (debug) {
      System.out.println("Exito, valor retornado de V1: " + v1 +
          " Y V2:" + v2 + " Es: " + val);
    }
  }

  public int glamp(int val1, int val2) {
    int res = val1 - val2;
    if (res < 0) {
      System.out.print("Saldo insuficiente");
      return -1;
    }
    debugger(res, val1, val2);
    return res;

  }

  public double glamp(double val1, double val2) {
    double res = val1 - val2;
    if (res < 0) {
      System.out.print("Saldo insuficiente");
      return -1;
    }
    debugger(res, val1, val2);
    return res;
  }

  public void debugPrint() {
    int debug = 0;
    System.out.println("Se va a probar glamp porque si");
    do {
      double testval1 = (Math.random() * 101);
      double testval2 = (Math.random() * 101);

      System.out.println("Probando glamp");
      double res = glamp(testval1, testval2);

      if (res != -1 && res >= 0) {
        debug = debug++;
        System.out.println("Exito, va " + debug + " de 120");
      }
    } while (debug < 120);

  }

}
