import java.util.Arrays;
import java.util.HashMap;

public class twoSum {

        static public int[] TwoSum(int[] nums, int target) {
            HashMap<Integer,Integer> map=new HashMap<>();
            int complement;
            for(int i=0;i<nums.length;i++){
                complement=target-nums[i];
                if(map.containsKey(complement))
                {
                    return new int[] {map.get(complement),i};
                }
                else
                    map.put(nums[i],i);

            }
            return new int[]{-1,-1};
        }




    public static void main(String[] args){
        int arr[]=new int[]{2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(TwoSum(arr,target)));
    }

}
