

package listaestática3;

public class ListaEstática3 {

    public static void main(String[] args) {
        Lista x = new Lista(7);
        x.in(10); x.in(20); x.in(15); x.in(25); x.in(30); x.in(5); x.in(35);
        x.out(5); x.out(10); x.out(15);
        x.in(36); //x.in(5);System.out.print(x.datos[1]+" ");
        System.out.print(x.datos[2]+" ");System.out.print(x.datos[3]+" ");
        System.out.print(x.datos[4]+" ");System.out.print(x.datos[5]+" ");
        System.out.print(x.datos[6]+" ");System.out.print(x.datos[0]+" ");
        


        //x.in(5); 
        /*System.out.print(x.datos[2]+" ");System.out.print(x.datos[3]+" ");
        System.out.print(x.datos[4]+" ");System.out.print(x.datos[5]+" ");
        System.out.print(x.datos[6]+" ");System.out.print(x.datos[0]+" ");
        System.out.println("End: "+x.end);*/
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
            
            if(end == datos.length-1 && datos[end] != 0 && start != 0){
                end = 0;
                recorrerDatos(newValue);
            }else{
                recorrerDatos(newValue);
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
        
        //CASO B
        else{
            System.out.println("I: "+buscarIndex(searched));
            System.out.println("Dato a agregar: "+searched);
            
            if(end == buscarIndex(searched)){
                datos[buscarIndex(searched)] = searched;
            }
            if(start == buscarIndex(searched)){
                datos[start-1] = searched;
                start--;
            }
            
            
            /*int vueltas=0;
            if(end == start-1){
                datos[end] = datos[datos.length-1];
            }else{
                datos[vueltas+1] = datos[vueltas];
            }
            
            
            //Primero da una vuelta del start al final del array
            int indexOfnewElement = buscarIndex(searched);
            
            
            
            int limite = datos.length-1;
            
            for (vueltas = indexOfnewElement; vueltas <= limite; limite--) {
                if(end == 0){
                    datos[end] = datos[datos.length-1];
                }else{
                    datos[limite+1] = datos[limite];
                }
            }
            
            //Y luego tienen que dar otra vuelta del principio al final del array
            for (vueltas = end; vueltas > 0; vueltas--) {
                if(end == start-1){
                    datos[end] = datos[datos.length-1];
                }else{
                    datos[vueltas+1] = datos[vueltas];
                }
            }
            
            datos[indexOfnewElement] = searched;*/
            end++;
        }
    }
    
    //La posición exacta de dónde deberá ir el elemento a insertar
    public int buscarIndex(int searched){
        if(start == end){
            return start;
        }else{
            int index=start;
            while(datos[index] != 0 && searched > datos[index]){
                if(index == datos.length-1){
                    index = 0;
                }else{
                    index++;
                }
                
                if(datos[index] < datos[start] && datos[index] != 0){
                    index = 0;
                    datos[index] = 0;
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
            System.out.println("Impresión de datos pendiente");
        }
        
    }
}


            /*System.out.println("A insertar: "+searched);
            System.out.println("LI: "+buscarIndex(searched));
            System.out.println("LS: "+limite);*/