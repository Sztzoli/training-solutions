package properties;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Properties;

public class DatabaseConfiguration {
    private Properties config;

    public DatabaseConfiguration(File file) {

        try (FileInputStream fileInputStream = new FileInputStream(file)){

            load(fileInputStream);

        } catch (IOException ioe){
            throw new IllegalArgumentException("Cannot read file",ioe);
        }
    }

    public DatabaseConfiguration() {
        try (InputStream inputStream = DatabaseConfiguration.class.getResourceAsStream("/db.properties")){
            load(inputStream);
        } catch (IOException ioe){
            throw new IllegalArgumentException("Cannot read file",ioe);
        }
    }

    private Properties load(InputStream inputStream) {
        config = new Properties();
        try (
                InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
        ) {
            config.load(reader);
            return config;
        } catch (IOException ioe) {
            throw new RuntimeException("Cannot read properties file from inputstream", ioe);
        }
    }

    public String getHost() {
        return config.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(config.getProperty("db.port"));
    }


    public String getSchema() {
        return config.getProperty("db.schema");
    }
}
