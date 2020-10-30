package array;


import java.util.Arrays;

public class ArrayHandler {

    boolean contains(int[] source, int itemToFind) {
        boolean isContains=false;
        for (int array: source
             ) {
            if (array==itemToFind){
                isContains=true;
            }
        }
        return isContains;
    }

    int find(int[] source, int itemToFind){
        for (int i = 0; i < source.length; i++) {
            if (source[i]==itemToFind) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        ArrayHandler arrayHandler= new ArrayHandler();

        int [] array={0, 1, 2, 3, 4, 5, 6, 7, 8};


        System.out.println(arrayHandler.contains(array,3));
        System.out.println(arrayHandler.find(array,11));

    }
}
