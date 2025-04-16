import pl.edu.agh.mwo.invoice.product.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProductsDuplicated {

    // Mapa przechowująca produkty i ich ilość (zachowuje kolejność dodania)
    private Map<Product, Integer> products;

    public ProductsDuplicated() {
        this.products = new LinkedHashMap<>();
    }

    // Dodawanie produktu do faktury
    public void addProduct(Product product, int quantity) {
        if (products.containsKey(product)) {
            // Jeśli produkt już istnieje, zwiększ jego ilość
            products.put(product, products.get(product) + quantity);
        } else {
            // Jeśli produkt nie istnieje, dodaj go
            products.put(product, quantity);
        }
    }

    // Pobieranie ilości danego produktu
    public int getQuantity(Product product) {
        // Pobierz ilość produktu z mapy, jeśli istnieje, lub zwróć 0
        return products.getOrDefault(product, 0);
    }

    // Pobieranie listy wszystkich produktów
    public Map<Product, Integer> getProducts() {
        return products;
    }

}
