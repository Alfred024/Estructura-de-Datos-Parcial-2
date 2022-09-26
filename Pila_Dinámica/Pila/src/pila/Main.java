
package pila;

import java.util.Stack;


public class Main {

    public static void main(String[] args) {
        
        Pila_Dinamica stack = new Pila_Dinamica();
        stack.PUSH(30); stack.PUSH(20); stack.PUSH(10); stack.PUSH(5);
        stack.POP();
        //stack.FREE();
        System.out.println("\nData: ");
        stack.showData();
        
        
        Stack<Nodo> pila = new Stack();
        Nodo pila1 = new Nodo(20);
        pila.add(0, pila1);
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


class Pila_Dinamica{
    Nodo tope;
    
    public void PUSH(int value){
        Nodo nuevoNodo = new Nodo(value);
        if(tope == null){
            tope = nuevoNodo;
        }else{
            nuevoNodo.next = tope;
            tope = nuevoNodo;
        }
    }
    
    public int POP(){
        if(tope == null){
            System.out.println("Pila vacía 2");
            return -1;
        }else{
            Nodo nodoPOP = tope;
            tope = tope.next;
            return nodoPOP.value;
        }
    }
    
    public void FREE(){
        do{
           System.out.println(tope.value);
           tope = tope.next;
        }while(tope != null);
    }
    
    public void showData(){
        if(tope == null){
            System.out.println("Pila vacía");
        }else{
            Nodo auxiliar = tope;
            
            while(auxiliar.next != null){
                System.out.println("["+auxiliar.value+"]");
                auxiliar = auxiliar.next;
            }System.out.println("["+auxiliar.value+"]");
        }
    }
    
}