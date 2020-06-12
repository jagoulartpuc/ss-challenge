package south.service;

import south.domain.Item;
import south.domain.Sale;
import south.repository.SaleRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class SaleService {

    public List<Item> convertItemStringToList(String itens) {
        List<Item> itemList = new ArrayList<>();
        StringBuilder itensBuilder = new StringBuilder(itens);
        itensBuilder.deleteCharAt(0);
        itensBuilder.deleteCharAt(itens.length() - 2);
        String[] itemArray = itensBuilder.toString().split(",");
        for (int i = 0; i < itemArray.length; i++) {
            String[] attributes = itemArray[i].split("-");
            itemList.add(new Item(attributes[0], parseInt(attributes[1]), parseDouble(attributes[2])));
        }
        return itemList;
    }

    public String getMostExpensiveSale() {
        Map<Double, Sale> saleMap = new HashMap<>();
        double major = Double.MIN_VALUE;
        for (Sale sale: SaleRepository.getSales()) {
            double saleSum = getTotalSaleValue(sale.getItens());
            saleMap.put(saleSum, sale);
            if (saleSum > major) {
                major = saleSum;
            }
        }
        return saleMap.get(major).getSaleId();
    }

    public Sale getWorstSale() {
        Map<Integer, Sale> saleMap = new HashMap<>();
        int minor = Integer.MAX_VALUE;
        for (Sale sale: SaleRepository.getSales()) {
            int quantitySum = getTotalSaleQuantity(sale.getItens());
            saleMap.put(quantitySum, sale);
            if (quantitySum < minor) {
                minor = quantitySum;
            }
        }
        return saleMap.get(minor);
    }

    private double getTotalSaleValue(List<Item> itens) {
        double saleSum = 0;
        for (Item item: itens) {
            double totalPrice = item.getQuantity() * item.getPrice();
            saleSum += totalPrice;
        }
        return saleSum;
    }

    private int getTotalSaleQuantity(List<Item> itens) {
        int quantitySum = 0;
        for(Item item: itens) {
            quantitySum += item.getQuantity();
        }
        return quantitySum;
    }

}