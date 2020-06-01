
class Main {
    public static void main(String[] args) throws Exception {
        byte[] bytes = System.in.readAllBytes();
        for(int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i]);
        }
    }
}