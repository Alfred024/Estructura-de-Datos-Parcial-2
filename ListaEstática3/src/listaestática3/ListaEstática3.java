

package listaestática3;

public class ListaEstática3 {

    public static void main(String[] args) {
        Lista x = new Lista(7);
        x.in(10); x.in(20); x.in(15); x.in(25); x.in(30); x.in(5); x.in(35);
        x.out(5); x.out(10); x.out(15);
        x.in(36); //x.in(28);
        
        System.out.print(x.datos[3]+" ");
        System.out.print(x.datos[4]+" ");System.out.print(x.datos[5]+" ");
        System.out.print(x.datos[6]+" ");System.out.print(x.datos[0]+" "); System.out.print(x.datos[1]+" "); 
        System.out.println("\n");
        System.out.println("End: "+x.end);
        System.out.println("Disponibles: "+x.disponibles);
        
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
            
            //Si el dato a insertar es menor a el que está en el principio
            if(datos[buscarIndex(newValue)] <= datos[start]){
                datos[start-1] = newValue;
                start--;
            }else{
                //Esta condicional no shará saltar del caso A al caso B
                if(end == datos.length-1 && datos[end] != 0 && start != 0){
                    end = 0;
                    recorrerDatos(newValue);
                }else{
                    recorrerDatos(newValue);
                }
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
        int vueltas;
        int limite = end;
        if(casoAoB()){
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
            while(datos[index] != 0 && searched > datos[index]){
                if(index == datos.length-1){
                    index = 0;
                }else{
                    index++;
                }
                if(datos[index] < datos[start] && datos[index] != 0){
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

/*

else{
            System.out.println("Dato a agregar: "+searched);
            System.out.println("Dónde irá: "+buscarIndex(searched));
            //Caso 1: El dato irá al final 
            if(end == buscarIndex(searched)){
                datos[buscarIndex(searched)] = searched;
            }else{
                //Caso 2: El dato irá al principio de la lista (nuevo start
                if(start == buscarIndex(searched)){
                    datos[start-1] = searched;
                    start--;
                }else{
                    int indexOfnewElement=buscarIndex(searched);
                    //Caso 3: El dato nuevo irá en medio del array
                    
                    //Primero recorre los elementos del final a 0
                    int vueltas;
                    for (vueltas = end; vueltas > 0; vueltas--) {
                        if(end == start-1){
                            
                        }else{
                            datos[vueltas+1] = datos[vueltas];
                        }
                    }
                    //Agarra el último elemnto de la lista y lo pasa al principio, para que no se pierda dicho elemento
                    datos[0] = datos[datos.length-1];
                    
                    //Luego recorre los elemntos del final real de la lista 
                    //hasta el punto donde se insertará el nuevoElemento
                    for (vueltas = end; vueltas > 0; vueltas--) {
                        datos[vueltas+1] = datos[vueltas];
                    }
                    datos[indexOfnewElement] = searched;
                }
            }
            end++;
        }
*/