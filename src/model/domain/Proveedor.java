package model.domain;

import structures.ListaSimple;

public class Proveedor {
    private String nombre;
    private String telefono;
    private String categoriaProductos;
    private ListaSimple<Pedido> PedidosLista;


    public Proveedor(String NombreProveedor, String TelefonoProveedor, String CategoriaProductos){
        this.nombre = NombreProveedor;
        this.telefono = TelefonoProveedor;
        this.categoriaProductos = CategoriaProductos;
        this.PedidosLista = new ListaSimple<>();
    }

    public void imprimirInfo(){
        System.out.println("Nombre : " + getProveedorNombre());
        System.out.println("Telefono : " + getProveedorTelefono());
        System.out.println("Categoria : " + getCategoria());
    }


    public String getProveedorNombre(){return nombre;}
    public String getProveedorTelefono(){return telefono;}
    public String getCategoria(){return categoriaProductos;}

    public void actualizarNombre(String nombreNuevo){
        this.nombre = nombreNuevo;
    }

    public void actualizarTelefono(String telefonoNuevo){
        this.telefono = telefonoNuevo;
    }
    public void actualizarCategoria(String categoriaNueva){
        this.categoriaProductos = categoriaNueva;
    }

    public void registrarPedido(String estado){
        Pedido nuevaPedido = new Pedido(this, estado);
        PedidosLista.insertarInicio(nuevaPedido);
    }

    public Pedido getPedidosLista() {
        if (!PedidosLista.estaVacia()) {
            return PedidosLista.getHead().getDato();
        } else {
            System.out.println("Proveedor Sin Pedidos");
            return null;
        }
        
    }

}
