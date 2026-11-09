package services;
import java.io.*;
import model.domain.*;
import model.structures.ListaDoble;
import model.structures.NodoDoble;

public class CatalogoService {
    // Dentro de ProductoService (ajuste los nombres a su dominio)
// Imports necesarios: model.domain.CatalogoProductos y model.domain.ProductoBancario

// Un solo catálogo por Service: si se creara uno nuevo en cada método,
// cada operación vería una lista distinta
    private static final String ARCHIVO_CATALOGO = "data/catalogo.txt";
    private static final String SEPARADOR = ";";
    private final CatalogoNavegable catalogo = new CatalogoNavegable("Catálogo de productos");
    private ListaDoble<Producto> listaCatalogo = catalogo.getProductos();

    public CatalogoService(){
        cargarProductos();
    }


    public void registrarProducto(int tipo,String codigo, String nombre, double precio, int cantidadStock, String Categoria) {
        Producto NuevoProductoCatalogo;
        
    // TODO 1: crear el ProductoBancario con sus cuatro campos
        switch (tipo) {
            case 1:
                NuevoProductoCatalogo = registrarProductoEscolar(codigo, nombre, precio, cantidadStock, Categoria);
                listaCatalogo.insertarAlFinal(NuevoProductoCatalogo);
                break;
            case 2:
                NuevoProductoCatalogo = registrarProductoOficina(codigo, nombre, precio, cantidadStock, Categoria);
                listaCatalogo.insertarAlFinal(NuevoProductoCatalogo);
                break;
            default:
                System.out.println("Error en CatalogoService intentando registrar producto a catalogo");
                break;
        }
        persistir();
    // TODO 2: insertarlo al final de la lista
    }

    private Producto registrarProductoEscolar(String codigo, String nombre, double precio, int cantidadStock, String nivelEscolar){
        Producto Nuevo = new ProductoEscolar(codigo, nombre, precio, cantidadStock, nivelEscolar);
        return Nuevo;
    }

    private  Producto registrarProductoOficina(String codigo, String nombre, double precio, int cantidadStock, String categoria){
        Producto Nuevo = new ProductoOficina(codigo, nombre, precio, cantidadStock, categoria);
        return Nuevo;
    }

