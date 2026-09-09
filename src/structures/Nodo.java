package structures;

public class Nodo<T> {
    private T dato;
    private Nodo siguiente; // un nodo tiene un dato y un apuntador, almacena un objetos, cuando tiene <T> indica que es un atributo que tiene cualquier tipo de objeto
    //Atributo siguiente hace referencia a un apuntador referente a otro nodo, el tipo de dato tiene que ser Nodo, dos atributos basicos de un Nodo

    public Nodo(T dato){
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    

}
