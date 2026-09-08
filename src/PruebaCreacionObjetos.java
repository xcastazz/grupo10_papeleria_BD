import java.util.ArrayList;
import java.util.Scanner;
import model.domain.*;

public class PruebaCreacionObjetos {
    
    private ArrayList<Object[]> matrizStock;
    private static Scanner sc = new Scanner(System.in);


    public PruebaCreacionObjetos() {
        this.matrizStock = new ArrayList<>();
        registrarProducto();
        registrarProducto();
        revisarProductos();
    }
      
    private void registrarProducto(){
        int type = 0;
        String cod,nom,niv;
        double precio;
        int cantidadStock;

        System.out.println("Ingrese el tipo de producto que desea registrar");
        type = sc.nextInt();
        sc.nextLine();
        switch (type) {
            case 1:
                System.out.println("Digite el codigo");
                cod = sc.nextLine();
                System.out.println("Digite el nombre");
                nom = sc.nextLine();
                System.out.println("Digite el precio");
                precio = sc.nextDouble();
                System.out.println("Digite el stock");
                cantidadStock = sc.nextInt();
                System.out.println("Digite el nivel escolar");
                sc.nextLine();
                niv = sc.nextLine();
                registrarProductoEscolar(cod,nom,precio,cantidadStock,niv);
                break;
            case 2:
                System.out.println("A continuacion digite el codigo, nombre, precio, cantidad y categoria");
                System.out.println("Digite el codigo");
                cod = sc.nextLine();
                System.out.println("Digite el nombre");
                nom = sc.nextLine();
                System.out.println("Digite el precio");
                precio = sc.nextDouble();
                System.out.println("Digite el stock");
                cantidadStock = sc.nextInt();
                System.out.println("Digite la categoria");
                sc.nextLine();
                niv = sc.nextLine();
                registrarProductoOficina(cod,nom,precio,cantidadStock,niv);
                break;
            default:
                System.out.println("Opcion invalida");
                return;
        }
    }

    private void registrarProductoEscolar(String codigo, String nombre, double precio, int cantidadStock, String nivelEscolar){
        Producto Nuevo = new ProductoEscolar(codigo, nombre, precio, cantidadStock, nivelEscolar);
        Object[] fila = new  Object[]{Nuevo};
        matrizStock.add(fila);

        //Solo para debug, esto imprime para ver lo que registra en pruebas
        System.out.println("Producto registrado con exito. con los siguientes \n parametros: \n Nombre: "
                            +Nuevo.getNombre()+"\n Precio: "+Nuevo.getPrecio()+
                            "\n Stock ID: "+Nuevo.getCodigo()+
                            "\n con stock de: "+Nuevo.getStock()+
                            "\n con nivel escolar de:"+nivelEscolar);
    }

    private void registrarProductoOficina(String codigo, String nombre, double precio, int cantidadStock, String categoria){
        Producto Nuevo = new ProductoOficina(codigo, nombre, precio, cantidadStock, categoria);
        Object[] fila = new  Object[]{Nuevo};
        matrizStock.add(fila);

        //Solo para debug, esto imprime para ver lo que registra en pruebas
        System.out.println("Producto registrado con exito. con los siguientes \n parametros: \n Nombre: "
                            +Nuevo.getNombre()+"\n Precio: "+Nuevo.getPrecio()+
                            "\n Stock ID: "+Nuevo.getCodigo()+
                            "\n con stock de: "+Nuevo.getStock()+
                            "\n con nivel escolar de:"+categoria);
    }


    private void revisarProductos() {
        if (matrizStock.isEmpty()) {
            System.out.println("No hay productos registrados");
            return;
        }

        System.out.println("===        Stock        ===");
        for (Object[] fila : matrizStock) {
            Producto p = (Producto) fila[0];
        System.out.println("Código : " + p.getCodigo());
        System.out.println("Nombre : " + p.getNombre());
        System.out.println("Precio : " + p.getPrecio());
        System.out.println("Stock : " + p.getStock());
        System.out.println("---------------------------");
    }
}


}
