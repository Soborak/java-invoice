package pl.edu.agh.mwo.invoice;

public class InvoiceNumber {
    private static int licznik = 0; // Statyczny licznik dla wszystkich faktur
    private int numer;

    public InvoiceNumber() {
        this.numer = ++licznik; // Inkrementacja przy każdej nowej fakturze
    }

    public int getNumer() {
        return numer; // Zwraca numer faktury
    }
}
