
package expresiónpolaca;

public class Nodo {
    
    String value;
    int jerarquia;
    Nodo next;

    public Nodo(String value) {
        this.value = value;
        this.next = null;
    }
    
    public Nodo(int jerar) {
        this.next = null;
        this.jerarquia = jerar;
    }
}
