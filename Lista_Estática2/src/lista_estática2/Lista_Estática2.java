
package lista_estática2;

public class Lista_Estática2 {

    public static void main(String[] args) {
        
        Lista lista = new Lista(6);
        lista.in(10); //lista.in(1);
        lista.showData();

    }
}

class Lista{

    int datos[];
    int start, end;
    int disponibles;

    public Lista(int size) {
        this.datos = new int[size];
        this.start = -1;
        this.end = -1;
        this.disponibles = size;
    }
    
    public void in(int value){
        if(hayEspacio()){
            disponibles--;
            if(start == end){
                datos[++end] = value;
                start++;
                
            }else{
                
                //CASO A
                //Index Start es menor que el End
                if(evaluaCaso()){
                    //Agregar antes del principio
                    if(value <= datos[start]){
                        if(start == 0){
                            recorrerDatosPrincipio();
                            datos[start] = value;
                        }else{
                            datos[--start] = value;
                        }
                    }
                    //Agregra un valor e nmedio
                    else{
                        recorrerDatosEnMedio(value);
                    } 
                    
                }
                
                
                //CASO B
                //Index End es menor que el Start
                else{
                    
                }
                
                
                
            }
        }else{
            System.out.println("OVERFLOW\n"
                    + "El dato "+value+" no pudo ser insertado");
        }
    }
    
    public boolean hayEspacio(){
        return disponibles != 0;
    }
    
    //Método para evaluar el índice, si es igual a datos.length-1, se transforma en 0
    //de otra forma, solo aumenta su valor
    
    //Para agregar al final o en medio
    public int evaluaIndex(int index){
        if(index == datos.length-1){
            return index;
        }else{
            return 0;
        }
    }
    
    public boolean evaluaCaso(){
        //True: Caso #1  
        return start <= end;
    }
    
    public int buscarIndex(int value){
        int indexPrev = start;
        System.out.println("ola");
        while(indexPrev<datos.length-1 && value > datos[indexPrev+1]){
            indexPrev++;
        }
        
        if(indexPrev+1 == datos.length-1){
            indexPrev++;
        }
        return indexPrev;
    }
    
    //Recorrer datos en caso de querer insertar un dato al principio del array
    public void recorrerDatosPrincipio(){
        int vueltas;
        if(evaluaCaso()){
            if(end != datos.length-1){
                for (vueltas = end; vueltas >= start; vueltas--) {
                    datos[vueltas+1] = datos[vueltas];
                }end++;
            }else{
                datos[0] = datos[end];
                for (vueltas = end-1; vueltas >= start; vueltas--) {
                    datos[vueltas+1] = datos[vueltas];
                }
            }
        }else{
            //CASO #2: End es menor que start
        }
        
    }
    
    public void recorrerDatosEnMedio(int value){
        int vueltas;
        
        if(evaluaCaso()){
            if(end < datos.length-1){
                for (vueltas = end; vueltas >= end-buscarIndex(start); vueltas--) {
                    datos[vueltas+1] = datos[vueltas];
                }datos[buscarIndex(value)+1] = value;
                end++;
            }else{
                if(end == datos.length-1){
                    if(buscarIndex(value) == end){
                        datos[0] = value;
                        end = 0;
                    }else{
                        datos[0] = datos[end];
                        end=0;
                        datos[datos.length-1] = value;
                    }
                }
            }
        }else{
            //CASO #2: End es menor que start
        }
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
