package String_Questions;
import java.util.HashMap;
import java.util.Map;
public class URLParser {
    private String url;

    public URLParser(String url) {
        this.url = url;
    }

    public String getProtocol() {
        int colonIndex = url.indexOf(":");
        if (colonIndex != -1) {
            return url.substring(0, colonIndex);
        }
        return null;
    }

    public String getHost() {
        int startIndex = url.indexOf("://");
        if (startIndex != -1) {
            startIndex += 3; // Move past "://"
            int endIndex = url.indexOf("/", startIndex);
            if (endIndex != -1) {
                return url.substring(startIndex, endIndex);
            } else {
                return url.substring(startIndex);
            }
        }
        return null;
    }

    public String getPath() {
        int startIndex = url.indexOf("://");
        if (startIndex != -1) {
            startIndex += 3; // Move past "://"
            int endIndex = url.indexOf("?", startIndex);
            if (endIndex != -1) {
                return url.substring(endIndex);
            }
        }
        return null;
    }

    public Map<String, String> getQueryParameters() {
        Map<String, String> queryParams = new HashMap<>();
        int questionMarkIndex = url.indexOf("?");
        if (questionMarkIndex != -1) {
            String queryString = url.substring(questionMarkIndex + 1);
            String[] pairs = queryString.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    queryParams.put(keyValue[0], keyValue[1]);
                }
            }
        }
        return queryParams;
    }

    public static void main(String[] args) {
        String url = "https://www.example.com/path?param1=value1&param2=value2";
        URLParser urlParser = new URLParser(url);

        System.out.println("Given URL: " + url);
        System.out.println("Protocol: " + urlParser.getProtocol());
        System.out.println("Host: " + urlParser.getHost());
        System.out.println("Path: " + urlParser.getPath());
        System.out.println("Query Parameters: " + urlParser.getQueryParameters());
    }
}
