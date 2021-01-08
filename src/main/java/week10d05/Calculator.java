package week10d05;

import java.util.*;

public class Calculator {
    public void findMinMaxSum(int[] arr) {
        Arrays.sort(arr);
        int min = Arrays.stream(arr)
                .limit(4)
                .sum();


        int [] arrR = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrR[i] = arr[arr.length-i-1];
        }
        int max = Arrays.stream(arrR).limit(4).sum();


        System.out.println(min + " "+ max);



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        String s=scanner.nextLine();
        while (!s.isBlank()){
            try {
            numbers.add(Integer.parseInt(s));
               s=scanner.nextLine();
             } catch (NumberFormatException e) {
                System.out.println("Számot írj");
            }
        }
        int [] data = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            data[i] = numbers.get(i);
        }
        Calculator calculator = new Calculator();
        int[] arr = {1, 3, 5, 7, 9};
        calculator.findMinMaxSum(arr);
        int[] arr2 = {1, 3, 5};
        calculator.findMinMaxSum(arr2);
        calculator.findMinMaxSum(data);
    }
}
