package encryptdecrypt.algorithm;

public class CharCryptoAlgorithmFactory {

    public static Algorithm getInstance(CharCryptoAlgorithm algorithm, CharCryptoAlgorithmMode mode, int key){

        switch (algorithm) {
            case ALPHABET_CHAR_SHIFT:
                return new AlphabetCharShift(mode, key);
            case UNICODE_CHAR_SHIFT:
                return new UnicodeCharShift(mode, key);
            default: {
                throw new IllegalArgumentException("getAlgorithm method error: no matches with" + algorithm.name());
            }
        }
    }
}
