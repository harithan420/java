// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        int arr[] = {10, 20, 4};
        System.out.println(largeElement(arr));
        System.out.println(largeElement2(arr));
        System.out.println(largeElement3(arr));
        System.out.println(secondlarge1(arr));
         int arr2[] = {10, 20, 4};
        System.out.println(secondlarge2(arr2));
        System.out.println(secondlarge3(arr2));
        int[] minMax = minMax(arr2);
        System.out.println("min"+minMax[0]);
        System.out.println("max"+minMax[1]);
        int[] minMax2 = minMax2(arr2);
        System.out.println("min"+minMax2[0]);
        System.out.println("max"+minMax2[1]);
        int arr5[] = {6, 4, 2, -2, 5, 3, 2, 2, -1, -1, 4};
        List<Integer> res =localMinMax(arr5);
        for(int num : res){
            System.out.println(num+" ");
        }
    }
    public static int largeElement(int[] arr){
        int ans = 0;
        for(int i=0; i<arr.length;i++){
            ans=Math.max(ans, arr[i]);
        }
        return ans;
    }
    public static int largeElement2(int[] arr){
        return largeElement2Helper(arr, 0);
    }
    public static int largeElement2Helper(int[] arr, int idx){
        if(idx==arr.length-1){
            return arr[idx];
        }
        int recMax=largeElement2Helper(arr,idx+1);
        return Math.max(arr[idx], recMax);
    }
    public static int largeElement3(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
    public static int secondlarge1(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-2];
    }
    public static int secondlarge2(int[] arr){
        int first = 0, second=0;
        for(int i=0; i<arr.length;i++){
           if(arr[i]>first){
               second=first;
               first=arr[i];
           } else if(arr[i]>second){
               second=arr[i];
           }
        }
        return second;
    }
     public static int secondlarge3(int[] arr){
        int ans = 0, secmax=0;
        for(int i=0; i<arr.length;i++){
            ans=Math.max(ans, arr[i]);
        }
        for(int i=0; i<arr.length;i++){
            if(arr[i]<ans){
                secmax=Math.max(secmax, arr[i]);
            }
        }
        return secmax;
    }
    public static int[] minMax(int[] arr){
        Arrays.sort(arr);
        return new int[] {arr[0], arr[arr.length-1]};
    }
    public static int[] minMax2(int[] arr){
        int max = 0,min=Integer.MAX_VALUE;
        for(int i=0; i<arr.length;i++){
            max=Math.max(max, arr[i]);
            min=Math.min(min, arr[i]);
        }
        return new int[] {min,max};
    }
    public static List<Integer> localMinMax(int[] arr){
        List<Integer> res = new ArrayList<>();
        res.add(arr[0]);
        boolean goingUp=false,goingDown=false;
        for(int i=1; i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                if(goingDown){
                    res.add(arr[i-1]);
                }
                goingUp=true;
                goingDown=false;
            } else{
                if(goingUp){
                    res.add(arr[i-1]);
                }
                goingDown=true;
                goingUp=false;
            }
        }
        res.add(arr[arr.length-1]);
        return res;
    }
}