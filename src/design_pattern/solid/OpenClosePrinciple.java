package design_pattern.solid;

import java.util.HashMap;
import java.util.Map;

/*
* Open Close Principle
* Classes should open for extension, closed for modification.
* */
public final class OpenClosePrinciple {
    private static OpenClosePrinciple instance = new OpenClosePrinciple();
    public static OpenClosePrinciple getInstance() {
        return instance;
    }

    private Map<MyKeys,String> mySecretes;
    private OpenClosePrinciple() {
        mySecretes = new HashMap<>();

        for (MyKeys key : MyKeys.values()) {
            mySecretes.put(key,GetVal(key.name()));
        }
    }

    public String Get(MyKeys key) {
        return mySecretes.get(key);
    }
    public enum MyKeys {
        Key1,
        Key2,
        Key3
    }

    /*API for getting the Key*/
    /*Just for Illustrating Locally*/
    private String GetVal(String key) {
        if (key.equals("Key1")) return "Value 1";
        if (key.equals("Key2")) return "Value 2";
        if (key.equals("Key3")) return "Value 3";
        return null;
    }
}
