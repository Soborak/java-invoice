package pl.edu.agh.mwo.invoice.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class ProductsExciseDutyTest {

    // Test sprawdzający, czy cena butelki wina uwzględnia podatek VAT oraz akcyzę
    @Test
    public void testBottleOfWinePriceWithTaxIncludesExciseDuty() {
        // Tworzenie obiektu BottleOfWine z ceną netto 20.00 PLN i stawką VAT 23%
        ProductsExciseDuty.BottleOfWine wine = new ProductsExciseDuty.BottleOfWine(
                "Wino", new BigDecimal("20.00"), new BigDecimal("0.23")
        );

        // Obliczanie oczekiwanej ceny z podatkiem VAT i akcyzą
        BigDecimal expectedPriceWithTax = new BigDecimal("20.00")
                .multiply(new BigDecimal("1.23")) // Dodanie VAT (20.00 * 1.23)
                .add(new BigDecimal("5.56"));     // Dodanie akcyzy (5.56 PLN)

        // Porównanie obliczonej ceny z ceną zwracaną przez metodę getPriceWithTax()
        assertEquals(expectedPriceWithTax, wine.getPriceWithTax());
    }

    // Test sprawdzający, czy cena kanistra paliwa uwzględnia podatek VAT oraz akcyzę
    @Test
    public void testFuelCanisterPriceWithTaxIncludesExciseDuty() {
        // Tworzenie obiektu FuelCanister z ceną netto 50.00 PLN i stawką VAT 23%
        ProductsExciseDuty.FuelCanister fuel = new ProductsExciseDuty.FuelCanister(
                "Kanister", new BigDecimal("50.00"), new BigDecimal("0.23")
        );

        // Obliczanie oczekiwanej ceny z podatkiem VAT i akcyzą
        BigDecimal expectedPriceWithTax = new BigDecimal("50.00")
                .multiply(new BigDecimal("1.23")) // Dodanie VAT (50.00 * 1.23)
                .add(new BigDecimal("5.56"));     // Dodanie akcyzy (5.56 PLN)

        // Porównanie obliczonej ceny z ceną zwracaną przez metodę getPriceWithTax()
        assertEquals(expectedPriceWithTax, fuel.getPriceWithTax());
    }

}