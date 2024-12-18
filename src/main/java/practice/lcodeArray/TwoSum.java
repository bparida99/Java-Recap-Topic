package practice.lcodeArray;

public class TwoSum {


    public static void main(String arg[]){
        int[] inputArr = {2,7,11,15};
        var result = findOutPut(inputArr,9);
        System.out.println(result[0]+" "+result[1]);
    }

    private static int[] findOutPut(int[] nums,int target) {
        int first=-1;
        int last=-1;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
               if(nums[i]+nums[j]==target){
                   first = i;
                   last =j;
                   break;
               }
            }
        }
        int[] output = {first,last};
        return output;
    }
}
