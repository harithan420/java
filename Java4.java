// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = subarrays(arr);
        for(List<Integer> list: res){
         for(int num: list){
         System.out.print(num+" ");
         }
         System.out.println();
        }
        int[] arr2 = {1, 2, 3};
        List<List<Integer>> res2 = subarrays2(arr2);
        for(List<Integer> list: res2){
         for(int num: list){
         System.out.print(num+" ");
         }
         System.out.println();
        }
        int[] arr3 = {1, 2, 3, -4, -1, 4};
        int[] res3 = subarrays3(arr3);
         for(int num: res3){
            System.out.print(num+" ");
         }
         System.out.println();
         int prices[] = {7, 10, 1, 3, 6, 9, 2};
         System.out.println(maxProfit(prices));
         int prices2[] = {7, 6, 4, 3, 1};
         System.out.println(maxProfit2(prices2));
         int prices3[] = {100, 180, 260, 310, 40, 535, 695};
         System.out.println(maxProfitMul(prices3));
         int prices4[] = {100, 180, 260, 310, 40, 535, 695};
         System.out.println(maxProfitMul2(prices4));
         System.out.println(maxProfitMul3(prices4));
          System.out.println();
         int arr1[] = {16, 17, 4, 3, 5, 2};
         List<Integer> res5 = leader(arr1);
         for(int num: res5){
             System.out.print(num+" ");
         }
          System.out.println();
          int arr5[] = {1, 2, 3, 4, 5, 2};
           List<Integer> res6 = leader2(arr5);
         for(int num: res6){
             System.out.print(num+" ");
         }
          System.out.println();
    }
    public static  List<List<Integer>> subarrays(int[] arr){
        List<List<Integer>> sub = new ArrayList<>();
        int n=arr.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n;j++){
                List<Integer> sub1 = new ArrayList<>();
               for(int k=i;k<=j;k++){
                   sub1.add(arr[k]);
               }
                sub.add(sub1);
            }
           
        }
        return sub;
    }
    public static  List<List<Integer>> subarrays2(int[] arr){
        List<List<Integer>> res= new ArrayList<>();
        subarrays2Helper(arr,0,0,res);
        return res;
    }
    public static void subarrays2Helper(int[] arr, int start, int end, List<List<Integer>> res){
        if(end==arr.length){
            return;
        } else if(start>end){
            subarrays2Helper(arr, 0,end+1, res);
        } else{
            List<Integer> curr = new ArrayList<>();
            for (int i = start; i <= end; i++){
                curr.add(arr[i]);
            }
            res.add(new ArrayList<>(curr));
            subarrays2Helper(arr, start + 1, end, res);
        }
    }
   public static int[] subarrays3(int[] arr) {
    int n = arr.length;
    int[] pos = new int[n];
    int[] neg = new int[n];

    int posCount = 0, negCount = 0;

    // Separate positives and negatives
    for (int num : arr) {
        if (num >= 0)
            pos[posCount++] = num;
        else
            neg[negCount++] = num;
    }

    boolean startWithPositive = posCount >= negCount;

    int i = 0, j = 0, k = 0;

    // Alternate positives and negatives
    while (j < posCount && k < negCount) {
        if (startWithPositive) {
            arr[i++] = pos[j++];
            arr[i++] = neg[k++];
        } else {
            arr[i++] = neg[k++];
            arr[i++] = pos[j++];
        }
    }
    // Copy remaining positives
    while (j < posCount) {
        arr[i++] = pos[j++];
    }

    // Copy remaining negatives
    while (k < negCount) {
        arr[i++] = neg[k++];
    }

    return arr;
}

    public static int maxProfit(int[] prices){
        int max=0;
       for(int i=0; i<prices.length-1;i++){
           for(int j=i+1;j<prices.length;j++){
               max = Math.max(max, prices[j]-prices[i]);
           }
       }
       return max;
    }
    public static int maxProfit2(int[] prices){
        int min=prices[0], max=0;
        for(int i=1; i<prices.length-1;i++){
          max=Math.max(max, prices[i]-min);
          min=Math.min(min, prices[i]);
        }
       
       return max;
    }
    public static int maxProfitMul(int[] prices){
        return maxProfitRec(prices, 0, prices.length - 1);
    }
    public static int maxProfitRec(int[] prices, int start, int end){
        int res=0;
        for(int i=start;i<end;i++){
            for(int j=i+1;j<=end;j++){
                if(prices[j]>prices[i]){
                    int curr = (prices[j]-prices[i])+maxProfitRec(prices,start,i-1)+maxProfitRec(prices,j+1,end);
                    res=Math.max(res,curr);
                }
                
            }
        }
        
        return res;
    }
    public static int maxProfitMul2(int[] prices){
        int n= prices.length;
        int lMin=prices[0];
        int lMax=prices[0];
        int i=0;
        int res=0;
        while(i< n-1){
            while(i<n-1 && prices[i]>=prices[i+1]){
                i++;
            }
            lMin=prices[i];
            while(i<n-1 && prices[i]<=prices[i+1]){
                i++;
            }
            lMax=prices[i];
            res+=(lMax-lMin);
        }
        return res;
    }
    public static int maxProfitMul3(int[] prices){
        int n= prices.length;
        int res=0;
        for(int i=1; i<n;i++){
            if(prices[i]>prices[i-1]){
                res+=prices[i]-prices[i-1];
                }
                
        }
        return res;
    }
    public static List<Integer> leader(int[] arr){
        int n=arr.length;
        List<Integer> res = new ArrayList<>();
       for(int i=0;i<n-1;i++){
           int j;
           for(j=i+1;j<n;j++){
               if(arr[i]<arr[j]){
                   break;
               }
           }
           if(j==n){
                  res.add(arr[i]);
            }
       }
       res.add(arr[n-1]);
       return res;
    }
    public static List<Integer> leader2(int[] arr){
        int n=arr.length;
        List<Integer> res = new ArrayList<>();
        int max=arr[n-1];
        res.add(arr[n-1]);
       for(int i=n-2;i>=0;i--){
           if(arr[i]>max){
            res.add(arr[i]);
            max= Math.max(max, arr[i]);
           }
       }
       Collections.reverse(res);
       return res;
    }
}