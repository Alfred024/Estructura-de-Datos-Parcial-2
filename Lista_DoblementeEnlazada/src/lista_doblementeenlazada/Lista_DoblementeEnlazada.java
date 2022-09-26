
package lista_doblementeenlazada;

public class Lista_DoblementeEnlazada {

    public static void main(String[] args) {
        
        Lista lista = new Lista();
        lista.add(10); lista.add(100); lista.add(1);  lista.add(1000); lista.add(500);
        lista.delete(1001); 
        lista.showData();
    }
    
}

class Nodo{
    int value;
    Nodo next, prev;

    public Nodo(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class Lista{
    Nodo start, end;
    
    public void add(int value){
        Nodo newNodo = new Nodo(value);
        if(start == null){
            start = end = newNodo;
        }else{
            
            if(value<=start.value){
                start.prev = newNodo;
                newNodo.next = start;
                start = newNodo;
            }else{
                Nodo temp = buscarNodo(value);
                
                if(temp == end){
                    temp.next = newNodo;
                    newNodo.prev = temp;
                    end = newNodo;
                }else{
                    newNodo.next = temp.next;
                    temp.next.prev = newNodo;
                    newNodo.prev = temp;
                    temp.next = newNodo;
                }
            }
        }
    }
    
    public Nodo buscarNodo(int searched){
        Nodo aux = start;
        while(aux.next != null && aux.next.value < searched){
            aux = aux.next;
        }
        return aux;
    }
    
    public Nodo delete(int searched){
        try{
            Nodo toDelete = start;
            if(searched == toDelete.value){
                toDelete.next.prev = null;
                start = start.next;
            }else{
                Nodo temp = buscarNodo(searched);
                if(temp.next == end){
                    temp.next = null;
                    end.prev = null;
                    end = temp;
                }else{
                    temp.next = temp.next.next;
                    temp.next.prev = temp;
                }
            }
            return toDelete;
        }catch(NullPointerException e){
            System.out.println("Elemento "+searched+" no encontrado en la lista");
            return null;
        }
    }
    
    public void showData(){
        Nodo aux = start;
        System.out.print("null ");
        while(aux != null){
            System.out.print("<--["+aux.value+"]--> ");
            aux = aux.next;
        }System.out.print("null\n");
    }
}