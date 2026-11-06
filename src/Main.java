
import java.io.File;
import view.MenuPrincipal;

public class Main {

    public static void main(String[] args) throws Exception {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        File archivo = new File("/home/kalendulaworks/Universidad/grupo10_papeleria_BD/src/data/clientex.txt");
       // escribir(archivo, "mememememememeememem",false);
       //escribir(archivo, "despedite de la paja harry potter", true);
         new ClaseDePruebaParaTenerStockYa(menuPrincipal.getStockService(),menuPrincipal.getProveedorService()).productosDePrueba();
         System.out.println(archivo.length());
        menuPrincipal.iniciar();

        //consulta para el viernes como funciona el metodo eliminar en las listasdobles
    }

    /*public static void escribir(File archivo, String texto, boolean agregar)throws IOException{
        File carpeta = archivo.getParentFile();
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        FileWriter escritor = new FileWriter(archivo , agregar);
        escritor.write(texto + "\n");
        escritor.close();
    }*/
    
}
