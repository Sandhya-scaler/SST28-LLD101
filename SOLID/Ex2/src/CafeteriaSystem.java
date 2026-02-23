import java.util.*;

public class CafeteriaSystem {

    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store;
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    private final InvoiceFormatter formatter;

    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoiceStore store,
                           TaxPolicy taxPolicy,
                           DiscountPolicy discountPolicy,
                           InvoiceFormatter formatter) {
        this.store = store;
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
        this.formatter = formatter;
    }

  
    public void addToMenu(MenuItem item) {
        menu.put(item.id, item);
    }

    public void checkout(String customerType, List<OrderLine> lines) {

        String invId = "INV-" + (++invoiceSeq);

        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            subtotal += item.price * l.qty;
        }

        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        double discount = discountPolicy.discountAmount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;

        String printable = formatter.format(invId, lines, menu,
                subtotal, taxPct, tax, discount, total);

        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId +
                " (lines=" + store.countLines(invId) + ")");
    }
}