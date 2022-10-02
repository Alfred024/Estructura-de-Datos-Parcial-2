
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
    
    
    //Falta contemplar el caso de la eliminación de la raíz
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
    
    //Método ejecutado si se cumple el caso #2
    //Caso #2: Evaluará primero si se puede ir por la izquierda, si hay hijos en la rama izquierda
    //este será el camino que siga, lo que significa que buscará el elemento mayor de dicho camino, en caso
    //de que no tenga nodos en el lado izquierdo, evaluará los de la derecha, en el que buscará al nodo con menor valor
    
    //El método cumple la función de desenlazar aquel al que ocuparemos como reemplazo, y de retornar el valor 
    //para reemplazarlo en el lugar que le corresponde, no sin antes destruir el enlace de aquel que será el reemplazo
    
    
    public int buscarIzqoDer(Nodo padre, boolean izqOder){
        Nodo res = padre;
        Nodo vigilante = null;
        if(!izqOder){
            //BUusca el elemento más grande en la rama izquierda (Antecesor)
            res = res.izq;
            while(res.der != null){
                if(res.der.der == null){
                    vigilante = res;
                }
                res = res.der;
            } 
            vigilante.der = null;
        }else{
            //BUusca el elemento más pequeño en la rama derecha (Postdecesrorr)
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



