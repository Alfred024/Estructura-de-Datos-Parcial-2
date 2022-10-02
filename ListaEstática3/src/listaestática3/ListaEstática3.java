

package listaestática3;

public class ListaEstática3 {

    public static void main(String[] args) {
        Lista x = new Lista(6);
        x.in(10); x.in(20); x.in(15); x.in(17); x.in(1); //x.in(16);
        //x.out(1); x.out(10);
        
        x.showData();
    }
    
}

class Lista{

    int datos[];
    int disponibles;
    int start, end;

    public Lista(int size) {
        this.datos = new int[size];
        this.disponibles = size;
        this.start = 0;
        this.end = 0;
    }
    
    public void in(int newValue){
        if(disponibles == 0){
            System.out.println("OVERFLOW");
        }else{
            disponibles--;
            recorrerDatos(newValue);
            if(end == datos.length-1 && datos[end] != 0){
                end = 0;
            }
        }
    }
    
    public void out(int outValue){
        if(disponibles != datos.length){
            disponibles++;
            if(outValue == datos[start]){
                start++;
            }else{
                recorrerDatosToDelete(outValue);
            }
        }else{
            System.out.println("UNDERFLOW");
        }
    }
    
    public void recorrerDatosToDelete(int outValue){
        if(casoAoB()){
            int indexToDelete=buscarIndex(outValue);
            int vueltas;
            for (vueltas = indexToDelete; vueltas < end; vueltas++) {
                datos[vueltas] = datos[vueltas+1];
            }end--;
        }
        
        else{
            
        }
    }
    
    public void recorrerDatos(int searched){
        if(casoAoB()){
            int vueltas;
            int limite = end;
            int indexOfnewElement = buscarIndex(searched);
            for (vueltas = buscarIndex(searched); vueltas <= limite; limite--) {
                if(end == datos.length-1 && disponibles == 0){
                    datos[limite] = datos[limite-1];
                    limite--;
                    end--;
                }else{
                    datos[limite+1] = datos[limite];
                }
            }
            datos[indexOfnewElement] = searched;
            
            end++;
        }
        
        else{
            
        }
    }
    
    //La posición exacta de dónde deberá ir el elemento a insertar
    public int buscarIndex(int searched){
        if(start == end){
            return start;
        }else{
            int index=start;
            while(searched > datos[index] && datos[index] != 0){
                if(index == datos.length-1){
                    index = 0;
                }else{
                    index++;
                }
            }
            return index;
        }
    }
    
    //Caso A: El start está antes del end
    //Caso B: El start está después del end
    public boolean casoAoB(){
        return start <= end;
    }
    
    public void showData(){
        System.out.println("Start: "+start+"\nEnd: "+end);
        System.out.println("Disponibles: "+disponibles);
        if(casoAoB()){
            System.out.println("CASO A");
            int vuelta = start;
            System.out.println("\nLista: ");
            while(vuelta <= end){
                System.out.print("["+datos[vuelta]+"]");
                vuelta++;
            }
        }else{
            System.out.println("CASO B");
        }
        
    }
}


            /*System.out.println("A insertar: "+searched);
            System.out.println("LI: "+buscarIndex(searched));
            System.out.println("LS: "+limite);*/