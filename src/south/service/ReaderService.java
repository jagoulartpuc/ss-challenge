package south.service;

import south.domain.Client;
import south.domain.Sale;
import south.domain.Salesman;
import south.repository.ClientRepository;
import south.repository.SaleRepository;
import south.repository.SalesmanRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class ReaderService {

    private SaleService saleService = new SaleService();

    public void readFile(String fileName) throws IOException {

        if (!fileName.endsWith(".dat")) {
            throw new FileNotFoundException();
        }
        Path path = Paths.get(fileName);

        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            sc.useDelimiter("[\n]");
            while (sc.hasNext()) {

                String line = sc.nextLine();
                String[] data = line.split("ç");
                String typeId = data[0];
                if (typeId.equals("001")) {
                    SalesmanRepository.getSalesmen().add(new Salesman(data[1], data[2], parseDouble(data[3])));
                } else if(typeId.equals("002")) {
                    ClientRepository.getClients().add(new Client(data[1], data[2], data[3]));
                } else if(typeId.equals("003")) {
                    SaleRepository.getSales().add(new Sale(data[1], saleService.convertItemStringToList(data[2]), data[3]));
                }

            }
        }
    }
}
