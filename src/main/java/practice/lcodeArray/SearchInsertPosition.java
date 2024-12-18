package practice.lcodeArray;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int position =-1;
        int nearestDistance=Integer.MAX_VALUE;
        int indexOfNearestPosition=-1;
        if(nums.length>0 && target<nums[0]){
            return 0;
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i]==target){
                position = i;
                break;
            }
            var distance = Math.abs(nums[i]-target);
            if(distance<nearestDistance){
                nearestDistance = distance;
                indexOfNearestPosition =i;
            }
        }
        if(position >=0){
            return position;
        }else{
            if(target<nums[indexOfNearestPosition]){
                return indexOfNearestPosition;
            }
            return indexOfNearestPosition+1;
        }

    }
}
