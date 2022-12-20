package strings.formatted;

public class MultiLineString {
    public static void main(String[] args) {
        String json = """
                {
                    "name" : "Rajesh",
                    "age" : 21,
                    "description" : "Nothing so far..."
                }
                """;

        System.out.println(json);
    }
}
