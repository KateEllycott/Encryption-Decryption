package encryptdecrypt.algorithm;

public class AlphabetCharShift extends Algorithm {

    private final CharCryptoAlgorithmMode mode;
    private final int key;

    public AlphabetCharShift(CharCryptoAlgorithmMode mode, int key) {
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
        int decoded = c;

        if ((c >= 'a' && c <= 'z')) {

            decoded = c - key;

            if (decoded < 'a') {
                decoded = (char) (decoded - 'a' + 'z' + 1);
            }
        } else {
            if ((c >= 'A' && c <= 'Z')) {

                decoded = c - key;

                if (decoded < 'A') {
                    decoded = (char) (decoded - 'A' + 'Z' + 1);
                }

            }
        }
        return (char) decoded;
    }

    private char encodeChar(char c) {

        int encoded = c;
        if((c >= 'a' && c <= 'z')) {

            if((key + encoded) <= 'z') {
                encoded = c + key;
            }
            else {
                encoded = 'a' + ((key + encoded) % 'z') - 1;
            }

        } else if (c >= 'A' && c <= 'Z') {

            if((key + encoded) <= 'Z') {
                encoded = c + key;
            }
            else {
                encoded = 'A' + ((key + encoded) % 'Z') - 1;
            }
        }
        return (char)encoded;
    }
}
