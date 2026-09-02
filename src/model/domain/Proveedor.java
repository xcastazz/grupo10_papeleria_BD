package model.domain;

public class Proveedor {
    private String nombre;
    private String telefono;
    private String categoriaProductos;

    public Proveedor(String nn, String ph, String cP){
        this.nombre = nn;
        this.telefono = ph;
        this.categoriaProductos = cP;
    }

    public String getProveedorNombre(){return nombre;}
    public String getProveedorTelefono(){return telefono;}
    public String getCategoria(){return categoriaProductos;}

    public void actualizarTelefono(String telefonoNuevo){
        this.telefono = telefonoNuevo;
    }

}
