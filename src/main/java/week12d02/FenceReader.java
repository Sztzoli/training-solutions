package week12d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FenceReader {

    public static final String REGEX = " ";

    public List<Fence> read() {
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader
                        (getClass().getResourceAsStream("kerites.txt")))) {
            List<Fence> fenceList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(REGEX);
                SideType sideType = SideType.convertToSideType(parts[0]);
                int widthOfGround = Integer.parseInt(parts[1]);
                String typeOfFence = parts[2];
                fenceList.add(new Fence(sideType, widthOfGround, typeOfFence));
            }
            return fenceList;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }


}
