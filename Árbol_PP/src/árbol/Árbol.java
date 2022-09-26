/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package árbol;

public class Árbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*Arbol nuevo = new Arbol();
        nuevo.insertar(10);
        nuevo.insertar(20);
        nuevo.insertar(5);
        nuevo.insertar(3);
        nuevo.insertar(6);
        nuevo.insertar(9); 
        System.out.println("Raíz: " + nuevo.raiz.value);
        System.out.println("Raíz Izq: " + nuevo.raiz.izq.value);
        System.out.println("Raíz Der: " + nuevo.raiz.der.value);
        System.out.println("Raíz iZQ iZQ: " + nuevo.raiz.izq.izq.value);
        System.out.println("Raíz iZQ DER: " + nuevo.raiz.izq.der.value);
        System.out.println(nuevo.raiz.izq.der.der.value);*/
        
        System.out.println("---------------------->");
        
        Arbol nuevo2 = new Arbol();
        nuevo2.insertar2(10);
        nuevo2.insertar2(20);
        /*nuevo2.insertar2(5);
        nuevo2.insertar2(3);
        nuevo2.insertar2(6);
        nuevo2.insertar2(9); nuevo2.insertar2(7); nuevo2.insertar2(8);
        System.out.println("Raíz: " + nuevo2.raiz.value);
        System.out.println("Raíz Izq: " + nuevo2.raiz.izq.value);
        System.out.println("Raíz Der: " + nuevo2.raiz.der.value);
        System.out.println("Raíz iZQ iZQ: " + nuevo2.raiz.izq.izq.value);
        System.out.println("Raíz iZQ DER: " + nuevo2.raiz.izq.der.value);
        System.out.println(nuevo2.raiz.izq.der.der.value);
        System.out.println(nuevo2.raiz.izq.der.der.izq.value);
        System.out.println(nuevo2.raiz.izq.der.der.der.value);*/
        
        
        
    }

}

class Nodo {

    Nodo izq, der;
    int value;

    public Nodo(int value) {
        this.izq = this.der = null;
        this.value = value;
    }
}

class Arbol {

    Nodo raiz;

    public void insertar(int value) {
        Nodo newNodo = new Nodo(value);
        if (raiz == null) {
            raiz = newNodo;
        } else {
            Nodo temp = buscarNodo(value);
            if (temp.value < value) {
                temp.der = newNodo;
            } else {
                temp.izq = newNodo;
            }
        }
    }
    
    public Nodo buscarNodo(int searched) {
        Nodo aux = raiz;
        while (aux.der != null && aux.izq != null) {
            if (searched <= aux.value) {
                aux = aux.izq;
            } else {
                aux = aux.der;
            }
        }
        return aux;
    }
    
    public void insertar2(int value){
        Nodo newNodo = new Nodo(value);
        if(raiz == null){
            raiz = newNodo;
        }else{
            Nodo temp = buscarNodo2(value);
            System.out.println("Valor antecesor: "+temp.value);
            
            if(value <= temp.value){
                temp = temp.izq;
                if(temp.value <= value){
                    temp.izq = newNodo;
                }else{
                    temp.der = newNodo;
                }
            }else{
                temp = temp.der;
                if(temp.value <= value){
                    temp.izq = newNodo;
                }else{
                    temp.der = newNodo;
                }
            }
        }
    }
    
    public Nodo buscarNodo2(int searched){
        Nodo vigilante = raiz;
        Nodo aux = raiz;
        while (aux.der != null && aux.izq != null) {
            vigilante = raiz;
            if (searched <= aux.value) {
                aux = aux.izq;
            } else {
                aux = aux.der;
            }
        }
        return vigilante;
    }
    
    
    
    public void delete(int searched){
        Nodo beforeDelete = buscarNodo2(searched);
        if(raiz == null){
            System.out.println("UNDERFLOW/No hay elementos en el árbol");
        }else{
            
        }
    }

}
