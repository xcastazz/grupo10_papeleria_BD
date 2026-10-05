package model.domain;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private String nombre;
    private String telefono;
    private String categoriaProductos;


    public Proveedor(String NombreProveedor, String TelefonoProveedor, String CategoriaProductos){
        this.nombre = NombreProveedor;
        this.telefono = TelefonoProveedor;
        this.categoriaProductos = CategoriaProductos;
        new Pedido(this, "Recien creado");
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
    }

}
