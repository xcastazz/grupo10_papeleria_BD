package structures;

public class ListaSimple<T> {
    private Nodo<T> head;
    private int tamano;

    public ListaSimple(){
        this.head = null;
        this.tamano = 0;
    }

    public boolean estaVacia(){
        return  head == null;
    }

    public int getTamano(){
        return  tamano;
    }

    

}
