
package cola_estática;

public class Cola_Estática {

    public static void main(String[] args) {
        
        Cola queues = new Cola(5);
        /*queues.add(10); queues.add(20); queues.add(30); 
        System.out.println("");
        queues.showData();
        
        queues.delete();queues.delete();
        System.out.println("");
        queues.showData();
        
        queues.add(100); queues.add(200); queues.add(300); 
        System.out.println("");
        queues.showData();*/
        
        queues.add(10); queues.add(20); queues.add(30);queues.add(100); queues.add(310); 
        queues.showData();
        
        System.out.println("\n\n");
        queues.delete();queues.delete();queues.delete();queues.delete(); 
        queues.showData();
        
        System.out.println("\n\n");
        queues.add(100); queues.add(3100); 
        queues.showData();
    }
    
}

class Cola{
    int cola[];
    int disponibles;
    int start, end;
    
    public Cola(int size){
        this.cola = new int[size];
        this.disponibles = size;
        this.start = 0;
        this.end = 0;
    }
    
    public void add(int value){
        //Si no está llena: 
        if(!llena()){
            if(end == cola.length){
                end = 0;
                cola[end] = value;
            }else{
                if(start == end){
                    cola[start] = value;
                    end++;
                }else{
                    if(end == 0){
                        cola[++end] = value;
                    }else{
                        cola[end++] = value;
                    }
                }
            }
            disponibles--;
        }else{
            System.out.println("OVERFLOW");
        }
        
    }
    
    public int delete(){
        int aux = cola[start];
        
        if(disponibles >= 0 && disponibles < cola.length){
            if(start == cola.length -1){
                //Si ya eliminó todos los datos
                if(end == cola.length){
                    start = end = 0;
                }else{
                    start = 0;
                }
            }else{
                start++;
            }
            disponibles++;
        }else{
            System.out.println("UNDERFLOW");
        }
        
        return aux;
        
    }
    
    public boolean llena(){
        return disponibles == 0;
    }
    
    public boolean vacia(){
        return start == end;
    }
    
    public void showData(){
        int startAux = start;
        System.out.println("Start: "+start+"\nEnd: "+end);
        if(end < start){
            System.out.println("Caso #2");
            System.out.print("Inicio -->");
            while(startAux < cola.length){
                System.out.print("["+cola[startAux++]+"]");
            }
            int vueltas = 0;
            while(vueltas <= end){
                System.out.print("["+cola[vueltas]+"]");
                vueltas++;
            }System.out.print("<-- Final");
            
        }else{
            System.out.println("Caso #1");
            System.out.print("Inicio -->");
            while(startAux < end){
                System.out.print("["+cola[startAux++]+"]");
            }System.out.print("<-- Final");
            
        }
        
    }
    
}
