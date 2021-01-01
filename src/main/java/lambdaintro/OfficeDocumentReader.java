package lambdaintro;

import java.io.File;
import java.util.*;

public class OfficeDocumentReader {

    String regex = ".*\\.(docx|xlsx|pptx)$";

    public List<File> listOfficeDocuments(File path){
        List<File> fileList = Arrays.asList(path.listFiles(f ->f.isFile() &&  f.getName().toLowerCase().matches(regex)));

        fileList.sort(Comparator.comparing(File::getName));
        return fileList;

    }

}
