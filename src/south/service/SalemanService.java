package south.service;

import south.domain.Salesman;
import south.repository.SalesmanRepository;

public class SalemanService {

    private SaleService saleService = new SaleService();

    public int getSalemenTotal() {
        return SalesmanRepository.getSalesmen().size();
    }

    public Salesman getWorstSalesman() {
        return getSalemanByName(saleService.getWorstSale().getSalesmanName());
    }

    public Salesman getSalemanByName(String name) {
        return SalesmanRepository.getSalesmen().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }
}
