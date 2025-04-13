package pl.edu.agh.mwo.invoice;

public class Faktura {
    private static int licznik = 0; // Statyczny licznik dla wszystkich faktur
    private int numer;

    public Faktura() {
        this.numer = ++licznik; // Inkrementacja przy każdej nowej fakturze
    }

    public int getNumer() {
        return numer; // Zwraca numer faktury
    }
}