    public String listarProductosEnOrdenInverso() {
        if (listaCatalogo.isEmpty()) {
            return ("No hay productos en el catálogo");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(listaCatalogo.recorrerAtras());
        // TODO 1: si la lista está vacía, devolver "No hay productos en el catálogo"
        // TODO 2: devolver lo que arma recorrerAtras de la lista (un producto por línea)
        //         -- ProductoBancario debe sobrescribir toString para que cada línea se lea bien
        return sb.toString(); // reemplazar
    }

    public int contarProductos(){
        if (listaCatalogo.isEmpty()) {
            System.out.println("llamado desde contar productos: No hay productos en el catálogo");
            return listaCatalogo.size();
        } else {
            return listaCatalogo.size();
        }
    }

    public String listarProductosEnOrden() {
        if (listaCatalogo.isEmpty()) {
            return ("No hay productos en el catálogo");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(listaCatalogo.recorrerAdelante());
        // TODO 1: si la lista está vacía, devolver "No hay productos en el catálogo"
        // TODO 2: devolver lo que arma recorrerAtras de la lista (un producto por línea)
        //         -- ProductoBancario debe sobrescribir toString para que cada línea se lea bien
        return sb.toString(); // reemplazar
    }

    public Producto verProductoAnterior() {
        Producto productoAnterior = listaCatalogo.anterior();
            System.out.println("---- Producto Anterior ----");
            System.out.println("Código : " + productoAnterior.getCodigo());
            System.out.println("Nombre : " + productoAnterior.getNombre());
            System.out.println("Precio : " + productoAnterior.getPrecio());
            System.out.println("Stock : " + productoAnterior.getStock());
            System.out.println("---------------------------");
        // TODO 1: pedir a la lista (catalogo.getProductos()) el anterior con anterior() y devolverlo
        //         -- el cursor vive en la lista: el Service no guarda posiciones
        return productoAnterior; // reemplazar
    }

    public Producto verProductoSiguiente() {
        Producto productoSiguiente = listaCatalogo.siguiente();
            System.out.println("---- Producto Siguiente ----");
            System.out.println("Código : " + productoSiguiente.getCodigo());
            System.out.println("Nombre : " + productoSiguiente.getNombre());
            System.out.println("Precio : " + productoSiguiente.getPrecio());
            System.out.println("Stock : " + productoSiguiente.getStock());
            System.out.println("---------------------------");
        // TODO 1: pedir a la lista (catalogo.getProductos()) el anterior con anterior() y devolverlo
        //         -- el cursor vive en la lista: el Service no guarda posiciones
        return productoSiguiente; // reemplazar
    }

    public Producto retirarProducto() {
        Producto productoARetirar = listaCatalogo.retirarActual();
        // TODO 1: retirar de la lista el producto que se está mirando con retirarActual()
        //         (sin producto seleccionado deja salir NoSuchElementException: no la atrape aquí)
        // TODO 2: devolver el producto retirado
        return productoARetirar; // reemplazar
    }

    public boolean estaVacioCatalogo(){
        return listaCatalogo.isEmpty();
    }

    public boolean hayProductoAnterior() {
        return listaCatalogo.hayAnterior();
    }

    public boolean hayProductoSiguiente() {
        return listaCatalogo.haySiguiente();
    }
    
    public String cargarProductos() {
        File archivo = new File(ARCHIVO_CATALOGO);


        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(SEPARADOR);
                if (campos.length != 6) {
                    continue;
                }
                switch (campos[0]) {
                    case "1":
                        registrarProducto(1,campos[1], campos[2],Double.parseDouble(campos[3]),Integer.parseInt(campos[4]),campos[5]);
                        break;
                    case "2":
                        registrarProducto(2,campos[1], campos[2],Double.parseDouble(campos[3]),Integer.parseInt(campos[4]),campos[5]);
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            return "No existe " + ARCHIVO_CATALOGO + "; se inicia con la lista de productos en el stock vacía";
        } catch (IOException e) {
            return "No se pudo leer: " + e.getMessage();
        }
        return "Se cargaron " + listaCatalogo.size() + " productos en el catalogo. "; // las cuentas cuelgan de sus clientes
    }

    public void persistir() {
        try {
            escribirProductos();
        } catch (IOException e) {
            System.out.println("No se pudieron guardar los productos del catalogo en el archivo: " + e.getMessage());
        }
    }


    private void escribirProductos() throws IOException {
        File carpeta = new File(ARCHIVO_CATALOGO).getParentFile();
        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }

        String texto = "";
        NodoDoble<Producto> actual = listaCatalogo.getHead();
        while (actual != null) {
            Producto productoActual = actual.getDato();
            if (productoActual instanceof ProductoEscolar) {
                texto += String.join(SEPARADOR,
                    String.valueOf("1"),
                    productoActual.getCodigo(),
                    productoActual.getNombre(),
                    String.valueOf(productoActual.getPrecio()),
                    String.valueOf(productoActual.getStock()),
                    String.valueOf(((ProductoEscolar) productoActual).getNivelEscolar())) + "\n";
            } else if (productoActual instanceof ProductoOficina) {
                texto += String.join(SEPARADOR,
                    String.valueOf("2"),
                    productoActual.getCodigo(),
                    productoActual.getNombre(),
                    String.valueOf(productoActual.getPrecio()),
                    String.valueOf(productoActual.getStock()),
                    String.valueOf(((ProductoOficina) productoActual).getCategoria())) + "\n";
            }
            
            actual = actual.getSiguiente();
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARCHIVO_CATALOGO))) {
            escritor.write(texto);
        }
    }


}
