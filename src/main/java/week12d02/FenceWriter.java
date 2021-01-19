package week12d02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FenceWriter {



    public void write(List<Fence> list) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("src/main/resources/week12d02/Odd_Side.txt"))) {
            int count = 1;
            for (Fence fence: list) {
                if (fence.getSideType()==SideType.ODD_SIDE){
                    writer.write(String.format("(%d)",count));
                    for (int i = 0; i < fence.getWidthOFGround(); i++) {
                        writer.write(fence.getTypeOfFence());
                    }
                    count += 2;
                }
            }
        }catch (IOException ioe) {
            throw new IllegalArgumentException("Can not write file");
        }
    }
}
