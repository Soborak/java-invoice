import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.agh.mwo.invoice.product.TaxFreeProduct; // Import klasy TaxFreeProduct

import java.math.BigDecimal;

public class ProductsDuplicatedTest {

    private ProductsDuplicated productsDuplicated;

    @BeforeEach
    public void setUp() {
        productsDuplicated = new ProductsDuplicated();
    }

    @Test
    public void testAddDuplicateProduct() {
        // Używamy TaxFreeProduct jako konkretnej implementacji klasy Product
        TaxFreeProduct product = new TaxFreeProduct("Produkt A", new BigDecimal("10.0"));
        productsDuplicated.addProduct(product, 1);
        productsDuplicated.addProduct(product, 2);

        // Sprawdzamy, czy produkt nie został dodany jako nowa pozycja, a ilość została zwiększona
        assertEquals(1, productsDuplicated.getProducts().size());
        assertEquals(3, productsDuplicated.getQuantity(product));
    }
}