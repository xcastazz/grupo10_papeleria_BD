import java.util.ArrayList;
import java.util.Scanner;
import model.domain.*;

public class PruebaCreacionObjetos {
    
    private ArrayList<Object[]> matrizStock;
    private ArrayList<Object[]> matrizProveedor;
    private static Scanner sc = new Scanner(System.in);

    //{O|O|O|O|O|O|O|O|O||}

    public PruebaCreacionObjetos() {
        this.matrizStock = new ArrayList<>();
        this.matrizProveedor = new ArrayList<>();
        mostrarMenu();
    }

    private void mostrarMenu(){
        int Opcion;
        do { 
            String hub = " Menu Principal "+
                         "\n 1. Registrar Producto"+
                         "\n 2. Revisar Productos"+
                         "\n 3. Iniciar Venta"+
                         "\n 4. Administras Proveedores."+
                         "\n 5. Salir.";
            System.out.println(hub);
            Opcion = sc.nextInt();
            sc.nextLine();

            switch (Opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    revisarProductos();
                    break;
                case 3:
                    iniciarVenta();
                case 4:
                    adminProveedor();
                    break;
                case 5:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Intente nuevamente opcion no valida");
            }
        } while (Opcion != 5);
    }

    private void adminProveedor(){
        int type;
        String nombreProveedor,celularProveedor,categoriaProveedor;
        System.out.println("Ingrese el tipo opcion a realizar"+
                            "\n[1] Registrar Proveedor [2] Actualizar Telefono [3] Ver Proveedores [4] Salir");
        type = sc.nextInt();
        sc.nextLine();
        switch (type) {
            case 1:
                System.out.println("Ingrese el nombre del proveedor");
                nombreProveedor = sc.nextLine();
                System.out.println("Ingrese el Telefono Celular del Proveedor");
                celularProveedor = sc.nextLine();
                System.out.println("Ingrese la categoría de productos del proveedor");
                categoriaProveedor = sc.nextLine();
                Proveedor Nuevo = new Proveedor(nombreProveedor, celularProveedor, categoriaProveedor);
                Nuevo.registrarPedido("Recien Creado, pedido de prueba"); // pedido de prueba
                Object[] Proveedor = new  Object[]{Nuevo};
                matrizProveedor.add(Proveedor);
                break;
            case 2:
                System.out.println("Ingrese el nombre del proveedor a realizar la actualizacion");
                nombreProveedor = sc.nextLine();
                System.out.println("Ingrese el Telefono Celular del Proveedor a actualizar");
                celularProveedor = sc.nextLine();
                Proveedor reemplazo = buscarProveedor(nombreProveedor);
                reemplazo.actualizarTelefono(celularProveedor);
                System.out.println("Telefono actualizado a "+reemplazo.getProveedorTelefono()+" Para Proveedor"+ reemplazo.getProveedorNombre());
                break;
            case 3:
                revisarProveedores();
                break;
            case 4:
                System.out.println("Volviendo al menù");
                break;
            default:
                throw new AssertionError();
        }

    }


          

    private void iniciarVenta(){
        String prodnom;
        Producto p;
        int cantidadP;
        System.out.println("Ingrese el producto a buscar");
        prodnom = sc.nextLine();
        sc.nextLine();
        System.out.println("Ingrese la cantidad de ese producto");
        cantidadP = sc.nextInt();
        p = buscarProducto(prodnom);
        if (p != null) {
            Venta v = new Venta();
            v.encargarItem(p, cantidadP);
        }
    }


    private Producto buscarProducto(String nombre) {
        for (Object[] fila : matrizStock) {
            Producto p = (Producto) fila[0];
            if (p.getNombre().equals(nombre)) {
                return p;
            }
        }
        System.out.println("Producto no encontrado en el stock");
        return null;
    }

    private Proveedor buscarProveedor(String nombre) {
        for (Object[] Proveedor : matrizProveedor) {
            Proveedor p = (Proveedor) Proveedor[0];
            if (p.getProveedorNombre().equals(nombre)) {
                return p;
            }
        }
        System.out.println("Proveedor no encontrado");
        return null;
    }


    private void registrarProducto(){
        int type = 0;
        String cod,nom,niv;
        double precio;
        int cantidadStock;

        System.out.println("Ingrese el tipo de producto que desea registrar"+
                            "\n[1] Producto Escolar [2] Producto Oficina");
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

    private void revisarProveedores() {
        if (matrizProveedor.isEmpty()) {
            System.out.println("No hay proveedores registrados");
            return;
        }

        System.out.println("===     Contactos      ===");
        for (Object[] Proveedor : matrizProveedor) {
            Proveedor p = (Proveedor) Proveedor[0];
        System.out.println("Nombre : " + p.getProveedorNombre());
        System.out.println("Celular : " + p.getProveedorTelefono());
        System.out.println("Categoria : " + p.getCategoria());
        System.out.println("---------------------------");
    }
}


}
