package south;

import south.io.InputFileGenerator;
import south.io.OutputFileGenerator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFileName = "input.dat";
        InputFileGenerator inputFileGenerator = new InputFileGenerator();
        inputFileGenerator.generateFile(inputFileName);

        OutputFileGenerator outputFileGenerator = new OutputFileGenerator();
        outputFileGenerator.generateOutputFile(inputFileName);
    }
}
