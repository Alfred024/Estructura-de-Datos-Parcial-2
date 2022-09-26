
package cola_estática.pkg2;

public class Cola_Estática2 {

    public static void main(String[] args) {
        
        Cola queues = new Cola(5);
        queues.PUSH(10); queues.PUSH(20); queues.PUSH(30);queues.PUSH(100); queues.PUSH(310); 
        queues.showData();
        
        queues.POP(); queues.POP(); queues.POP();  
        queues.PUSH(210); queues.PUSH(2110); 
        //queues.PUSH(310); 
        queues.showData();
        
        /*System.out.println("\n\n");
        queues.POP();queues.POP();queues.POP();queues.POP(); 
        queues.showData();
        
        System.out.println("\nDisponibles: "+queues.disponibles);
        
        System.out.println("\n\n");
        queues.PUSH(100); queues.PUSH(3100); 
        queues.showData();*/
        
    }
    
}

class Cola{
    
    int datos[];
    int start, end;
    int disponibles;
    boolean empty;

    public Cola(int size) {
        this.datos = new int[size];
        this.start = this.end = 0;
        this.disponibles = size;
    }
    
    public void PUSH(int value){
        if(disponibles > 0){
            if(end != datos.length){
                if(start == end){
                    datos[start] = value;
                    end++;
                }else{
                    datos[end++] = value;
                }
            }else{
                end = 0;
                datos[end] = value;
            }disponibles--;
        }else{
            System.out.println("OVERFLOW");
        }
    }
    
    public void POP(){
        if(disponibles < datos.length ){
            if(start == end){
                System.out.println("Pop: "+datos[start]);
                empty = true;
            }else{
                if(start == datos.length-1){
                    start = 0;
                }else{
                    start++;
                }
            }disponibles++;
        }else{
            
        }
    }
    
    public void showData(){
        
        if(disponibles == datos.length){
            System.out.println("Start: "+start+"\nEnd: "+end+"\nDisponibles: "+disponibles);
            System.out.println("EMPTY");
        }else{
            int startAux = start;
            System.out.println("Start: "+start+"\nEnd: "+end+"\nDisponibles: "+disponibles);
            System.out.println("");
            if(end < start){
                System.out.println("Caso #2");
                System.out.print("Inicio -->");
                while(startAux < datos.length){
                    System.out.print("["+datos[startAux++]+"]");
                }
                int vueltas = 0;
                while(vueltas <= end){
                    System.out.print("["+datos[vueltas]+"]");
                    vueltas++;
                }System.out.print("<-- Final\n");

            }else{
                System.out.println("Caso #1");
                System.out.print("Inicio -->");
                while(startAux < end){
                    System.out.print("["+datos[startAux++]+"]");
                }System.out.print("<-- Final\n");

            }
        }
    }
}
