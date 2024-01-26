package String_Questions;
import java.util.HashMap;
import java.util.Map;

class URLBuilder {
    private String protocol;
    private String host;
    private String path;
    private Map<String, String> queryParams;

    public URLBuilder() {
        this.queryParams = new HashMap<>();
    }

    public URLBuilder setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public URLBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public URLBuilder setPath(String path) {
        this.path = path;
        return this;
    }

    public URLBuilder addQueryParameter(String key, String value) {
        this.queryParams.put(key, value);
        return this;
    }

    public String build() {
        StringBuilder url = new StringBuilder();
        if (protocol != null) {
            url.append(protocol).append("://");
        }
        if (host != null) {
            url.append(host);
        }
        if (path != null) {
            url.append(path);
        }
        if (!queryParams.isEmpty()) {
            url.append("?");
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                url.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url.deleteCharAt(url.length() - 1); // Remove the trailing "&"
        }
        return url.toString();
    }

    public static void main(String[] args) {
        URLBuilder urlBuilder = new URLBuilder();
        String builtURL = urlBuilder
                .setProtocol("https")
                .setHost("www.example.com")
                .setPath("/path/to/resource")
                .addQueryParameter("param1", "value1")
                .addQueryParameter("param2", "value2")
                .build();

        System.out.println("Built URL: " + builtURL);
    }
}