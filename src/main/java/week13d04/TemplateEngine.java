package week13d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class TemplateEngine {

    public void merge(BufferedReader reader, Map<String, Object> values, BufferedWriter writer) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {

                String merged = merge(line, values);
                writer.write(merged);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

    }

    private String merge(String line, Map<String, Object> values) {
        int index = 0;
        String result = line;
        while (result.indexOf("{")>0){
            int indexOfOpen = result.indexOf("{",index);
            if (indexOfOpen >= 0){
                int indexOfClose = result.indexOf("}",index);
                String key = result.substring(indexOfOpen+1,indexOfClose);
                Object value = values.get(key);
                String valueAsString;
                if (value instanceof LocalDate) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
                    valueAsString = formatter.format((LocalDate)value);

                }
                else if (value instanceof Double) {
                    NumberFormat format = DecimalFormat.getCurrencyInstance(new Locale("hu", "HU"));
                    valueAsString = format.format(value);
                }
                else {
                    valueAsString = value.toString();
                }

                result = result.replace("{"+key+"}",valueAsString);
                index = indexOfClose;
            }
        }
        return result + "\n";
    }

    public static void main(String[] args) {
        Path Template = Path.of("template.txt");
        Map<String, Object> values =
                Map.of("nev", "John Doe",
                        "datum", LocalDate.of(2021, 1, 1),
                        "osszeg", 456.12,
                        "hatarido", LocalDate.of(2021, 2, 1));
        StringWriter sw = new StringWriter();

        try (BufferedWriter writer = new BufferedWriter(sw);
                BufferedReader reader = Files.newBufferedReader(Template)) {
            new TemplateEngine().merge(reader, values, writer);
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file, ioe");
        }
        //Tesztben sohe sout, assert csak
        System.out.println(sw.toString());
    }

}
