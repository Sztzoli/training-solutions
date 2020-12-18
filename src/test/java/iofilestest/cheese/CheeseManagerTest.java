package iofilestest.cheese;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheeseManagerTest {

    private CheeseManager cheeseManager = new CheeseManager();
    private List<Cheese> cheeseList = new ArrayList<>();
    private Path path;
    private Cheese cheese1;
    private Cheese cheese2;

    @TempDir
    public File folder;

    @BeforeEach
    void init() {
        File file = new File(folder, "test.bat");
        path = file.toPath();
        cheese1 = new Cheese("testCheese1", 100);
        cheese2 = new Cheese("testCheese2", 200);
        cheeseList.add(cheese1);
        cheeseList.add(cheese2);

    }


    @Test
    void testSaveToFile() throws IOException {
        cheeseManager.saveToFile(path, cheeseList);

        List<Cheese> temp = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            for (int i = 0; i < cheeseList.size(); i++) {
                String name = dataInputStream.readUTF();
                dataInputStream.readUTF();
                Double lactose = dataInputStream.readDouble();
                dataInputStream.readUTF();
                temp.add(new Cheese(name, lactose));
            }
        }

        assertEquals(temp, cheeseList);
    }


    @Test
    void findCheeseTest() throws IOException {
        try ( DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Cheese cheese : cheeseList) {
                dataOutputStream.writeUTF(cheese.getName());
                dataOutputStream.writeUTF(";");
                dataOutputStream.writeDouble(cheese.getLactoseContent());
                dataOutputStream.writeUTF("\n");
            }
        }

        assertEquals(cheese2, cheeseManager.findCheese(path, "testCheese2"));
    }
}