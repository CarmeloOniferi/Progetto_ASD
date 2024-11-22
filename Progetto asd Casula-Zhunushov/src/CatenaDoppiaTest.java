import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <b>Casula Carmelo 7085019</b>
 * @author <b>Zhunushov Sultan 7073339</b>
 * @version 1.0
 */
class CatenaDoppiaTest {

    @org.junit.jupiter.api.Test
    void numeroElementi() {
        CatenaDoppia<Integer> integerCatenaDoppia = new CatenaDoppia<>();
        assertEquals(0, integerCatenaDoppia.numeroElementi());
        integerCatenaDoppia.aggiungiNodo(1, 3);
        integerCatenaDoppia.aggiungiNodo(2, 4);
        assertEquals(2, integerCatenaDoppia.numeroElementi());
        integerCatenaDoppia.eliminaNodo(3);
        assertEquals(1, integerCatenaDoppia.numeroElementi());
    }

    @org.junit.jupiter.api.Test
    void getHead() {
        CatenaDoppia<Integer> integerCatenaDoppia = new CatenaDoppia<>();
        assertNull(integerCatenaDoppia.getHead());
        Nodo<Integer> head = new Nodo<>(1, 2);
        integerCatenaDoppia.setHead(head);
        assertEquals(head, integerCatenaDoppia.getHead());
        integerCatenaDoppia.aggiungiNodo(2, 4);
        assertEquals(head, integerCatenaDoppia.getHead());
        integerCatenaDoppia.eliminaNodo(2);
        assertEquals(2, integerCatenaDoppia.getHead().getInformazione());
        assertEquals(4, integerCatenaDoppia.getHead().getChiave());
    }

    @org.junit.jupiter.api.Test
    void getUltimoNodo() {
        CatenaDoppia<Integer> integerCatenaDoppia = new CatenaDoppia<>();
        assertNull(integerCatenaDoppia.getUltimoNodo());
        Nodo<Integer> head = new Nodo<>(1, 2);
        integerCatenaDoppia.setHead(head);
        assertEquals(head, integerCatenaDoppia.getUltimoNodo());
        integerCatenaDoppia.aggiungiNodo(2, 4);
        assertEquals(2, integerCatenaDoppia.getUltimoNodo().getInformazione());
        assertEquals(4, integerCatenaDoppia.getUltimoNodo().getChiave());
        integerCatenaDoppia.aggiungiNodo(3, 5);
        assertEquals(2, integerCatenaDoppia.getUltimoNodo().getInformazione());
        assertEquals(4, integerCatenaDoppia.getUltimoNodo().getChiave());
        integerCatenaDoppia.eliminaNodo(4);
        assertEquals(3, integerCatenaDoppia.getUltimoNodo().getInformazione());
        assertEquals(5, integerCatenaDoppia.getUltimoNodo().getChiave());
    }

    @org.junit.jupiter.api.Test
    void getNodoSpecifico() {
        CatenaDoppia<Integer> integerCatenaDoppia = new CatenaDoppia<>();
        assertNull(integerCatenaDoppia.getNodoSpecifico(-1));
        assertNull(integerCatenaDoppia.getNodoSpecifico(0));
        assertNull(integerCatenaDoppia.getNodoSpecifico(1));
        integerCatenaDoppia.aggiungiNodo(1, 1);
        integerCatenaDoppia.aggiungiNodo(2, 2);
        integerCatenaDoppia.aggiungiNodo(3, 3);
        assertEquals(1, integerCatenaDoppia.getNodoSpecifico(1).getInformazione());
        assertEquals(3, integerCatenaDoppia.getNodoSpecifico(2).getInformazione());
        assertEquals(2, integerCatenaDoppia.getNodoSpecifico(3).getInformazione());
        integerCatenaDoppia.eliminaNodo(3);
        assertEquals(2, integerCatenaDoppia.getNodoSpecifico(2).getInformazione());
    }

    @org.junit.jupiter.api.Test
    void eliminaNodo() {
        CatenaDoppia<Integer> integerCatenaDoppia = new CatenaDoppia<>();
        integerCatenaDoppia.eliminaNodo(1);
        assertNull(integerCatenaDoppia.getHead());
        integerCatenaDoppia.aggiungiNodo(1, 1);
        integerCatenaDoppia.eliminaNodo(1);
        assertNull(integerCatenaDoppia.getHead());
        integerCatenaDoppia.aggiungiNodo(1, 1);
        integerCatenaDoppia.aggiungiNodo(2, 2);
        integerCatenaDoppia.aggiungiNodo(3, 3);
        integerCatenaDoppia.aggiungiNodo(4, 4);
        integerCatenaDoppia.eliminaNodo(1);
        assertEquals(4, integerCatenaDoppia.getHead().getInformazione());
    }

