
package lista_circular;

public class Lista_Circular {

    public static void main(String[] args) {
        
        Lista lista = new Lista();
        lista.add(10); lista.add(1); lista.add(20); lista.add(5);lista.add(40);
        lista.delete(40);
        lista.showData();
        
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
    Nodo start, end;
    
    public void add(int value){
        Nodo newNodo = new Nodo(value);
        if(end == null){
            start = end = newNodo;
        }else{
            if(value <= start.value){
                end.next = newNodo;
                newNodo.next = start;
                start = newNodo;
            }else{
                Nodo temp = buscarPosicion(value);
                newNodo.next = temp.next;
                temp.next = newNodo;
                if(temp == end){
                    end = newNodo;
                }
            }
        }
    }
    
    public Nodo buscarPosicion(int searched){
        Nodo aux = start;
        while(aux.next != start && aux.next.value < searched){
            aux = aux.next;
        }
        return aux;
    }
    
    public Nodo delete(int searched){
        Nodo toDelete = start;
        if(searched == toDelete.value){
            end.next = start.next;
            start = end.next;
        }else{
            Nodo temp = buscarPosicion(searched);
            if(temp.next == end){
                end = temp;
            }
            temp.next = temp.next.next;
            
        }
        return null;
    }
    
    public void showData() {
        Nodo aux = start;
        if(start == end){
            System.out.print("[" + aux.value + "]--> ");
        }else{
            while (aux != end) {
                System.out.print("[" + aux.value + "]--> ");
                aux = aux.next;
            }System.out.print("[" + aux.value + "]--> ");
        }
        System.out.print("null\n");
    }
}
