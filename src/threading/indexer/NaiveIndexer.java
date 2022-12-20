package threading.indexer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.util.ArrayDeque;
import java.util.Deque;

public class NaiveIndexer {
    private Deque<WebLink> queue = new ArrayDeque<>();

    public static void run() {
        NaiveIndexer naiveIndexer = new NaiveIndexer();
        naiveIndexer.add(naiveIndexer.createWeblink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com"));
        naiveIndexer.add(naiveIndexer.createWeblink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com"));
        naiveIndexer.add(naiveIndexer.createWeblink(2002, "Interface vs Abstract Class", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
        naiveIndexer.add(naiveIndexer.createWeblink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
        naiveIndexer.go();
    }

    public void go() {
        while (queue.size() > 0) {
            WebLink webLink = queue.remove();
            Thread downloderThread = new Thread(new Downloader(webLink));
            Thread indexerThread = new Thread(new Indexer(webLink));
            downloderThread.start();
            indexerThread.start();
        }
    }

    public void add(WebLink link) {
        queue.add(link);
    }

    public WebLink createWeblink(long id,String title,String url,String host) {
        WebLink webLink = new WebLink();
        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setUrl(url);
        webLink.setHost(host);
        return webLink;
    }

    private static class WebLink {
        private long id;
        private String title;
        private String url;
        private String host;

        private volatile String htmlPage;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getHtmlPage() {
            return htmlPage;
        }

        public void setHtmlPage(String htmlPage) {
            this.htmlPage = htmlPage;
        }
    }

    public static class Downloader implements Runnable {
        private WebLink webLink;

        public Downloader(WebLink webLink) {
            this.webLink = webLink;
        }

        @Override
        public void run() {
            try {
                String htmlPage = HttpConnect.download(webLink.getUrl());
                webLink.setHtmlPage(htmlPage);
            }catch (MalformedURLException | URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class Indexer implements Runnable {
        private WebLink webLink;

        public Indexer(WebLink webLink) {
            this.webLink = webLink;
        }

        @Override
        public void run() {
            while (true) {
                String htmlPage = webLink.getHtmlPage();
                if (htmlPage != null) {
                    index(htmlPage);
                    break;
                }else {
                    System.out.printf("%d not yet downloaded!!\n",webLink.getId());
                }
            }
        }

        private void index(String htmlPage) {
            if (htmlPage != null) {
                System.out.printf("\nIndexed: %d\n" , webLink.getId());
            }
        }
    }


}
