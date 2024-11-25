package practice.example;

import java.util.ArrayList;
import java.util.List;

public class HighestSumEx {

    public static void main(String arg[]){
        List<Integer> list = List.of(-1,-2,-3, 1, 2,-5, 3);
        int highestSum=0;
        for(int i=0;i<list.size();i++){
            int sum = 0;
            for(int j=i;j<list.size();j++){
                 sum = sum+list.get(j);
                highestSum =Math.max(sum,highestSum);
            }
        }
        System.out.println(highestSum);
    }
}
