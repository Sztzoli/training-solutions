package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream outputStream, List<String> shoppingList) {
       try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))){
           for (String item : shoppingList) {
               bufferedWriter.write(item);
               bufferedWriter.newLine();
           }
       } catch (IOException ioe) {
           throw new IllegalStateException("can not write file", ioe);
       }
    }


    public List<String> loadShoppingList(InputStream inputStream) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            while ((line=bufferedReader.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file");
        }
    }
}
