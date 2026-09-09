package model.domain;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private String nombre;
    private String telefono;
    private String categoriaProductos;
    private List<Pedido> pedidos;


    public Proveedor(String nn, String ph, String cP){
        this.nombre = nn;
        this.telefono = ph;
        this.categoriaProductos = cP;
        this.pedidos = new ArrayList<>();
    }

    public String getProveedorNombre(){return nombre;}
    public String getProveedorTelefono(){return telefono;}
    public String getCategoria(){return categoriaProductos;}

    public void actualizarTelefono(String telefonoNuevo){
        this.telefono = telefonoNuevo;
    }

    public void registrarPedido(String estado){
        Pedido nuevaPedido = new Pedido(this, estado);
        agregarPedido(nuevaPedido);
    }

    private void agregarPedido(Pedido item) {
        this.pedidos.add(item);
    }

}
