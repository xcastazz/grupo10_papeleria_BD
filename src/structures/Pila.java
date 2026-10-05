package structures;


public class Pila<T>{
    private Nodo<T> tope;
    private int size;

    public Pila(){
        this.tope =  null;
        this.size = 0;
    }

    public void push(T dato){
        Nodo nuevoDato = new Nodo<T>(dato);
        if (this.tope != null) {
            nuevoDato.setSiguiente(nuevoDato);
            this.tope = nuevoDato;
            this.size++;
        }
        this.size++;
        this.tope = nuevoDato;
    }

    public Nodo<T> pop(){
        if (this.tope == null) {
            System.out.println("La pila no tiene elementos");
        }
        Nodo<T> auxiliar = this.tope.getSiguiente();
        this.tope.setSiguiente(null);
        this.tope = auxiliar;
        return auxiliar;
        
    }

    public Nodo<T> peek(){
        if (this.tope == null) {
            System.out.println("La pila no tiene elementos");
        }
        return this.tope;
    }

    public boolean isEmpty(){
        return this.tope == null;
    }

    public int getSize() {
        return size;
    }

}