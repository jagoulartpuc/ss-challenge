package south.domain;

import java.util.List;

public class Sale {

    private String saleId;
    private List<Item> itens;
    private String salesmanName;

    public Sale(String saleId, List<Item> itens, String salesmanName) {
        this.saleId = saleId;
        this.itens = itens;
        this.salesmanName = salesmanName;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> purchases) {
        this.itens = itens;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId='" + saleId + '\'' +
                ", itens=" + itens +
                ", salesmanName='" + salesmanName + '\'' +
                '}';
    }
}