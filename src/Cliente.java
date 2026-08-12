
public class Cliente {
  String nombre;
  int identificacion;
  double saldo;

  public Cliente(String nm, int id, double bal){
  this.nombre = nm;
  this.identificacion = id;
  this.saldo = bal;
  }

  public void mostrarInfo() {
    System.out.println(nombre + " " + identificacion + " " + saldo);
  }
}
