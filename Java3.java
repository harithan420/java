// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.util.ArrayList;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        int arr[] = {10, 20, 30, 40, 50};
        System.out.println(isSorted(arr));
        System.out.println(isSorted2(arr));
        int arr2[] = {2, 4, 5};
        int[] res = mulAdj(arr2);
        for(int num :res){
           System.out.print(num+" "); 
        }
        System.out.println();
        int[] res2 = mulAdj2(arr2);
        for(int num :res2){
           System.out.print(num+" "); 
        }
        System.out.println();
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        int[] res3 = reverse(arr3);
        for(int num :res3){
           System.out.print(num+" "); 
        }
        System.out.println();
        int[] arr4 = {12, 11, 10, 9, 8, 7};
        int[] res4 = reverse2(arr4);
        for(int num :res4){
           System.out.print(num+" "); 
        }
        System.out.println();
        int[] arr5 = {13, 14, 15, 16, 17, 18};
        int[] res5 = reverse3(arr5);
        for(int num :res5){
           System.out.print(num+" "); 
        }
         System.out.println();
        int[] arr6 = {24, 23, 22, 21, 20, 19};
        int[] res6 = reverse4(arr6);
        for(int num :res6){
           System.out.print(num+" "); 
        }
        System.out.println();
        int arr7[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        int[] res7 = reverseGroup(arr7, k);
        for(int num :res7){
           System.out.print(num+" "); 
        }
        System.out.println();
        int arr8[] = {1, 2, 3, 4, 5, 6};
        int d = 2;
        int[] res8 = rotate(arr8, d);
        for(int num :res8){
           System.out.print(num+" "); 
        }
         System.out.println();
         int arr9[] = {1, 2, 3, 4, 5, 6};
        int d2 = 3;
        int[] res9 = rotate2(arr9, d2);
        for(int num :res9){
           System.out.print(num+" "); 
        }
        System.out.println();
         int[] arr10 = {1, 2, 3, 4, 5, 6};
         int d3=2;
        int[] res10 = rotate3(arr10, d3);
        for(int num :res10){
           System.out.print(num+" "); 
        }
        System.out.println();
         int[] arr11 = {1, 2, 3, 4, 5, 6};
         int d4=3;
        int[] res11 = rotate4(arr11, d4);
        for(int num :res11){
           System.out.print(num+" "); 
        }
        
    }
    public static boolean isSorted(int[] arr){
        for(int i=1; i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }
    public static boolean isSorted2(int[] arr){
        return isSorted2Helper(arr,arr.length);
    }
     public static boolean isSorted2Helper(int[] arr, int n){
         if(n<=1){
             return true;
         }
        return arr[n-1]>=arr[n-2] && isSorted2Helper(arr, n-1);
    }
    public static int[] mulAdj(int[] arr){
        int[] res = new int[arr.length];
        for(int i=0; i<arr.length;i++){
            if(i==0){
                res[0]=arr[0]*arr[1];
            } else if(i==arr.length-1){
                res[arr.length-1]=arr[arr.length-1]*arr[arr.length-2];
            } else{
                res[i] = arr[i-1]*arr[i]*arr[i+1];
            }
        }
        return res;
    }
     public static int[] mulAdj2(int[] arr){
         int prev=0,curr=0;
        for(int i=0; i<arr.length;i++){
            curr=arr[i];
            if(i==0){
                arr[0]=arr[0]*arr[1];
            } else if(i==arr.length-1){
                arr[arr.length-1]=arr[arr.length-1]*prev;
            } else{
                arr[i] = prev*curr*arr[i+1];
            }
            prev=curr;
        }
        return arr;
    }
    
    public static int[] reverse(int[] arr){
        int l=0,r=arr.length-1;
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
        return arr;
    }
    public static int[] reverse2(int[] arr){
        int[] res = new int[arr.length];
        int c=0;
        for(int i=arr.length-1;i>=0;i--){
            res[c]=arr[i];
            c++;
        }
        return res;
    }
    public static int[] reverse3(int[] arr){
        int temp=0,n=arr.length;
        for(int i=0;i<n/2;i++){
            temp=arr[i];
            arr[i]= arr[n-1-i];
            arr[n-1-i]=temp;
        }
        return arr;
    }
    public static int[] reverse4(int[] arr){
       List<Integer> list = Arrays.stream(arr)
                               .boxed()
                               .collect(Collectors.toList());
        Collections.reverse(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static int[] reverseGroup(int[] arr, int k){
        int l=0,r=0, n=arr.length;
        for(int i=0; i<=n-2;i+=k){
            l=i;
            r=i+k-1<n?(i+k-1):n-1;
            while(l<r){
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++;
                r--;
            }
        }
        return arr;
       
    }
    
     public static int[] rotate(int[] arr, int k){
        int n=arr.length;
        while(k>0){
            int first= arr[n-1];
            for(int i=n-1; i>=0;i--){
                if(i==0){
                    arr[i]=first;  
                } else {
                    arr[i]=arr[i-1];
                }
            }
            k--;
        }
        return arr;
    }
    public static int[] rotate2(int[] arr, int k){
        int n=arr.length;
        int[] res = new int[n];
        for(int i=0; i<n;i++){
            res[i] = (i+k) <= (n-1) ? arr[i+k]: arr[(i+k)-n];
        }
        return res;
    }
    
    public static int[] rotate3(int[] arr, int k){
         int n = arr.length;
    k = k % n;

    reverse(arr, 0, n - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);

    return arr;
    }
    private static void reverse(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

public static int[] rotate4(int[] arr, int d){
    int n=arr.length;
       d=d%n;
       int cycles=gcd(n,d);
       for (int i = 0; i < cycles; i++) {
            int currIdx = i;
            int currEle = arr[currIdx];
            do {
                int nextIdx = (currIdx + d) % n;
                int nextEle = arr[nextIdx];
                arr[nextIdx] = currEle;
                currEle = nextEle;
                currIdx = nextIdx;
            } while (currIdx != i);
        }
        return arr;
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    
    
}