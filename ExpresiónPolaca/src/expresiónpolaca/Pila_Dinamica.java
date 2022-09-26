
package expresiónpolaca;

public class Pila_Dinamica {
    Nodo tope;
    
    public void PUSH(String value){
        Nodo nuevoNodo = new Nodo(value);
        if(tope == null){
            tope = nuevoNodo;
        }else{
            nuevoNodo.next = tope;
            tope = nuevoNodo;
        }
    }
    
    public void PUSH(int value){
        Nodo nuevoNodo = new Nodo(value);
        if(tope == null){
            tope = nuevoNodo;
        }else{
            nuevoNodo.next = tope;
            tope = nuevoNodo;
        }
    }
    
    public String POP(){
        if(tope == null){
            System.out.println("Pila vacía 2");
            return "null";
        }else{
            Nodo nodoPOP = tope;
            tope = tope.next;
            return nodoPOP.value;
        }
    }
    
    /*public int POP2(){
        if(tope == null){
            System.out.println("Pila vacía 2");
            return -1;
        }else{
            Nodo nodoPOP = tope;
            tope = tope.next;
            return nodoPOP.value;
        }
    }*/
    
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
