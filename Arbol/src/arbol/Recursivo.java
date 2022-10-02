
package arbol;

public class Recursivo {
    public int sumaRecursiva(int B, int A){
        while(A > 0){
            int res = sumaRecursiva(B, A-1);
        }
        return 0;
    }
}
