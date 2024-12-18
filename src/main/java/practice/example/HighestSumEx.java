package practice.example;

import java.util.ArrayList;
import java.util.List;

public class HighestSumEx {

    public static void main(String arg[]) {
        int[] arr = {-1, -2, -3, 1, 2, -5, 3};
        int highestSum = Integer.MIN_VALUE;
        int initial = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            if (i + 1 == arr.length) {
                highestSum = Math.max(sum, highestSum);
                if (highestSum == sum) {
                    initial = i;
                    end = i;
                }
            }
            for (int j = i + 1; j < arr.length; j++) {
                sum = sum + arr[j];
                highestSum = Math.max(sum, highestSum);
                if (highestSum == sum) {
                    initial = i;
                    end = j;
                }
            }
        }
        System.out.println(highestSum + " initial :" + initial + " end: " + end);

    }
}
