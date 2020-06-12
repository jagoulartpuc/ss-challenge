package south.repository;

import south.domain.Salesman;
import java.util.ArrayList;
import java.util.List;

public class SalesmanRepository {

    private static List<Salesman> salesmen;

    public static List<Salesman> getSalesmen() {
        if (salesmen == null) {
            salesmen = new ArrayList<>();
        }
        return salesmen;
    }


}
