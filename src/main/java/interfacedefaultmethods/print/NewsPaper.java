package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable{
    private List<String> newsPaper=new ArrayList<>();

    @Override
    public int getLength() {
        return newsPaper.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return newsPaper.get(pageNumber);
    }


    public void addPage(String page) {
        newsPaper.add(page);
    }
}
