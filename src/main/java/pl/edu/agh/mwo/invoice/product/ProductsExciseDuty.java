package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

 // Klasa ProductsExciseDuty definiuje produkty objęte akcyzą.
 // Zawiera klasy wewnętrzne reprezentujące konkretne produkty,
 // takie jak butelka wina i kanister paliwa.

public class ProductsExciseDuty {

    // Klasa BottleOfWine reprezentuje produkt "Butelka wina".
    // Dziedziczy po klasie Product i dodaje akcyzę do ceny z podatkiem VAT.

    public static class BottleOfWine extends Product {

        // Stała wartość akcyzy dla butelki wina (5.56 PLN)
        private static final BigDecimal EXCISE_TAX = new BigDecimal("5.56");

        public BottleOfWine(String name, BigDecimal price, BigDecimal tax) {
            super(name, price, tax); // Wywołanie konstruktora klasy bazowej Product.
        }

        // Metoda obliczająca cenę produktu z podatkiem VAT i akcyzą.
        @Override
        public BigDecimal getPriceWithTax() {
            return super.getPriceWithTax().add(EXCISE_TAX); // Dodanie akcyzy do ceny z VAT.
        }
    }

     // Klasa FuelCanister reprezentuje produkt "Kanister paliwa".
     // Dziedziczy po klasie Product i dodaje akcyzę do ceny z podatkiem VAT.

    public static class FuelCanister extends Product {

        // Stała wartość akcyzy dla kanistra paliwa (5.56 PLN)
        private static final BigDecimal EXCISE_TAX = new BigDecimal("5.56");

         // Konstruktor klasy FuelCanister.
        public FuelCanister(String name, BigDecimal price, BigDecimal tax) {
            super(name, price, tax); // Wywołanie konstruktora klasy bazowej Product.
        }

        // Metoda obliczająca cenę produktu z podatkiem VAT i akcyzą.
        @Override
        public BigDecimal getPriceWithTax() {
            return super.getPriceWithTax().add(EXCISE_TAX); // Dodanie akcyzy do ceny z VAT.
        }
    }

}