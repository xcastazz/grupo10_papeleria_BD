package structures;

import utils.ConsoleUtils;

public class ListaDoble<T> {
    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int tamanio;

    public ListaDoble(){
        this.head = null;
        this.tail = null;
        this.tamanio = 0;
    }

    public boolean  estaVacia(){
        return head == null;
    }

    public int getTamano(){
        return this.tamanio;
    }

    public void insertarFinal(T dato){
        NodoDoble<T> nuevo = new NodoDoble<T>(dato);

        if (estaVacia()) {
            head = nuevo;
        } else {
            tail.setSiguiente(nuevo);
            nuevo.setAnterior(tail);
        }
        tail = nuevo;
        this.tamanio++;
    }

    public void insertarInicio(T dato){
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (estaVacia()) {
            head = nuevo;
        }
        nuevo.setSiguiente(head);
        head.setAnterior(nuevo);
        nuevo.setSiguiente(head);
        head = nuevo;
        this.tamanio++;
    }

    public void recorrerInverso(){
        NodoDoble<T> nodoActual = tail;
        while (nodoActual != null) {
            System.out.println(nodoActual.getDato());
            nodoActual = nodoActual.getAnterior();
        }
    }

    public void menuRecorrer(){
        String opcion;
        NodoDoble<T> nodoActual = head;
        System.out.println(nodoActual.getDato());
        do { 
            opcion = ConsoleUtils.leerTexto("opciones \nsiguiente(s) \nanterior(a) \nsalir(e)");
            switch (opcion) {
                case "s":
                if (nodoActual.getSiguiente() != null) {
                    System.out.println(nodoActual.getSiguiente().getDato());
                    nodoActual = nodoActual.getSiguiente();
                } else {
                    System.out.println("Llego al final " + nodoActual.getDato());
                }
                break;
                case "a":
                if (nodoActual.getAnterior() != null) {
                    System.out.println(nodoActual.getAnterior().getDato());
                    nodoActual = nodoActual.getAnterior();
                } else {
                    System.out.println("Llego al final "+ nodoActual.getDato());
                }
                    break;
                default:
                    break;
            }
        } while (opcion != "e");
    }

    public NodoDoble<T> buscar(T dato){
        NodoDoble<T> actual = head;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

}