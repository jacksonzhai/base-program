package array.sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void BubbleSort(int[] nums) {
        if (nums == null) return;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            //是否发生交换
            boolean flag = false;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    public static void SelectSort(int[] nums) {
        if (nums == null) return;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }


        }
    }

    public static void InsertSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int cu = nums[i];
            int j = i - 1;
            while (j >= 0 && cu < nums[j]) {
                nums[j + 1] = nums[j];
                j--;

            }
            if(j!=i-1){
                nums[j+1] = cu;
            }
        }
    }
    public static void quickSort(int[] nums,int start,int end){

        if(nums==null){
            return ;
        }
        if((start>end || start<0)){
            return;
        }

        int p = partition2(nums,start,end);
        if(p>start){
            quickSort(nums,start,p-1);
        }
        if(p<end)
        {
            quickSort(nums,p+1,end);
        }


    }
    public static  int partition(int[] nums,int start,int end){
        if(nums==null){
            return -1;
        }
        if((start>end || start<0)){
            return -1;
        }
        int index = new Random().nextInt(end-start+1) + start;
        int temp = nums[index];
        nums[index] = nums[end];
        nums[end] = temp;
        int small = start-1;
        int flag = nums[end];
        for(int i = start;i<end;i++){
            if(nums[i]<flag) {
                small++;
                if(small !=i){
                    int te = nums[i];
                    nums[i] = nums[small];
                    nums[small] = te;
                }
            }

        }
        small++;
        int t = nums[end];
        nums[end] = nums[small];
        nums[small] = t;
        return small;
    }

    public static int partition2(int[] nums,int start,int end){
        if(nums==null){
            return -1;
        }
        if((start>end || start<0)){
            return -1;
        }
        int i = start;
        int j = end-1;
        while(i<=j){
            while(i<=j&&nums[i]<nums[end]){i++;}
            while(i<=j&&nums[j]>=nums[end]){j--;}
            if(i<j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;j--;
            }


        }
        int t = nums[j+1];
        nums[j+1] = nums[end];
        nums[end] = t;
        return j+1;


    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 4, 1, 3, 7, 5, 6, 9, 8};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
