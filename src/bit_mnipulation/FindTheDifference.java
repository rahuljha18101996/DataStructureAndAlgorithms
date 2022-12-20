package bit_mnipulation;

class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int ch = 0;
        for (int i = 0; i < s.length(); i++) {
            ch ^= s.charAt(i);
            ch ^= t.charAt(i);
        }
        return (char)(ch ^ t.charAt(t.length() - 1));
    }
}
