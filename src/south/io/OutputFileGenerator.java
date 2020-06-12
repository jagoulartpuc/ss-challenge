package south.io;

import south.service.ClientService;
import south.service.ReaderService;
import south.service.SaleService;
import south.service.SalemanService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class OutputFileGenerator {

    public void generateOutputFile(String inputFileName) throws IOException {
        ReaderService readerService = new ReaderService();
        readerService.readFile(inputFileName);

        ClientService clientService = new ClientService();
        SaleService saleService = new SaleService();
        SalemanService salemanService = new SalemanService();

        String s = clientService.getTotalClients()  + " total of clients\n" +
                salemanService.getSalemenTotal() + " total of salesman\n" +
                saleService.getMostExpensiveSale() + " most expensive sale\n" +
                salemanService.getWorstSalesman() + " worst salesman\n";

        byte[] data = s.getBytes();
        Path p = Paths.get("flat_output.done.dat");

        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
    
}