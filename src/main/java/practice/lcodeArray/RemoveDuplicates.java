package practice.lcodeArray;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        var result =Arrays.stream(nums).
                mapToObj(n->Integer.valueOf(n)).distinct().collect(Collectors.toList());
        for(int i=0;i<result.size();i++){
            nums[i] = result.get(i);
        }
        return result.size();
    }

    public static void main(String arg[]){

    }
}
