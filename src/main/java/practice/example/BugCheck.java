package practice.example;

import java.util.*;
import java.util.stream.Collectors;

public class BugCheck {
    public static int threeSum(int[] nums,int target) {
        int close=Integer.MAX_VALUE-1;
        int finalSum=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    int distance= Math.abs(target -sum);
                    if(distance==Math.min(close,distance)){
                        finalSum =sum;
                        close=distance;
                    }

                }
            }
        }
        return finalSum;
    }
    public static int check(){
        try {
            return 10;
        }finally {
            return 20;
        }
    }

    public static void main(String arg[]){
        List list = List.of(1,2,8,3,4,9,0);
        Collections.sort(list);
        System.out.println(list.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get());
        list.stream().sorted().skip(0).findFirst();
       System.out.println(threeSum(new int[]{0,0,0},1));
        System.out.println(Math.round(2.3));

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");

        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
                Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)).
                entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).collect(
                        Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)
                );

    }
}
