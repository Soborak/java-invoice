package pl.edu.agh.mwo.invoice;

import pl.edu.agh.mwo.invoice.product.Product; // Import klasy Product

import java.text.DecimalFormat; // Import klasy do formatowania liczb
import java.util.Locale; // Import klasy do ustawienia lokalizacji dla formatowania
import java.util.Map; // Import klasy Map do przechowywania produktów i ich ilości

 // Klasa PrintingInvoices odpowiada za generowanie tekstowej reprezentacji faktury.
public class PrintingInvoices {

     // Metoda printInvoice generuje tekstową reprezentację faktury.
     // Parametr: invoice Obiekt faktury, który ma być wydrukowany.
     // Zwracaca: Tekstowa reprezentacja faktury.
    public String printInvoice(Invoice invoice) {
        StringBuilder result = new StringBuilder(); // Używamy StringBuildera do efektywnego tworzenia łańcucha znaków
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.US); // Tworzymy obiekt DecimalFormat z ustawieniem lokalizacji na US
        df.applyPattern("#.00"); // Ustawiamy wzorzec formatowania na dwie cyfry po przecinku

        // Dodajemy numer faktury do wyniku
        result.append("Numer faktury: ").append(invoice.getInvoiceNumber().getNumer()).append("\n");

        int positionCount = 0; // Inicjalizujemy licznik pozycji na fakturze

        // Iterujemy przez wszystkie produkty na fakturze
        for (Map.Entry<Product, Integer> entry : invoice.getProducts().entrySet()) {
            Product product = entry.getKey(); // Pobieramy produkt
            Integer quantity = entry.getValue(); // Pobieramy ilość produktu

            // Dodajemy szczegóły produktu do wyniku
            result.append(product.getName()).append(", ") // Nazwa produktu
                    .append(quantity).append(" szt., ") // Ilość
                    .append(df.format(product.getPrice())).append(" PLN\n"); // Cena sformatowana do dwóch miejsc po przecinku

            positionCount++; // Zwiększamy licznik pozycji
        }

        // Dodajemy całkowitą liczbę pozycji do wyniku
        result.append("Liczba pozycji: ").append(positionCount);

        return result.toString(); // Zwracamy kompletną tekstową reprezentację faktury
    }

}
