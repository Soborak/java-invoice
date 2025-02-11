package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.*;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    //private final Set<Product> products = new HashSet<>();
    private final Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        this.products.put(product,1);
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
    }

    public void addProduct(Product product, Integer quantity) {
        this.products.put(product, quantity);
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }

    public BigDecimal getSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            subtotal = subtotal.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        }
        return subtotal;
    }

    public BigDecimal getTax() {
        BigDecimal tax = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            tax = tax.add((product.getPrice().multiply(BigDecimal.valueOf(quantity))).multiply(product.getTaxPercent()));
        }
        return tax;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal subtotal;
        BigDecimal tax;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            subtotal = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            tax = product.getPrice().multiply(BigDecimal.valueOf(quantity)).multiply(product.getTaxPercent());
            total = total.add(subtotal.add(tax));
        }
        return total;
    }
}