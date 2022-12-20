package functional_interface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/*
 *
 * Predicate and BiPredicate are the function which accept one and two parameter respectively and return true or false.
 * To use these function, there is function test.
 *
 * */
public class PredicateDemo {
    public static BiPredicate<String,String> areAnagrams = (word1, word2) -> {
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        for (char ch : word1.toCharArray()) w1[ch - 'a']++;
        for (char ch : word2.toCharArray()) w2[ch - 'a']++;
        for (int i = 0; i < w1.length; i++) if (w1[i] != w2[i]) return false;
        return true;
    };

    public static BiPredicate<String,String> isSubstring = (word1,word2) -> (word2 + word2).contains(word1);
    public static Predicate<Integer> isPrime = n -> {
        if (n < 2) {
            return false;
        }else if (n == 2 || n == 3) {
            return true;
        }else {
            if ((n - 1) % 6 == 0 || (n + 1) % 6 == 0) {
                for (int i = 2; i * i < n; i++) {
                    if (n % i == 0) return false;
                }
            }else {
                return false;
            }
        }
        return true;
    };
}
