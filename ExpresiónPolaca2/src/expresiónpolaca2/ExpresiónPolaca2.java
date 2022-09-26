
package expresiónpolaca2;


public class ExpresiónPolaca2 {

    public static void main(String[] args) {
        
        String expresion = "(6+2)*3/2#2-4";
        Pila stack = new Pila();
        Pila jerarquias = new Pila();
        
        ExpresionesAritmeticas obj = new ExpresionesAritmeticas(stack, jerarquias);
        obj.expresionApostfija(expresion);
    }
    
}

class ExpresionesAritmeticas{
    
    Pila stack = new Pila();
    Pila jerarquias = new Pila();

    public ExpresionesAritmeticas(Pila stack, Pila jerarquias) {
        this.stack = stack;
        this.jerarquias = jerarquias;
    }

    public void expresionApostfija(String expresion){
        String res="";
        int ciclos;
        
        for (ciclos = 1; ciclos < expresion.length(); ciclos++) {
            System.out.println("Vuelta #"+(ciclos+1)+"\nExpresion: "+res);
            if(expresion.charAt(ciclos) >= 48 && expresion.charAt(ciclos)<= 57){
                res+= expresion.charAt(ciclos)+"";
            }else{
                res+=evaluacionOperadores(ciclos, expresion);
            }
        }
        
    }
    
    public String evaluacionOperadores(int index, String expresion){
        String operador="";
        //Hace un PUSH solo de la jerarquía
        if(")".equals(expresion.charAt(index)+"")){
            jerarquias.PUSH(3);
            stack.PUSH(expresion.charAt(index)+"");
        }
        if("#".equals(expresion.charAt(index)+"") || "¡".equals(expresion.charAt(index)+"")){
            jerarquias.PUSH(2);
            stack.PUSH(expresion.charAt(index)+"");
        }
        if("*".equals(expresion.charAt(index)+"") || "/".equals(expresion.charAt(index)+"")){
            jerarquias.PUSH(1);
            stack.PUSH(expresion.charAt(index)+"");
        }
        if("+".equals(expresion.charAt(index)) || "-".equals(expresion.charAt(index)+"")){
            jerarquias.PUSH(0);
            stack.PUSH(expresion.charAt(index)+"");
        }
        
        System.out.println("DATOS: ");
        stack.showData();
        jerarquias.showData();
        
        if(stack.tope.next != null){
            if((stack.tope.value).equals(")")){
                while(stack.tope != null){
                    operador+=stack.POP();
                }jerarquias.FREE();
            }else{
                
                if(jerarquias.tope.jerarquia == jerarquias.tope.next.jerarquia){
                    Nodo aux = stack.tope;
                    stack.tope = stack.tope.next;
                    stack.tope.next = aux;
                    operador+=stack.POP();
                    jerarquias.POP();
                }
                
                if(jerarquias.tope.jerarquia > jerarquias.tope.next.jerarquia){
                    //Se queda igual
                }
                
                if(jerarquias.tope.jerarquia < jerarquias.tope.next.jerarquia){
                    Nodo auxOperando = stack.tope;
                    Nodo auxJerar = jerarquias.tope;
                    
                    stack.tope = stack.tope.next;
                    while(stack != null){
                        operador+=stack.POP();
                    }jerarquias.FREE();
                    
                    stack.tope = auxOperando;
                    jerarquias.tope = auxJerar;
                    
                }
            }
            
            
        }
        
        return operador;
    }
    
    
}