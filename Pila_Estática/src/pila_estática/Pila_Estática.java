
package pila_estática;

public class Pila_Estática {

    public static void main(String[] args) {
        
        Pila newStack = new Pila(4);
        
        newStack.PUSH(10); newStack.PUSH(8); newStack.PUSH(4); newStack.PUSH(1); newStack.PUSH(100);
        newStack.showData();
    }
    
}

class Pila{
	int top;
	int size;
        int pila[];

	Pila(int size){
            this.pila = new int[size];
            this.top = 0;
	}

	public void PUSH(int value){
            if(top < pila.length){
		pila[top] = value;
		top++;
            }else{
                System.out.println("OVERFLOW");
            }
	}

	public void POP(){
            if(top > 0){
		System.out.println("Elemento "+pila[top-1]+" eliminado del Stack");
                top--;
       	    }else{
		System.out.println("UNDERFLOW");
            }
	}

	public void FREE(){
            while(top > 0){
		System.out.println("Elemento "+pila[--top]+" eliminado del Stack");
	    }
	}
        
        public void showData(){
            if(top != 0){
                while(top > 0){
                    top--;
                    System.out.println("["+pila[top]+"]");
                }
            }else{
                System.out.println("Pila Vacía");
            }
        }
        
}