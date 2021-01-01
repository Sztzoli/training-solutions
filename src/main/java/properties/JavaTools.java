package properties;


import java.io.IOException;
import java.io.InputStream;


import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {

    private Properties tools;

    public JavaTools() {
        try (
                InputStream resource = JavaTools.class.getResourceAsStream("/javatools.properties")
        ) {
            tools = load(resource);
        } catch (IOException ioe) {
            throw new RuntimeException("Cannot read file from classpath", ioe);
        }
    }

    private Properties load(InputStream inputStream) {
        Properties result = new Properties();
        try (
                InputStreamReader reader = new InputStreamReader(inputStream)
        ) {
            result.load(reader);
            return result;
        } catch (IOException ioe) {
            throw new RuntimeException("Cannot read properties file from inputstream", ioe);
        }
    }

    public Set<String> getToolKeys() {
        Set<String> result = new HashSet<>();
        Set<String> keys;

        keys= tools.stringPropertyNames();
        for (String key : keys ) {
            if (key.contains("name"))
            result.add(key.substring(0,key.indexOf('.')));
        }
        return result;
    }

    public Set<String> getTools() {
        Set<String> result = new HashSet<>();


        for (String key : getToolKeys() ) {
            result.add(getName(key));
        }
        return result;
    }


    public String getName(String key) {
        return tools.getProperty(key+".name");
    }


    public String getUrl(String url) {
        return tools.getProperty(url+".url");
    }


}
