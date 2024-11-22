/**
 * @author <b>Casula Carmelo 7085019</b>
 * @author <b>Zhunushov Sultan 7073339</b>
 * @version 1.0
 */
public class Nodo<T> {
    private T informazione;
    private int chiave;
    private Nodo<T> successivo;
    private Nodo<T> precedente;

    /**
     * @param x informazione
     * @param k chiave
     */
    public Nodo(T x, int k) {
        this.informazione = x;
        if (k >= 1 && k <= 10000000)
            this.chiave = k;
        this.successivo = null;
        this.precedente = null;
    }

    /**
     * @return informazioni del nodo
     */
    public String toString() {
        return "[" + informazione + "," + chiave + "]";
    }

    public T getInformazione() {
        return informazione;
    }

    public void setInformazione(T informazione) {
        this.informazione = informazione;
    }

    public Nodo<T> getSuccessivo() {
        return successivo;
    }

    public void setSuccessivo(Nodo<T> successivo) {
        this.successivo = successivo;
    }

    public Nodo<T> getPrecedente() {
        return precedente;
    }

    public void setPrecedente(Nodo<T> precedente) {
        this.precedente = precedente;
    }

    public int getChiave() {
        return chiave;
    }

    public void setChiave(int chiave) {
        this.chiave = chiave;
    }
}
