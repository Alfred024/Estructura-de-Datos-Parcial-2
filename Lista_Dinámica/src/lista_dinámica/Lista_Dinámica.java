
package lista_dinámica;

public class Lista_Dinámica {
    public static void main(String[] args) {
        Lista listaChida = new Lista();
        
        listaChida.add(100);listaChida.add(10); listaChida.add(20); listaChida.add(30);
        listaChida.add(1); listaChida.add(50);
        listaChida.delete(100); listaChida.delete(1000);
        
        listaChida.showData();
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

class Lista{
    Nodo start;
    
    public void add(int value){
        Nodo temp = new Nodo(value);
        if(start == null){
            start = temp;
        }else{
            if(value < start.value){
                temp.next = start;
                start = temp;
            }else{
                Nodo aux = buscarPosicion2(value);
                temp.next = aux.next;
                aux.next = temp;
            }
        }
    }
    
    //Para acomodar una lista en orden ascendente
    public Nodo buscarPosicion(int searched){
        Nodo aux = start;
        while(aux.next != null && aux.next.value <= searched){
            aux = aux.next;
        }
        return aux;
    }
    
    //Este método lo hice yo
    public Nodo buscarPosicion2(int searched){
        Nodo aux = start;
        while(searched > aux.next.value){
            aux = aux.next;
        }
        return aux;
    }
    
    public Nodo delete(int value){
        Nodo aux = start;
        if(value < aux.value){
            System.out.println("Elemento "+value+" no se encuentra en la lista");
            return null;
        }else{
            try{
                while(aux.next.value != value){
                aux = aux.next;
                }
                aux.next = aux.next.next;
                return aux;
            }catch(NullPointerException error){
                System.out.println("Elemento "+value+" no se encuentra en la lista");
            }
            return null;
        }
    }
    
    public void showData(){
        Nodo aux = start;
        while(aux != null){
            System.out.print("["+aux.value+"]--> ");
            aux = aux.next;
        }System.out.print("null\n");
    }
}