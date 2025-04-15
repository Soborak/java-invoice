package pl.edu.agh.mwo.invoice;

import pl.edu.agh.mwo.invoice.product.Product;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Map;

public class PrintingInvoices {

    public String printInvoice(Invoice invoice) {
        StringBuilder result = new StringBuilder();
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
        df.applyPattern("#.00");

        result.append("Numer faktury: ").append(invoice.getInvoiceNumber().getNumer()).append("\n");

        int positionCount = 0;
        for (Map.Entry<Product, Integer> entry : invoice.getProducts().entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            result.append(product.getName()).append(", ")
                    .append(quantity).append(" szt., ")
                    .append(df.format(product.getPrice())).append(" PLN\n"); // Formatowanie ceny
            positionCount++;
        }

        result.append("Liczba pozycji: ").append(positionCount);
        return result.toString();
    }
}
