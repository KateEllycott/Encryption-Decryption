package encryptdecrypt.data;


import encryptdecrypt.algorithm.CharCryptoAlgorithm;
import encryptdecrypt.algorithm.CharCryptoAlgorithmMode;

public class CryptoData {

    private CharCryptoAlgorithm algorithm = CharCryptoAlgorithm.ALPHABET_CHAR_SHIFT;
    private CharCryptoAlgorithmMode mode = CharCryptoAlgorithmMode.ENCRYPT;
    private int key = 0;
    private String data = "";
    private boolean dataPresent = false;
    private boolean inPresent = false;
    private boolean outPresent = false;
    private String inPath = null;
    private String outPath = null;


    public void setMode(CharCryptoAlgorithmMode mode) {
        this.mode = mode;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public boolean isDataPresent() {
        return dataPresent;
    }

    public void setDataPresent(boolean dataPresent) {
        this.dataPresent = dataPresent;
    }

    public void setInPresent(boolean inPresent) {
        this.inPresent = inPresent;
    }

    public boolean isInPresent() {
        return inPresent;
    }

    public void setOutPresent(boolean outPresent) {
        this.outPresent = outPresent;
    }

    public boolean isOutPresent() {
        return outPresent;
    }

    public void setInPath(String inPath) {
        this.inPath = inPath;
    }

    public String getInPath() {
        return inPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public String getOutPath() {
        return outPath;
    }

    public void setAlgorithm(CharCryptoAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public CharCryptoAlgorithm getAlgorithm() {
        return algorithm;
    }

    public CharCryptoAlgorithmMode getMode() {
        return mode;
    }
}
