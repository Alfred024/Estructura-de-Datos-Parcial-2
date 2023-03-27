
package lista_estática_final;

public class Lista_Estática_Final {

    public static void main(String[] args) {
        
        //El out no toma en cuenta el caso que busques un dato que no está en la lista
        
        Lista x = new Lista(6);
        x.initialize();
        x.in(10);
        x.in(5);
        x.in(3);
        x.in(22);
        x.in(20);
        x.in(21);
        
        //x.out(3);
        x.in(8);

        System.out.println(x.datos[0]);
        System.out.println(x.datos[1]);
        System.out.println(x.datos[2]);
        System.out.println(x.datos[3]); 
        System.out.println(x.datos[4]);
        System.out.println(x.datos[5]);
        
        System.out.println("Start: "+x.start);
        System.out.println("End: "+x.end);
    }
    
}

class Lista {

    int datos[];
    int start, end, disponibles;

    public Lista(int size) {
        this.datos = new int[size];
        this.end = 0;
        this.start = 0;
        this.disponibles = size;
    }

    public void initialize() {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = -1;
        }
    }

    public void in(int toAdd) {
        if (hayEspacio()) {
            disponibles--;
            if (datos[start] == -1) {
                datos[start] = toAdd;
            }else {
                int posicionNuevoElemnto = buscarIndex(toAdd);
                if (posicionNuevoElemnto == start && start > 0) {
                    datos[start - 1] = toAdd;
                    start--;
                }
                if (datos[end] < toAdd && end != 0 && posicionNuevoElemnto == end && end < datos.length - 1) {
                    datos[end + 1] = toAdd;
                } 
                else {
                    int limiteSuperior = end;
                    if (casoAoB()) {
                        recorrerDatos(posicionNuevoElemnto, limiteSuperior + 1);
                    } else {
                        recorrerDatos(posicionNuevoElemnto, datos.length + 1);
                        recorrerDatos(posicionNuevoElemnto, limiteSuperior + 1);
                    }
                }
                datos[posicionNuevoElemnto] = toAdd;
                end++;
            }
        }else{
            System.out.println("Elemento " + toAdd + " no cabe en la lista");
        }
    }

    public int buscarIndex(int searched) {
        if (start == end) {
            return end;
        } else {
            int index = start;
            while (datos[index] != -1 && searched > datos[index]) {
                if (index == datos.length - 1) {
                    index = 0;
                } else {
                    index++;
                }
                /*if(datos[index] < datos[start] && datos[index] != -1){
                    datos[index] = -1;
                }*/
            }
            return index;
        }
    }

    //Caso A
    public void recorrerDatos(int posicionNuevoElemnto, int limiteSuperior) {
        int vueltas;
        if(limiteSuperior == datos.length){
            datos[0] = datos[end];
            limiteSuperior--;
        }
        for (vueltas = limiteSuperior; vueltas > posicionNuevoElemnto; vueltas--) {
            datos[vueltas] = datos[vueltas-1];
        }
    }
    
    public void recorrerDatos(int limiteSuperior) {
        int vueltas;
        for (vueltas = limiteSuperior; vueltas > 0; vueltas--) {
            datos[vueltas] = datos[vueltas-1];
        }
    }
    
    public void out(int toDelete){
        if(disponibles == datos.length){
            System.out.println("UNDERFLOW");
        }else{
            disponibles++;
            int posicionElemntoBorrar = buscarIndex(toDelete);
            if(posicionElemntoBorrar == start){
                datos[start] = -1;
                if(start == datos.length-1){
                    start = 0;
                }else{
                    start++;
                }
            }
            if(posicionElemntoBorrar == end){
                datos[end] = -1;
                if(end == 0){
                    end = datos.length-1;
                }else{
                    end--;
                }
            }
            else{
                //Evaluar por dónde será más rápido recorrer todos los datos, por el 
                //inicio al medio o el medio al final
                
                if(casoAoB()){
                    recorrerDatosToDelete(posicionElemntoBorrar);
                }else{
                    
                }
                datos[end--] = -1;
                //end--;
            }
        }
    }
    
    //Cumplir caso A y caso B
    public void recorrerDatosToDelete(int posicionElemntoBorrar){
        //Caso A
        int vueltas;
        for (vueltas = posicionElemntoBorrar; vueltas < datos.length-1; vueltas++) {
            datos[vueltas] = datos[vueltas+1];
        }
        /*if(datos[datos.length-1] != -1){
            datos[0] = datos[datos.length-1];
            end = 0;
        }
        
        //Caso B
        if(end > 0){
            for (vueltas = 1; vueltas < end; vueltas++) {
                datos[vueltas] = datos[vueltas+1];
            }
        }*/
    }
    
    public boolean casoAoB() {
        return start <= end;
    }

    public boolean hayEspacio() {
        return disponibles != 0;
    }
}