
package árbolbinario;

public class ÁrbolBinario {

    public static void main(String[] args) {
        Arbol x = new Arbol();
        x.in(100);x.in(50); x.in(45); x.in(55); x.in(53); x.in(40);
        x.in(42); x.in(41); x.in(44);
        
        
        x.out(45);
        
        System.out.println(x.raiz.value); //100
        System.out.println(x.raiz.izq.value); //50
        System.out.println(x.raiz.izq.izq.value); //44
        System.out.println(x.raiz.izq.der.value); //55
        System.out.println(x.raiz.izq.der.izq.value); //53
        System.out.println(x.raiz.izq.izq.izq.value); //40
        System.out.println(x.raiz.izq.izq.izq.der.value); //42
        System.out.println(x.raiz.izq.izq.izq.der.izq.value); //41
    }
    
}

class Nodo{
    int value;
    Nodo izq, der;

    public Nodo(int value) {
        this.value = value;
        this.izq = null;
        this.der = null;
    }
    
}

class Arbol{
    Nodo raiz;
    
    public void in(int value){
        Nodo newNodo = new Nodo(value);
        if(raiz == null){
            raiz = newNodo;
        }else{
            //El temporal se coloca un nodo antes de aquel nodo al que borraremos
            Nodo temp = buscarPosicion(value);
            if(value < temp.value){
                temp.izq = newNodo;
            }else{
                temp.der = newNodo;
            }
        }
    }
    
    public Nodo buscarPosicion(int searched){
        Nodo aux = raiz;
        Nodo vigilante = null;
        while(aux != null && aux.value != searched){
            vigilante = aux;
            if(searched < aux.value){
                aux = aux.izq;
            }else{
                aux = aux.der;
            }
        }
        return vigilante;
    }
    
    
    public void out(int toDelete){
        if(raiz == null){
            System.out.println("UNDERFLOW");
        }else{
            boolean res; 
            //False= Izquierda //True: Derecha
            Nodo temp = buscarPosicion(toDelete);
            Nodo aux = temp;
            if(toDelete < temp.value){
                aux = aux.izq;
            }else{
                aux = aux.der;
            }
            
            //CASO #1: El que se eliminará no tiene hijos
            if(aux.izq == null && aux.der == null){
                if(toDelete < temp.value){
                    temp.izq = null;
                }else{
                    temp.der = null;
                }
            }
            
            //CASO #2: Sí tiene uno o más hijos
            else{
                if(aux.izq != null){
                    res = false;
                    temp.izq.value = buscarIzqoDer(aux, res);
                }else{
                    res = true;
                    temp.der.value = buscarIzqoDer(aux, res);
                }
            }
        }
    }
    
    public Nodo borradoSimple(){
        return null;
    }
    
    public int buscarIzqoDer(Nodo padre, boolean izqOder){
        Nodo res = padre;
        Nodo vigilante = null;
        if(!izqOder){
            res = res.izq;
            while(res.der != null){
                if(res.der.der == null){
                    vigilante = res;
                }
                res = res.der;
            } 
            vigilante.der = null;
        }else{
            res = res.der;
            while(res.izq != null){
                res = res.der;
                if(res.izq.izq == null){
                    vigilante = res;
                }
            } 
            vigilante.izq = null;
        }
        return res.value;
    }
    
}