    @org.junit.jupiter.api.Test
    void aggiungiNodo() {
        CatenaDoppia<Integer> integerCatenaDoppia = new CatenaDoppia<>();
        assertNull(integerCatenaDoppia.getHead());
        integerCatenaDoppia.aggiungiNodo(1, 1);
        assertEquals(1, integerCatenaDoppia.getHead().getInformazione());
        assertEquals(1, integerCatenaDoppia.getUltimoNodo().getInformazione());
        integerCatenaDoppia.aggiungiNodo(2, 2);
        assertEquals(1, integerCatenaDoppia.getHead().getInformazione());
        assertEquals(2, integerCatenaDoppia.getUltimoNodo().getInformazione());
        assertEquals(2, integerCatenaDoppia.getHead().getSuccessivo().getInformazione());
        assertEquals(2, integerCatenaDoppia.getHead().getPrecedente().getInformazione());
        assertEquals(1, integerCatenaDoppia.getUltimoNodo().getPrecedente().getInformazione());
        assertEquals(1, integerCatenaDoppia.getUltimoNodo().getSuccessivo().getInformazione());
        integerCatenaDoppia.aggiungiNodo(3, 3);
        assertEquals(3, integerCatenaDoppia.getHead().getSuccessivo().getInformazione());
        assertEquals(2, integerCatenaDoppia.getHead().getPrecedente().getInformazione());
        assertEquals(2, integerCatenaDoppia.getHead().getSuccessivo().getSuccessivo().getInformazione());
        assertEquals(1, integerCatenaDoppia.getHead().getSuccessivo().getPrecedente().getInformazione());
        assertEquals(3, integerCatenaDoppia.getUltimoNodo().getPrecedente().getInformazione());
        assertEquals(1, integerCatenaDoppia.getUltimoNodo().getSuccessivo().getInformazione());
    }

    @org.junit.jupiter.api.Test
    void stampaNodi() {
        CatenaDoppia<Integer> integerCatenaDoppia = new CatenaDoppia<>();
        assertNull(integerCatenaDoppia.stampaNodi());
        integerCatenaDoppia.aggiungiNodo(1, 1);
        integerCatenaDoppia.aggiungiNodo(2, 2);
        integerCatenaDoppia.aggiungiNodo(3, 3);
        integerCatenaDoppia.aggiungiNodo(4, 4);
        integerCatenaDoppia.aggiungiNodo(4, 4);
        integerCatenaDoppia.aggiungiNodo(5, 5);
        assertEquals("[1,1], [5,5], [4,4], [3,3], [2,2]", integerCatenaDoppia.stampaNodi());
    }

    @org.junit.jupiter.api.Test
    void stampaNodiOrdinati() {
        CatenaDoppia<Integer> integerCatenaDoppia = new CatenaDoppia<>();
        assertNull(integerCatenaDoppia.stampaNodiOrdinati());
        integerCatenaDoppia.aggiungiNodo(1, 1);
        integerCatenaDoppia.aggiungiNodo(2, 2);
        integerCatenaDoppia.aggiungiNodo(3, 3);
        integerCatenaDoppia.aggiungiNodo(4, 4);
        assertEquals("[1,1], [2,2], [3,3], [4,4]", integerCatenaDoppia.stampaNodiOrdinati());
    }

    @org.junit.jupiter.api.Test
    void getNodo() {
        CatenaDoppia<Integer> integerCatenaDoppia = new CatenaDoppia<>();
        assertNull(integerCatenaDoppia.getNodo(1));
        integerCatenaDoppia.aggiungiNodo(1, 1);
        assertEquals("", integerCatenaDoppia.getNodo(2));
        integerCatenaDoppia.aggiungiNodo(2, 2);
        integerCatenaDoppia.aggiungiNodo(3, 3);
        integerCatenaDoppia.aggiungiNodo(4, 4);
        assertEquals("[1,1]", integerCatenaDoppia.getNodo(1));
        assertEquals("[4,4]", integerCatenaDoppia.getNodo(4));
    }
}