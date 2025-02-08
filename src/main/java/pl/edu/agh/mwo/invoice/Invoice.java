package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {

    private Map<Product, Integer> products = new HashMap<>();

    // Dodanie produktu bez ilości (domyślna ilość: 1)
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product nie może być null");
        }
        this.addProduct(product, 1); // Wywołanie metody z ilością
    }

    // Dodanie produktu z określoną ilością
    public void addProduct(Product product, Integer quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product nie może być null");
        }
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Ilość musi być większa od zera");
        }
        this.products.put(product, this.products.getOrDefault(product, 0) + quantity);
    }

    // Obliczenie sumy netto (bez podatków)
    public BigDecimal getSubtotal() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            sum = sum.add(product.getPrice().multiply(new BigDecimal(quantity)));
        }
        return sum;
    }

    // Obliczenie kwoty podatku
    public BigDecimal getTax() {
        BigDecimal tax = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            tax = tax.add(product.getPriceWithTax().subtract(product.getPrice()).multiply(new BigDecimal(quantity)));
        }
        return tax;
    }

    // Obliczenie całkowitej sumy brutto (z podatkami)
    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            total = total.add(product.getPriceWithTax().multiply(new BigDecimal(quantity)));
        }
        return total;
    }
}
