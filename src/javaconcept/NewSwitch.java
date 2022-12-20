package javaconcept;

public class NewSwitch {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + " ");
            runSwitch(i);
        }
    }

    private static void runSwitch(int n) {
        switch (n) {
            case 0,1 -> System.out.println("Unknown");
            case 2,3,5,7 -> System.out.println("Prime Number");
            case 4,6,8,9 -> System.out.println("Not A Prime Number");
            default -> System.out.println("Out of Bound");
        }
    }
}
