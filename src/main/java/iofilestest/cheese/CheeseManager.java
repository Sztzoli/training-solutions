package iofilestest.cheese;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheeseManager {

    public void saveToFile(Path file, List<Cheese> cheeseList) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            for (Cheese cheese : cheeseList) {
                dataOutputStream.writeUTF(cheese.getName());
                dataOutputStream.writeUTF(";");
                dataOutputStream.writeDouble(cheese.getLactoseContent());
                dataOutputStream.writeUTF("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("can not write file");
        }
    }



    public Cheese findCheese(Path file, String name) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(Files.newInputStream(file)))) {
            while (dataInputStream.available() > 0) {
                String cheeseName = dataInputStream.readUTF();
                dataInputStream.readUTF();
                double lactose = dataInputStream.readDouble();
                dataInputStream.readUTF();

                if (name.equals(cheeseName)) {

                    return new Cheese(name, lactose);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file");
        }
        throw new IllegalArgumentException("cheese name not exist");
    }


}
