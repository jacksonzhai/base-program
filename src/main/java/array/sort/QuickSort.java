package array.sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] num, int l, int h){
        if(l>=h){
            return;
        }
        int p = sort(num,l,h);
        quickSort(num,l,p-1);
        quickSort(num,p+1,h);
    }
    public static int sort(int[] num,int l, int h){
          int flag = num[h];
          int i = l;
          int j = h-1;
          while(i<j){
              while(i<=j&&num[j]>=flag){
                  j--;
              }
              while(i<=j&&num[i]<flag){
                  i++;
              }
              if(i<j) {
                  int temp = num[i];
                  num[i] = num[j];
                  num[j] = temp;
              }

          }
          num[h] = num[i];
          num[i] = flag;
          return i;

    }
    public static void main(String[] args) {
        int[] num = new int[]{1,5,0,4,6,2,3,9,8,7,7,7,7};
        int[] n = {1,0,8,7,4,5,122,56,10};
        quickSort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

}
