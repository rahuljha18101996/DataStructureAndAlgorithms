//package hashtable;
//
//import java.util.LinkedList;
//
//public class HashType<K,V> {
//    private LinkedList[] items;
//    private int size;
//    public HashType() {
//        size = 13;
//        items = new LinkedList<>[size];
//    }
//
//    public HashType(int size) {
//        this.size = size;
//        items = new LinkedList<>[this.size];
//    }
//
//    public boolean put(K key,V value) {
//        return true;
//    }
//
//    public V get(K key) {
//        return null;
//    }
//    private int hashCodeOfKey(K key) {
//        if (key instanceof Number  i) {
//            return (Integer)i % size;
//        }
//        return key.toString().length() % size;
//    }
//}
