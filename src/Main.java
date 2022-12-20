public class Main {
    public static void main(String[] args) {
        System.out.print((int)(Math.random() * 10000));
        for (int i = 0; i < 1000; i++) {
            System.out.print("," + (int)(Math.random() * 10000));
        }
    }
}