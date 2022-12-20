package threading.indexer;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class HttpConnect {

    public static String download(String sourceUrl) throws URISyntaxException, IOException {
        System.out.println("Downloading: " + sourceUrl);
        URL url = new URI(sourceUrl).toURL();
        Scanner scanner = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        String line;
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
        }
        return sb.toString();
    }
}
