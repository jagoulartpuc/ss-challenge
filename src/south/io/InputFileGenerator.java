package south.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class InputFileGenerator {

    public void generateFile(String fileName) {
        byte[] data = generateMultifileData().getBytes();
        Path p = Paths.get(fileName);

        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    private String generateMultifileData() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < randomBetween(7,14); i++) {
            builder.append(generateOneFileData());
        }
        return builder.toString();
    }

    private String generateOneFileData() {
        StringBuilder builder = new StringBuilder();
        String[] type = {"001", "002", "003"};
        String[] names = {"Helena", "Miguel", "Alice", "Arthur", "Laura", "Heitor", "Augusto",
        "Enrique", "Mauricio", "Luiza", "Pedro", "Joao Carlos", "Bruno", "Luan", "Fernanda", "Mariana"};

        String[] businessArea = {"Rural", "Contabil", "Informatica", "Saude", "Negocios",
                "Filosofia", "Engenharia", "Pedagogia", "Teatro", "Musica"};

        if (type[randomBetween(0,2)].equals("001") || type[randomBetween(0,2)].equals("003")) {
            String name = names[randomBetween(0, names.length - 1)];
            builder.append("001ç").append(generateCPForCNPJ()).append("ç").append(name).append("ç")
                    .append((double) randomBetween(1000, 4000)).append("\n");
            builder.append("003ç").append(randomBetween(1, 100)).append("ç[").append(generateItens()).append("]ç")
                    .append(name).append("\n");

        } else {
            builder.append("002ç").append(generateCPForCNPJ()).append("ç").append(names[randomBetween(0, names.length - 1)]).append("ç")
                    .append(businessArea[randomBetween(0, businessArea.length - 1)]).append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }

    private String generateItens() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < randomBetween(3, 6); i++) {
            builder.append(randomBetween(0, 1000)).append("-").append(randomBetween(1, 40))
                    .append("-").append((double) randomBetween(10, 900));
        }
        return builder.toString();
    }

    private String generateCPForCNPJ() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 11; i++) {
            builder.append(randomBetween(0,9));
        }
        return builder.toString();
    }

    private int randomBetween(int max, int min) {
        Random random = new Random();
        if (min >= max) {
            return (random.nextInt((min - max) + 1) + max);
        }
        return (random.nextInt((max - min) + 1) + min);
    }


}
