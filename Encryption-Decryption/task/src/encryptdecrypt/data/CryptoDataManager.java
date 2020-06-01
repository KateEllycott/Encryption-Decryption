package encryptdecrypt.data;


import encryptdecrypt.algorithm.Algorithm;
import encryptdecrypt.algorithm.CharCryptoAlgorithmFactory;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CryptoDataManager {

    private final CryptoData data;
    private final Algorithm algorithm;

    public CryptoDataManager(CryptoData data) {
        this.data = data;
        algorithm = CharCryptoAlgorithmFactory.getInstance(data.getAlgorithm(),
                data.getMode(), data.getKey());
    }

    public void processData() {
        if(data.isInPresent() && !data.isDataPresent()) {
            writeFile();
        }
        else {
            writeData();
        }
    }

    private void writeData() {
        if(data.isOutPresent()) {
            Path path = Paths.get(data.getOutPath());

            try(Writer writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.APPEND)) {
                transferDataToFile(data.getData(), writer, algorithm);
            }
            catch (IOException e) {
                System.out.println("Can't open the output file");
            }
        }
        else {
            transferDataToConsole(data.getData(), algorithm);
        }
    }

    private void writeFile() {
        Path in = Paths.get(data.getInPath());
        if(data.isOutPresent()) {
            Path out = Paths.get(data.getOutPath());

            try(Reader reader = Files.newBufferedReader(in, Charset.forName("UTF-8"));
                Writer writer = Files.newBufferedWriter(out, Charset.forName("UTF-8"))) {
                transferDataToFile(reader, writer, algorithm);
            }
            catch (IOException e) {
                System.out.println("Can't open the out or in file");
            }
        }
        else {
            try (Reader reader = Files.newBufferedReader(in, Charset.forName("UTF-8"))) {
                transferDataToConsole(reader, algorithm);
            }
            catch (IOException e) {
                System.out.println("Can't open the in file");
            }
        }
    }

    private static void transferDataToFile(String in, Writer writer, Algorithm algorithm) throws IOException {
        char[] chars = in.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            writer.write(algorithm.processChar(chars[i]));
        }
    }

    private static void transferDataToFile(Reader reader, Writer writer, Algorithm algorithm) throws IOException {

        int intChar = reader.read();

        while(intChar != -1) {
            writer.write(algorithm.processChar((char)intChar));
            intChar = reader.read();
        }
    }

    private static void transferDataToConsole(String data, Algorithm algorithm) {
        char[] chars = data.toCharArray();

            for(int i = 0; i < chars.length; i++) {
                System.out.print(algorithm.processChar(chars[i]));
            }
    }

    private static void transferDataToConsole(Reader reader, Algorithm algorithm) throws IOException {
        int intChar = reader.read();

            while(intChar != -1) {
                System.out.print(algorithm.processChar((char)intChar));
                intChar = reader.read();
            }
    }
}
