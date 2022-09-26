
package colas;

public class Colas {

    public static void main(String[] args) {
        
        Cola nuevaCola = new Cola();
        nuevaCola.add(10); nuevaCola.add(1); nuevaCola.add(4); nuevaCola.add(2); nuevaCola.add(20); nuevaCola.add(201);
        nuevaCola.delete(); nuevaCola.delete();
        nuevaCola.showData();
    }
    
}

class Nodo{
    int value;
    Nodo next;

    public Nodo(int value) {
        this.value = value;
        this.next = null;
    }
}

//FORMA #1
class Cola{
    Nodo start;
    Nodo end;

    public Cola() {
        this.start = null;
        this.end = null;
    }
    
    public void add(int value){
        Nodo nuevoNodo = new Nodo(value);
        
        if(start == null){
            start = end = nuevoNodo;
        }else{
            end.next = nuevoNodo;
            end = nuevoNodo;
        }
    }
    
    public Nodo delete(){
        if(start == null){
            return null;
        }else{
            Nodo temp = start;
            start = start.next;
            return temp;
        }
    }
    
    public void showData(){
        Nodo auxiliar = start;
        
        System.out.print("Inicio --> ");
        while(auxiliar != null){
            System.out.print("["+auxiliar.value+"]");
            auxiliar = auxiliar.next;
        }System.out.println(" <-- Fin|");
    }
    
}

//FORMA #2
class Cola2{
    Nodo start;

    public Cola() {
        this.start = null;
    }
    
    public void add(int value){
        Nodo nuevoNodo = new Nodo(value);
        
        if(start == null){
            start = nuevoNodo;
        }else{
            Nodo aux = start;
            while(aux != null){
                aux = aux.next;
            }aux = nuevoNodo;
        }
    }
    
    public Nodo delete(){
        if(start == null){
            return null;
        }else{
            Nodo temp = start;
            start = start.next;
            return temp;
        }
    }
    
    public void showData(){
        Nodo auxiliar = start;
        
        System.out.print("Inicio --> ");
        while(auxiliar != null){
            System.out.print("["+auxiliar.value+"]");
            auxiliar = auxiliar.next;
        }System.out.println(" <-- Fin|");
    }
    
}

