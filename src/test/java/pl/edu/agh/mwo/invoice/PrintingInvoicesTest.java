package pl.edu.agh.mwo.invoice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintingInvoicesTest {

    @Test
    public void testPrintEmptyInvoice() {
        // Tworzymy pustą fakturę i instancję klasy PrintingInvoices
        Invoice invoice = new Invoice();
        PrintingInvoices printingInvoices = new PrintingInvoices();

        // Wywołujemy metodę printInvoice z pustą fakturą.
        String result = printingInvoices.printInvoice(invoice);

        // Sprawdzamy, czy zwrócony wynik jest zgodny z oczekiwanym ciągiem znaków.
        assertEquals("Numer faktury: 1\nLiczba pozycji: 0", result);
    }

}

