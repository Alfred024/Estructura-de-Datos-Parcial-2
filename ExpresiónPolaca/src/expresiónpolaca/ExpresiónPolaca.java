
package expresiónpolaca;



public class ExpresiónPolaca {

    public static void main(String[] args) {
        
        String infija = "(6+2)*3/2#2-4";
        Pila_Dinamica stack = new Pila_Dinamica();
        Pila_Dinamica jerarquias = new Pila_Dinamica();
        String res = "";
        // ¡ = raiz cuadrada
        // # = elevado a potencia 
        stack.showData();
        
        int ciclos;
        for (int i = 0; i < infija.length(); i++) {
            
            if(infija.charAt(i) >= 48 && infija.charAt(i)<= 57){
                res+= infija.charAt(i)+"";
            }else{
                
                //Si el stack no tiene nada, pushea al elemento sin comparar nada
                if(stack.tope == null){
                        if(")".equals(infija.charAt(i)+"")){
                            jerarquias.PUSH(3);
                            stack.PUSH(infija.charAt(i)+"");
                        }
                        if("#".equals(infija.charAt(i)+"") || "¡".equals(infija.charAt(i)+"")){
                            jerarquias.PUSH(2);
                            stack.PUSH(infija.charAt(i)+"");
                        }
                        if("*".equals(infija.charAt(i)+"") || "/".equals(infija.charAt(i)+"")){
                            jerarquias.PUSH(1);
                            stack.PUSH(infija.charAt(i)+"");
                        }
                        if(infija.charAt(i)+"" == "+" || infija.charAt(i)+"" == "-"){
                            jerarquias.PUSH(0);
                            stack.PUSH(infija.charAt(i)+"");
                        }
                        
                        jerarquias.showData();
                        stack.showData();
                }else{
                        if(")".equals(infija.charAt(i)+"")){
            jerarquias.PUSH(3);
            stack.PUSH(infija.charAt(i));
        }
        if("#".equals(infija.charAt(i)+"") || "¡".equals(infija.charAt(i)+"")){
            jerarquias.PUSH(2);
            stack.PUSH(infija.charAt(i));
        }
        if("*".equals(infija.charAt(i)+"") || "/".equals(infija.charAt(i)+"")){
            jerarquias.PUSH(1);
            stack.PUSH(infija.charAt(i));
        }
        if("+".equals(infija.charAt(i)) || "-".equals(infija.charAt(i)+"")){
            jerarquias.PUSH(0);
            stack.PUSH(infija.charAt(i));
        }
        
        //Si no solo hay un elemento
        if(stack.tope.next != null){
            //Si hay un elemento sí se podrá comparar
            
            //Si hay un paréntesis
            if((stack.tope.value).equals(")")){
                while(stack.tope != null){
                    res+=stack.POP();
                }jerarquias.FREE();
            }else{
                
                //Otras condiciones
                if(jerarquias.tope.jerarquia == jerarquias.tope.next.jerarquia){
                    Nodo aux = stack.tope;
                    stack.tope = stack.tope.next;
                    stack.tope.next = aux;
                    res+=stack.POP();
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
                        res+=stack.POP();
                    }jerarquias.FREE();
                    
                    stack.tope = auxOperando;
                    jerarquias.tope = auxJerar;
                    
                }
            }
            
            
        }
                        
                }
                        
                    
            }
            
            System.out.println("Vuelta #"+(i+1)+": "+res);
        }
        
        
        System.out.println("Resultado: "+res);
    }
    
    
    class ExpresionPolaca{
        Pila_Dinamica x;
    }
    
}
