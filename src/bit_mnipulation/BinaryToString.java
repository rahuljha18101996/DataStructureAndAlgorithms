package bit_mnipulation;

public class BinaryToString {
    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) return "Error";
        StringBuilder binary = new StringBuilder();
        binary.append('.');
        while (num > 0) {
            if (binary.length() >= 32) {
                return "Error";
            }
            num *= 2;
            binary.append((int)num);
            num -= (int)num;
        }
        return binary.toString();
    }
}
