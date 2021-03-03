package covid;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;

public class VaccinatedByCityWriter {

    public void writer(List<Citizen> citizens, String pathString) {
        LocalTime time = LocalTime.of(8, 0);

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("src/main/resources/covid/cities/" + pathString))) {
            writer.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
            for (Citizen citizen : citizens) {
                String line = String.format("%s;%s;%s;%d;%s;%s",
                        time.toString(), citizen.getName(), citizen.getZip(), citizen.getAge(), citizen.getEmail(), citizen.getTaj());
                writer.write(line + "\n");
                time = time.plusMinutes(30);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot write file");
        }
    }

}
