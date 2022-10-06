/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista_estática_final;

/**
 *
 * @author solid
 */
public class Lista_Estática_Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista x = new Lista(6);
        x.initialize();
        x.in(10);
        x.in(5);
        x.in(3);
        x.in(22);
        x.in(20);
        x.in(21);

        /*Primer elemento--->*/
        System.out.println(x.datos[0]);
        /*Segundo elemento--->*/
        System.out.println(x.datos[1]);
        /*Tercer elemento--->*/
        System.out.println(x.datos[2]);
        /*Cuarto elemento--->*/
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
            } else {
                int posicionNuevoElemnto = buscarIndex(toAdd);

                if (posicionNuevoElemnto == start && start > 0) {
                    datos[start - 1] = toAdd;
                    start--;
                }

                if (datos[end] < toAdd && end != 0 && posicionNuevoElemnto == end && end < datos.length - 1) {
                    datos[end + 1] = toAdd;
                } 
                
                //Si no pueden cumplirse niguna de las anteriores, a fuerzas tendrá que hacer recorridos
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
        } else {
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
    
    public void recorrerDatosToDelete(){
        
    }
    
    public boolean casoAoB() {
        return start <= end;
    }

    public boolean hayEspacio() {
        return disponibles != 0;
    }
}