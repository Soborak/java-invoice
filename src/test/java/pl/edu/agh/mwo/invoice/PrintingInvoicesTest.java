package pl.edu.agh.mwo.invoice;

import org.junit.jupiter.api.Test;
import pl.edu.agh.mwo.invoice.product.OtherProduct;
import pl.edu.agh.mwo.invoice.product.TaxFreeProduct;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintingInvoicesTest {

    @Test
    public void testPrintEmptyInvoice() { // pusta faktura
        // Tworzymy pustą fakturę i instancję klasy PrintingInvoices
        Invoice invoice = new Invoice();
        PrintingInvoices printingInvoices = new PrintingInvoices();

        // Wywołujemy metodę printInvoice z pustą fakturą.
        String result = printingInvoices.printInvoice(invoice);

        // Sprawdzamy, czy zwrócony wynik jest zgodny z oczekiwanym ciągiem znaków.
        assertEquals("Numer faktury: 1\nLiczba pozycji: 0", result);
    }
    @Test
    public void testPrintInvoiceWithOneProduct() { // faktura z jednym prodoktem
        // Tworzymy fakturę i dodajemy jeden produkt
        Invoice invoice = new Invoice();
        PrintingInvoices printingInvoices = new PrintingInvoices();
        invoice.addProduct(new TaxFreeProduct("Chleb", new BigDecimal("3.50")), 1);

        // Wywołujemy metodę printInvoice
        String result = printingInvoices.printInvoice(invoice);

        // Oczekiwany wynik
        String expected = "Numer faktury: 1\n" +
                "Chleb, 1 szt., 3.50 PLN\n" +
                "Liczba pozycji: 1";

        // Sprawdzamy wynik
        assertEquals(expected, result);
    }

    @Test
    public void testPrintInvoiceWithMultipleProducts() { // faktura z wieloma produktami
        // Tworzymy fakturę i dodajemy kilka produktów
        Invoice invoice = new Invoice();
        PrintingInvoices printingInvoices = new PrintingInvoices();
        invoice.addProduct(new TaxFreeProduct("Chleb", new BigDecimal("3.50")), 2);
        invoice.addProduct(new OtherProduct("Masło", new BigDecimal("7.00")), 1);

        // Wywołujemy metodę printInvoice
        String result = printingInvoices.printInvoice(invoice);

        // Oczekiwany wynik
        String expected = "Numer faktury: 1\n" +
                "Chleb, 2 szt., 3.50 PLN\n" +
                "Masło, 1 szt., 7.00 PLN\n" +
                "Liczba pozycji: 2";

        // Sprawdzamy wynik
        assertEquals(expected, result);
    }

    @Test
    public void testPrintInvoiceWithDifferentQuantities() { // różne ilości na fakturze
        // Tworzymy fakturę i dodajemy produkty z różnymi ilościami
        Invoice invoice = new Invoice();
        PrintingInvoices printingInvoices = new PrintingInvoices();
        invoice.addProduct(new TaxFreeProduct("Mleko", new BigDecimal("2.50")), 3);
        invoice.addProduct(new OtherProduct("Ser", new BigDecimal("15.00")), 5);

        // Wywołujemy metodę printInvoice
        String result = printingInvoices.printInvoice(invoice);

        // Oczekiwany wynik
        String expected = "Numer faktury: 1\n" +
                "Mleko, 3 szt., 2.50 PLN\n" +
                "Ser, 5 szt., 15.00 PLN\n" +
                "Liczba pozycji: 2";

        // Debugowanie
        System.out.println("Expected:\n" + expected);
        System.out.println("Result:\n" + result);

        // Sprawdzamy wynik
        assertEquals(expected, result);
    }
}

