package pl.edu.agh.mwo.invoice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FakturaTest {

    @Test
    public void invoiceNumberIsADigit() {
        Faktura invoice = new Faktura();
        assertTrue(invoice.getNumer() > 0); // Sprawdza, czy numer jest dodatnią liczbą całkowitą
    }

    @Test
    public void invoiceNumberIsAutomaticallyAssigned() {
        Faktura invoice1 = new Faktura();
        Faktura invoice2 = new Faktura();
        assertNotNull(invoice1.getNumer()); // Sprawdza, czy numer nie jest nullem
        assertNotNull(invoice2.getNumer());
    }

    @Test
    public void invoiceNumberIsAlwaysSequential() {
        Faktura invoice1 = new Faktura();
        Faktura invoice2 = new Faktura();
        assertEquals(invoice1.getNumer() + 1, invoice2.getNumer()); // Sprawdza, czy numer drugiej faktury jest większy o 1
    }

    @Test
    public void invoiceNumberIsUnique() {
        Faktura invoice1 = new Faktura();
        Faktura invoice2 = new Faktura();
        assertNotEquals(invoice1.getNumer(), invoice2.getNumer()); // Sprawdza, czy numery są różne
    }
}