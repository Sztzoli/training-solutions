package stringmethods.url;



public class UrlManager {

    private final String protocol;
    private final Integer port;
    private final String host;
    private final String path;
    private final String query;

    public UrlManager(String url) {
        protocol = setProtocolFromUrl(url);
        host = setHostFromUrl(url);
        port = setPortFromUrl(url);
        path = setPathFromUrl(url);
        query = setQueryFromUrl(url);
    }

    private String setQueryFromUrl(String url) {
        if (!url.contains("?")) {
            return "";
        }

        return url.substring(url.indexOf("?")+1);
    }

    private String setPathFromUrl(String url) {
        String str = url.substring(url.indexOf("/") + 2);
        if (!str.contains("?")) {
            return "";
        }
        str = str.substring(str.indexOf("/"), str.indexOf("?"));
        return str;
    }

    private String setHostFromUrl(String url) {

        String str = url.substring(url.indexOf("/") + 2);
        if (str.contains("/")) {
            str = str.substring(0, str.indexOf("/"));
        }

        if (str.contains(":")) {
            return str.substring(0, str.indexOf(":")).toLowerCase();
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Invalid url");
        }
        return str.toLowerCase();
    }

    private Integer setPortFromUrl(String url) {
        String str = url.substring(url.indexOf("/") + 2);
        if (str.contains("/")) {
            str = str.substring(0, str.indexOf("/"));
        }
        if (str.contains(":")) {
            return Integer.parseInt(str.substring(str.indexOf(":")+1));
        }
        return null;
    }

    private String setProtocolFromUrl(String url) {
        if (!url.contains("://")) {
            throw new IllegalArgumentException("Invalid url");
        }


        return url.substring(0, url.indexOf(":")).toLowerCase();
    }


    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public boolean hasProperty(String key) {
        if (key==null || key.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        String[] keyValue = query.split("&");
        int i=0;
        boolean isContain=false;
        while (i< keyValue.length && !isContain) {
            if (key.equals(keyValue[i].substring(0,keyValue[i].indexOf("=")))) {
                isContain=true;
            }
            i++;
        }
        return isContain;
    }

    public String getProperty(String key) {
        String[] keyValue = query.split("&");
        int i=0;
        while (i< keyValue.length) {
            String keyFromKeyValue=keyValue[i].substring(0,keyValue[i].indexOf("="));
            if (key.equals(keyFromKeyValue)) {
                return keyValue[i].substring(keyValue[i].indexOf("=")+1);
            }
            i++;
        }
        return null;

    }
}
