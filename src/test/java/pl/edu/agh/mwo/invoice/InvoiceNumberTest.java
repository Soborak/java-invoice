package pl.edu.agh.mwo.invoice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvoiceNumberTest {

    @Test // Sprawdza, czy numer jest dodatnią liczbą całkowitą
    public void invoiceNumberIsADigit() {
        InvoiceNumber invoice = new InvoiceNumber();
        assertTrue(invoice.getNumer() > 0);
    }

    @Test // Sprawdza, czy numer nie jest nullem
    public void invoiceNumberIsAutomaticallyAssigned() {
        InvoiceNumber invoice1 = new InvoiceNumber();
        InvoiceNumber invoice2 = new InvoiceNumber();
        assertNotNull(invoice1.getNumer());
        assertNotNull(invoice2.getNumer());
    }

    @Test // Sprawdza, czy numer drugiej faktury jest większy o 1
    public void invoiceNumberIsAlwaysSequential() {
        InvoiceNumber invoice1 = new InvoiceNumber();
        InvoiceNumber invoice2 = new InvoiceNumber();
        assertEquals(invoice1.getNumer() + 1, invoice2.getNumer());
    }

    @Test // Sprawdza, czy numery są różne
    public void invoiceNumberIsUnique() {
        InvoiceNumber invoice1 = new InvoiceNumber();
        InvoiceNumber invoice2 = new InvoiceNumber();
        assertNotEquals(invoice1.getNumer(), invoice2.getNumer());
    }
}