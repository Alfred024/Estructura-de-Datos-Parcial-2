
package arbol;

public class Arbol {

    public static void main(String[] args) {

        Tree nuevo2 = new Tree();
        nuevo2.add(10);
        nuevo2.add(20);
        nuevo2.add(5);
        nuevo2.add(3);
        nuevo2.add(6);
        nuevo2.add(9);
        nuevo2.add(7);
        nuevo2.add(8);
        nuevo2.delete(6);
        
        System.out.println("\nComprobación");
        System.out.println(nuevo2.raiz.value);//10
        System.out.println(nuevo2.raiz.der.value); //20
        System.out.println(nuevo2.raiz.izq.value); //5
        System.out.println(nuevo2.raiz.izq.izq.value); //3
        System.out.println(nuevo2.raiz.izq.der.value); //6
        System.out.println(nuevo2.raiz.izq.der.der.value); //9
        System.out.println(nuevo2.raiz.izq.der.der.izq.value); //7
        System.out.println(nuevo2.raiz.izq.der.der.izq.der.value); //8
    }
    
}

class Nodo{
    int value;
    Nodo der, izq;

    public Nodo(int value) {
        this.value = value;
        this.der = null;
        this.izq = null;
    }
}

class Tree{
    Nodo raiz;
    
    public void add(int value){
        Nodo newNodo = new Nodo(value);
        if(raiz == null){
            raiz = newNodo;
        }else{
            Nodo temp = buscarNodo(value);
            if(value <= temp.value){
                temp.izq = newNodo;
            }else{
                temp.der = newNodo;
            }
        }
    }
    
    public Nodo buscarNodo(int searched){
        Nodo aux = raiz;
        Nodo vigilante = null;
        while(aux != null){
            vigilante = aux;
            if(searched <= aux.value){
                aux = aux.izq;
            }else{
                aux = aux.der;
            }
        }
        return vigilante;
    }
    
    //Buscar para elimniar dato del árbol
    public Nodo buscarNodo2(int searched){
        Nodo aux = raiz;
        Nodo vigilante = null;
        while(aux.izq != null && aux.der != null){
            vigilante = aux;
            if(searched <= aux.value){
                aux = aux.izq;
            }else{
                aux = aux.der;
            }
        }
        return vigilante;
    }
    
    public Nodo buscarIzqoDer(int searched){
        System.out.println("lksdslkjal");
        Nodo temp2 = buscarNodo2(searched);
        System.out.println("Vigilante: "+temp2.value);
        Nodo res;
        
        if(searched <= temp2.value){
            temp2 = temp2.izq;
        }else{
            temp2 = temp2.der;
        }
        if(temp2.izq != null){
            temp2 = temp2.izq;
            while(temp2.der != null){
                temp2 = temp2.der;
            }res = temp2;
            if(temp2.izq != null){
                temp2 = temp2.izq;
                temp2.izq = null;
            }
        }else{
            temp2 = temp2.der;
            while(temp2.izq != null){
                temp2 = temp2.izq;
            }res = temp2;
            if(temp2.der != null){
                temp2 = temp2.der;
                temp2.der = null;
            }
        }
        return res;
    }
    
    public Nodo delete(int searched){
        
        Nodo temp = buscarNodo(searched);
        Nodo replace = buscarIzqoDer(searched);
        if(searched <= temp.value){
            temp.izq = replace;
        }else{
            temp.der = replace;
        }
        return temp;
    }
    
}
