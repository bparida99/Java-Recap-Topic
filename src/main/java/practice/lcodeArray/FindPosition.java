package practice.lcodeArray;

public class FindPosition {

    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < nums.length; i++) {
            if (first == -1 && nums[i] == target) {
                first = i;
            }
            if (first != -1 && nums[i] == target) {
                last = i;
            }
        }
        int[] result = {first, last};
        return result;
    }
}
