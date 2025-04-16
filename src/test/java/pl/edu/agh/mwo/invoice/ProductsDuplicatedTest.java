import static org.junit.jupiter.api.Assertions.assertEquals; // Import metody do sprawdzania równości w testach
import org.junit.jupiter.api.BeforeEach; // Import adnotacji do ustawiania stanu przed każdym testem
import org.junit.jupiter.api.Test; // Import adnotacji do definiowania testów
import pl.edu.agh.mwo.invoice.product.TaxFreeProduct; // Import klasy TaxFreeProduct
import java.math.BigDecimal; // Import klasy BigDecimal do obsługi precyzyjnych obliczeń liczbowych

// Klasa testowa ProductsDuplicatedTest.
// Testuje funkcjonalności klasy ProductsDuplicated, która zarządza produktami i ich ilościami.

public class ProductsDuplicatedTest {

    private ProductsDuplicated productsDuplicated; // Obiekt klasy ProductsDuplicated, który będzie testowany

    // Metoda wykonywana przed każdym testem.
    // Inicjalizuje nową instancję klasy ProductsDuplicated.

    @BeforeEach
    public void setUp() {
        productsDuplicated = new ProductsDuplicated();
    }

    // Test sprawdzający, czy dodanie tego samego produktu więcej niż raz
    // powoduje zwiększenie jego ilości, a nie dodanie nowej pozycji.

    @Test
    public void testAddDuplicateProduct() {
        // Tworzymy obiekt produktu bez VAT (TaxFreeProduct) z ceną 10.0 PLN
        TaxFreeProduct product = new TaxFreeProduct("Produkt A", new BigDecimal("10.0"));

        // Dodajemy produkt "Produkt A" w ilości 1
        productsDuplicated.addProduct(product, 1);

        // Dodajemy ten sam produkt "Produkt A" w ilości 2
        productsDuplicated.addProduct(product, 2);

        // Sprawdzamy, czy lista produktów zawiera tylko 1 pozycję (brak duplikatów)
        assertEquals(1, productsDuplicated.getProducts().size());

        // Sprawdzamy, czy ilość produktu została poprawnie zwiększona do 3
        assertEquals(3, productsDuplicated.getQuantity(product));
    }

}