package encryptdecrypt;

import encryptdecrypt.algorithm.CharCryptoAlgorithm;
import encryptdecrypt.algorithm.CharCryptoAlgorithmMode;
import encryptdecrypt.data.CryptoData;
import encryptdecrypt.data.CryptoDataManager;

public class Main {

    public static void main(String[] args) {

        CryptoData data = parseInput(args);
        CryptoDataManager dataManager = new CryptoDataManager(data);
        dataManager.processData();
    }

    private static CryptoData parseInput(String[] args) {

        CryptoData data = new CryptoData();

        int index = 0;
        while (index < args.length) {
            switch (args[index]) {
                case "-mode":
                    String mode = args[++index];

                    switch (mode) {
                        case "enc":
                            data.setMode(CharCryptoAlgorithmMode.ENCRYPT);
                            break;
                        case "dec":
                            data.setMode(CharCryptoAlgorithmMode.DECRYPT);
                            break;
                        default: {
                            throw new IllegalArgumentException("Error: Wrong mode name.");
                        }
                    }
                    index++;
                    break;
                case "-in":
                    data.setInPresent(true);
                    data.setInPath(args[++index]);
                    index++;
                    break;
                case "-data":
                    data.setDataPresent(true);
                    data.setData(args[++index]);
                    index++;
                    break;
                case "-out":
                    data.setOutPresent(true);
                    data.setOutPath(args[++index]);
                    index++;
                    break;
                case "-key":
                    int key = Integer.parseInt(args[++index]);
                    if(key < 0) {
                        throw new IllegalArgumentException("Error: Wrong key value.");
                    }
                    data.setKey(key);
                    index++;
                    break;
                case "-alg":
                    String algorithm = args[++index];
                    switch (algorithm) {
                        case "shift":
                            data.setAlgorithm(CharCryptoAlgorithm.ALPHABET_CHAR_SHIFT);
                            break;
                        case "unicode":
                            data.setAlgorithm(CharCryptoAlgorithm.UNICODE_CHAR_SHIFT);
                            break;
                        default: {
                            throw new IllegalArgumentException("Error: Wrong algorithm name.");
                        }
                    }
                    index++;
                    break;
                default: {
                    throw new IllegalArgumentException("Error: illegal parameter - " + args[index]);
                }
            }
        }
        return data;
    }
}

