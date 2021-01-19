package week12d02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FenceMain {

    private final List<Fence> fenceList = new FenceReader().read();

    public List<Fence> getFenceList() {
        return new ArrayList<>(fenceList);
    }

    public List<Fence> sortedListByWidth() {
        List<Fence> list = new ArrayList<>(fenceList);
        list.sort(Comparator.comparingInt(Fence::getWidthOFGround).reversed());
        return list;
    }

    public int getHouseNumber() {
        Fence lastFence = fenceList.get(fenceList.size() - 1);
        int number = (int) fenceList.stream()
                .filter(value ->
                        value.getSideType() == lastFence.getSideType())
                .count();
        return (lastFence.getSideType() == SideType.EVEN_SIDE) ? (2 * number) : (2 * number - 1);
    }
    public static void main(String[] args) {
        FenceMain fenceMain = new FenceMain();
        System.out.println(fenceMain.getFenceList());
        System.out.println(fenceMain.sortedListByWidth());
        System.out.println(fenceMain.getHouseNumber());
        new FenceWriter().write(fenceMain.getFenceList());
    }


}
