
package lista_estática;

public class Lista_Estática {

    public static void main(String[] args) {
        
        Lista lista = new Lista(6);
        lista.in(10);  lista.in(30); lista.in(20); lista.in(5); lista.in(15);  lista.in(50); //lista.in(23); caso Overflow
        
        //lista.in(5);
        lista.showData();
        
        
    }
    
}

class Lista{
    int start, end;
    int datos[];
    int disponibles;

    public Lista(int size) {
        this.start = 0;
        this.end = 0;
        this.datos = new int[size];
        this.disponibles = size;
    }
    
    public void out(int searched){
        
        if(disponibles != datos.length){
            if(datos[start] == searched){
                ++start;
            }else{
                int toDelete = buscarParaBorrar(searched);
                int vueltas;
                for (vueltas = toDelete; vueltas < end; vueltas++) {
                    datos[vueltas] = datos[vueltas+1];
                }end--;
            }
        }
        
        disponibles++;
    }
    
    public void in(int value){
        if(llena()){
            System.out.println("Elemento "+value+" imposible de agregar");
            System.out.println("Lista sin espacio disponible");
        }else{
            disponibles--;
            boolean caso1 = true;
            
            //NO hay ningún elemento en el array
            if(start == end){
                datos[start] = value;
                end++;
            }
            
            else{
                //Dos casos, si índice start está ante sde end
                
                if(caso1){
                    /*if(end == datos.length-1){
                        caso1 = false;
                        System.out.println("ola");
                        end =0;
                    }*/
                    
                    if(caso1){
                        if(value <= datos[start]){
                            recorrerDatos2(value);
                        }
                        else{
                            if(end == datos.length-1){
                                recorrerDatos(value, end-1);
                            }else{
                                recorrerDatos(value, end);
                            }
                        }
                    }
                    
                }else{
                    System.out.println("olaa");
                    if(value <= datos[start]){
                        datos[--start] = value;
                    }else{
                        
                    }
                }
                
            }
            
        }
    }
    
    public void recorrerDatos(int value, int endAux){
        int index = buscarPosicion(value);
        int ciclos;
        for (ciclos = endAux; ciclos > index; ciclos--) {
            datos[ciclos+1] = datos[ciclos];
        }
        if(end != datos.length -1){
            end++;
        }
        datos[++index] = value;
    }
    
    public void recorrerDatos2(int value){
        int ciclos;
        for (ciclos = end-1; ciclos >= 0; ciclos--) {
            datos[ciclos+1] = datos[ciclos];
        }
        if(end != datos.length -1){
            end++;
        }
        datos[++ciclos] = value;
    }
    
    public int buscarPosicion(int searched){
        int posicion = 0;
        while(end < datos.length && datos[posicion+1] != 0 && datos[posicion+1] < searched){
            posicion++;
        }
        return posicion;
    }
    
    public int buscarParaBorrar(int toDelete){
        int index = 0;
        while(datos[index] != toDelete){
            index++;
        }
        return index;
    }
    
    //Si retorna true, se ejecutará el caso #1: El start está antes del fin
    //De lo contrrario, se ejecurta el caso #2: Fin antes que el principio/ end < start
    public boolean casosIndex(){
        return start <= end;
    }
    
    
    public boolean llena(){
        return disponibles == 0;
    }
    
    public void showData(){
        System.out.println("Start: "+start+"\nEnd: "+end);
        System.out.println("Disponibles: "+disponibles);
        int vuelta = start;
        System.out.println("\nLista: ");
        while(vuelta <= end){
            System.out.print("["+datos[vuelta]+"]");
            vuelta++;
        }
        
    }
}

