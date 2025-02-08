package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;
    private final BigDecimal price;
    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal taxPercent) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("You cannot create products with null or empty name.");
        }

        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("You cannot create products with null or negative price.");
        }

        if (taxPercent == null || taxPercent.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("You cannot create products with null or negative tax percent.");
        }

        this.name = name;
        this.price = price;
        this.taxPercent = taxPercent;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTaxPercent() {
        // Zwracamy dokładnie procent podatku
        return this.taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        // Cena brutto = cena netto + (cena netto * procent podatku)
        return this.price.add(this.price.multiply(this.taxPercent));
    }
}
