package practice.lcodeArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public int removeDuplicates2(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] nums2 = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
                nums2[index] = nums[i];
                index++;
            } else {
                if (map.get(nums[i]) == 1) {
                    map.put(nums[i], 2);
                    nums2[index] = nums[i];
                    index++;
                }
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[i] = nums2[i];
        }
        return map.entrySet().stream().collect(Collectors.summingInt(Map.Entry::getValue));
    }

    public int removeDuplicates(int[] nums) {
        var result =Arrays.stream(nums).
                mapToObj(n->Integer.valueOf(n)).distinct().collect(Collectors.toList());
        for(int i=0;i<result.size();i++){
            nums[i] = result.get(i);
        }
        return result.size();
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = nums[i];
            if (currentSum > maxsum) {
                maxsum = currentSum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                currentSum = currentSum + nums[j];
                if (currentSum > maxsum) {
                    maxsum = currentSum;
                }
            }

        }
        return maxsum;
    }
    public static void main(String arg[]){

    }
}
