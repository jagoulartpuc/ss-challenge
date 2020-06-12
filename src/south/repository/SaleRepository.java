package south.repository;

import south.domain.Sale;
import java.util.ArrayList;
import java.util.List;

public class SaleRepository {

    private static List<Sale> sales;

    public static List<Sale> getSales() {
        if (sales == null) {
            sales = new ArrayList<>();
        }
        return sales;
    }
}
