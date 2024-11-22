import java.util.Arrays;

/**
 * @author <b>Casula Carmelo 7085019</b>
 * @author <b>Zhunushov Sultan 7073339</b>
 * @version 1.0
 */
public class CatenaDoppia<T> {
    private Nodo<T> head;

    /**
     * @return numero elementi catena
     */
    public int numeroElementi() {
        if (head == null)
            return 0;
        Nodo<T> successivo = head.getSuccessivo();
        int numeroElementi = 1;
        while (successivo != head) {
            numeroElementi++;
            successivo = successivo.getSuccessivo();
        }
        return numeroElementi;
    }

    /**
     * @return l'head della catena
     */
    public Nodo<T> getHead() {
        return head;
    }

    /**
     * @return l'ultimo nodo della catena
     */
    public Nodo<T> getUltimoNodo() {
        if (catenaVuota()) return null;
        return head.getPrecedente();
    }

    /**
     * Controllo se la catena è vuota
     * @return true se è vuota
     */
    public boolean catenaVuota() {
        return numeroElementi() == 0;
    }

    /**
     * @param i-esimo nodo da restituire
     * @return i-esimo nodo della catena
     */
    public Nodo<T> getNodoSpecifico(int i) {
        if (i > numeroElementi() || i < 1) return null;
        else {
            Nodo<T> corrente = head;
            for (int j = 0; j < i - 1; j++) corrente = corrente.getSuccessivo();
            return corrente;
        }
    }

    /**
     * @param k serve per eliminare il nodo con la chiave k
     */
    public void eliminaNodo(int k) {
        if (numeroElementi() == 1)
            head = null;
        else if (numeroElementi() > 1) {
            Nodo<T> successivo = head, precedente = head;
            boolean esisteNodo = false;
            while (successivo.getSuccessivo() != head && !esisteNodo) {
                if (precedente.getChiave() == k) {
                    azzeraNodo(precedente);
                    esisteNodo = true;
                }
                if (successivo.getChiave() == k) {
                    azzeraNodo(successivo);
                    esisteNodo = true;
                }
                precedente = precedente.getPrecedente();
                successivo = successivo.getSuccessivo();
            }
        }
    }

    /**
     * Metodo ausiliario utilizzato per l'eliminazione del nodo;
     *
     * @param nodo serve per collegare il nodo precedente del nodo da eliminare con il nodo successivo
     */
    public void azzeraNodo(Nodo<T> nodo) {
        if (nodo == head) head = head.getSuccessivo();
        nodo.getPrecedente().setSuccessivo(nodo.getSuccessivo());
        nodo.getSuccessivo().setPrecedente(nodo.getPrecedente());
    }

    /**
     * Serve per aggiungere un nuovo nodo
     *
     * @param x informazione
     * @param k chiave
     */
    public void aggiungiNodo(T x, int k) {
        if (head == null)
            setHead(new Nodo<>(x, k));
        else {
            if (esisteNellaCatena(x, k)) return;
            Nodo<T> nuovoNodo = new Nodo<>(x, k);
            head.getSuccessivo().setPrecedente(nuovoNodo);
            nuovoNodo.setSuccessivo(head.getSuccessivo());
            head.setSuccessivo(nuovoNodo);
            nuovoNodo.setPrecedente(head);
        }
    }

    /**
     * Controllo se il nodo esiste di già nella catena
     *
     * @param x informazione
     * @param k chiave
     * @return true se esiste di già nella catena
     */
    public boolean esisteNellaCatena(T x, int k) {
        Nodo<T> corrente = head;
        do {
            if (corrente.getInformazione() == x && corrente.getChiave() == k)
                return true;
            corrente = corrente.getSuccessivo();
        } while (corrente.getSuccessivo() != head);
        return false;
    }

    /**
     * Il setter della head
     *
     * @param head il nodo
     */
    public void setHead(Nodo<T> head) {
        this.head = head;
        this.head.setPrecedente(head);
        this.head.setSuccessivo(head);
    }

    /**
     * @return la stringa con tutti i nodi della catena
     */
    public String stampaNodi() {
        if (catenaVuota())
            return null;
        Nodo<T> corrente = head;
        StringBuilder s = new StringBuilder();
        while (corrente.getSuccessivo() != head) {
            s.append(corrente).append(", ");
            corrente = corrente.getSuccessivo();
        }
        s.append(head.getPrecedente());
        return s.toString();
    }

    /**
     * @return la stringa con tutti i nodi della catena in ordine
     */
    public String stampaNodiOrdinati() {
        if (catenaVuota())
            return null;
        String[] nodi = stampaNodi().split(", ");
        Arrays.sort(nodi);
        return Arrays.toString(nodi).substring(1, Arrays.toString(nodi).length() - 1);
    }

    /**
     * @param k chiave
     * @return la stringa che rappresenta il nodo ricercato
     */
    public String getNodo(int k) {
        StringBuilder s = new StringBuilder();
        if (catenaVuota())
            return null;
        if (head.getChiave() == k)
            return s.append(head).toString();
        Nodo<T> successivo = head.getSuccessivo(), precedente = head.getPrecedente();
        while (successivo.getSuccessivo() != head) {
            if (precedente.getChiave() == k && successivo.getChiave() == k)
                return s.append(successivo).append(", ").append(precedente).toString();
            else if (precedente.getChiave() == k)
                return s.append(precedente).toString();
            else if (successivo.getChiave() == k)
                return s.append(successivo).toString();
            precedente = precedente.getPrecedente();
            successivo = successivo.getSuccessivo();
        }
        return s.toString();
    }
}
