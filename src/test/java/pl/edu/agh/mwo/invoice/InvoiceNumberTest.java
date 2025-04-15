package pl.edu.agh.mwo.invoice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvoiceNumberTest {

    @Test
    public void invoiceNumberIsADigit() {
        InvoiceNumber invoice = new InvoiceNumber();
        assertTrue(invoice.getNumer() > 0); // Sprawdza, czy numer jest dodatnią liczbą całkowitą
    }

    @Test
    public void invoiceNumberIsAutomaticallyAssigned() {
        InvoiceNumber invoice1 = new InvoiceNumber();
        InvoiceNumber invoice2 = new InvoiceNumber();
        assertNotNull(invoice1.getNumer()); // Sprawdza, czy numer nie jest nullem
        assertNotNull(invoice2.getNumer());
    }

    @Test
    public void invoiceNumberIsAlwaysSequential() {
        InvoiceNumber invoice1 = new InvoiceNumber();
        InvoiceNumber invoice2 = new InvoiceNumber();
        assertEquals(invoice1.getNumer() + 1, invoice2.getNumer()); // Sprawdza, czy numer drugiej faktury jest większy o 1
    }

    @Test
    public void invoiceNumberIsUnique() {
        InvoiceNumber invoice1 = new InvoiceNumber();
        InvoiceNumber invoice2 = new InvoiceNumber();
        assertNotEquals(invoice1.getNumer(), invoice2.getNumer()); // Sprawdza, czy numery są różne
    }
}