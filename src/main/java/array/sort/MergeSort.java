package array.sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] num,int l,int h){
        if(l>=h){
            return;
        }
        int m = l+((h-l)>>1);
        mergeSort(num,l,m);
        mergeSort(num,m+1,h);
        merge(num,l,m,h);
    }
    public static void merge(int[] num,int l,int m,int h){
         int[] temp = new int[h-l+1];
         int left = l;
         int right = m+1;
         int index = 0;
         while(left<=m&&right<=h){
             if(num[left]<num[right]){
                 temp[index++] = num[left++];
             }else
             {
                 temp[index++] = num[right++];
             }
         }
         while(left<=m){
             temp[index++] = num[left++];
         }
         while (right<=h){
             temp[index++] = num[right++];
         }
         for(int i = 0;i<index;i++){
             num[l++]=temp[i];
         }
    }
    public static void loopMergeSort(int[] num, int l,int h){
        if(l>=h){
            return;
        }
        int length = h-l+1;
        int step = 1;
        while (step<=length){
            for(int i = l;i+step<=h;i+=step*2){
                int low = i;
                int high = i+2*step-1;

                if(high>=h){
                    high = h;
                }
                int mid = i+((high-i)>>1);
                merge(num,low,mid,high);
            }
            step *=2;

        }
    }



    public static void main(String[] args) {
        int[] num = new int[]{1,5,0,4,6,2,3,9,8,7};
        int[] n = {1,0,8,7,4,5,122,56,10};
        loopMergeSort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

}
