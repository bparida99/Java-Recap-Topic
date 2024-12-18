package practice.lcodeArray;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveValue {

    public int removeElement(int[] nums, int val) {
        var result = Arrays.stream(nums).mapToObj(n->Integer.valueOf(n))
                .filter(n->n.intValue()!=val).collect(Collectors.toList());
        for (int i=0;i<result.size();i++){
            nums[i] = result.get(i);
        }
        return result.size();
    }

    public static void main(String arg[]){

    }
}
