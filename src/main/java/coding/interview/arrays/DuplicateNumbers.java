package coding.interview.arrays;

public class DuplicateNumbers {
    //找出数组中重复的数字,在一个长度为n的数组里所有的数字都在0~n-1的范围内
    public static int  duplicate(int[] nums) {
        if (null == nums) {
            return -1;
        }
        int length = nums.length;
        for(int i = 0;i<length;i++){
            if(nums[i]<0||nums[i]>length-1){
                return -1;
            }
        }
        for(int i = 0;i<length;i++){
            while (nums[i]!=i){
                if(nums[i]== nums[nums[i]]){
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;

    }
    //不修改数组的情况下找出重复数字，在一个长度为n+1的数组里的所有数字都在1~n的范围内
    public static int duplicate2(int[] nums){
        if(null==nums){
            return -1;
        }
        int length = nums.length;
        int start = 1;
        int end = length-1;
        while(start<=end){
            int m = start + ((end-start)>>1);
            int count = countRange(nums,start,m);
            if(end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
                if(count>(m-start+1)) {
                    end = m;
                }else {
                    start = m+1;
                }
            }
        return -1;

    }
    public static int countRange(int[] nums,int start ,int end)
    {
        if(null == nums){
            return 0;
        }
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>=start&&nums[i]<=end){
                count++;
            }
        }
        return count;

    }
    public static boolean findIn2DArray(int[][] nums, int target){
        if(null==nums){
            return false;
        }
        //每一行都有可能为null
        int row = nums.length;
        for(int i =0;i<row ;i++){
            if(null == nums[i]){
                return false;
            }
        }
        int col = nums[0].length;
        int r = 0;
        int c = col-1;
        while(r<row&&c>=0){
            if(nums[r][c] == target){
                return true;

            }
            else{
                if(nums[r][c] >target)
                {
                    --c;
                }else {
                    ++r;
              }
            }

        }
     return false;
    }




    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        int [][] matrix = {
                {1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}
        };
        System.out.println(duplicate2(nums));
        System.out.println(findIn2DArray(matrix,2));
    }
}
