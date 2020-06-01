package encryptdecrypt.algorithm;

public class UnicodeCharShift extends Algorithm {

    private final CharCryptoAlgorithmMode mode;
    private final int key;

    public UnicodeCharShift(CharCryptoAlgorithmMode mode, int key) {
        this.mode = mode;
        this.key = key;
    }

    @Override
    public char processChar(char c) {
        if(mode == CharCryptoAlgorithmMode.ENCRYPT) {
            return encodeChar(c);
        }
        else {
            return decodeChar(c);
        }
    }

    private char decodeChar(char c) {
        return (char)(c - key);
    }

    private char encodeChar(char c) {
       return (char)(c + key);
    }
}
