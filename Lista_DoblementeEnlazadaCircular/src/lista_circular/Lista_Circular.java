package lista_circular;

public class Lista_Circular {

    public static void main(String[] args) {

        
        //NOTAAAA: Esto se convirtión en una lista circular doblemento enlazada
        Lista listaA = new Lista();
        listaA.add(10); listaA.add(20); listaA.add(15); listaA.add(1); listaA.add(7); listaA.add(6); listaA.add(9); listaA.add(11);listaA.add(100); listaA.add(90);
        listaA.showData();
        
        listaA.delete(100); 
        //listaA.delete(11);
        listaA.delete(1);
                listaA.showData();
        
        /*System.out.println("\n\n");
        System.out.println(listaA.start.value);
        System.out.println(listaA.end.value);
        System.out.println(listaA.end.next.value);
        System.out.println(listaA.start.prev.value);*/

    }
}

class Nodo {
    int value;
    Nodo next, prev;

    public Nodo(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

//Lista circular Doblemente enlazada
class Lista {

    Nodo start, end;

    public void add(int value) {
        Nodo newNodo = new Nodo(value);
        if (start == null) {
            start = end = newNodo;
            end.next = end.prev = start;
            start.prev = start.next = end;
        }else {
            if(value <= start.value){
                newNodo.next = start;
                newNodo.prev = end;
                start.prev = newNodo;
                end.next = newNodo;
                start = newNodo;
            }else{
                Nodo temp = buscarPosicion(value);
                if(temp == end) {
                    temp.next = newNodo;
                    newNodo.prev = newNodo.next = temp;
                    end.prev = newNodo;
                    end = newNodo;
                } else {
                    newNodo.next = temp.next;
                    temp.next = newNodo;
                    newNodo.prev = temp;
                    newNodo.next.prev = newNodo;
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
            end.next.prev = end;
            start = end.next;
        }else{
            Nodo temp = buscarPosicion(searched);
            if(temp.next == end){
                temp.next = start;
                start.prev = temp;
                end = temp;
            }else{
                temp.next = temp.next.next;
                temp.next.prev = temp;
            }
        }
        return toDelete;
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
