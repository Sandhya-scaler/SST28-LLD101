import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Cafeteria Billing ===");

        InvoiceStore store = new FileStore();
        TaxPolicy taxPolicy = new TaxRules();
        DiscountPolicy discountPolicy = new DiscountRules();
        InvoiceFormatter formatter = new InvoiceFormatter();

        CafeteriaSystem system =
                new CafeteriaSystem(store, taxPolicy, discountPolicy, formatter);

        system.addToMenu(new MenuItem("M1", "Veg Thali", 80.0));
        system.addToMenu(new MenuItem("M2", "Coffee", 30.0));

        List<OrderLine> lines = new ArrayList<>();
        lines.add(new OrderLine("M1", 2));
        lines.add(new OrderLine("M2", 1));

        system.checkout("student", lines);
    }
}