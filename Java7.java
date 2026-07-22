// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        String s="-123";
        System.out.println(Integer.parseInt(s));
        System.out.println(atoi1(s));
        String s2 = "i love programming";
        System.out.println(s2.replace(" ","%20"));
        String s3 = "-11", s4 = "23";
        System.out.println(multiply(s3, s4));
        int mat[][] = {{1, 2},
                        {3, 4}};
        List<List<Integer>> res= matrixDiag(mat);
        for(List<Integer> l:res){
            for(int num: l){
               System.out.print(num+" "); 
            }
            System.out.println();
        }
    }
    public static int atoi1(String s){
        int ans=0, sign=1;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='-'){
                sign=-1;
            } else{
                ans+=(s.charAt(i)-'0')*Math.pow(10,s.length()-1-i);
            }
        }
        return ans*sign;
    }
     public static int multiply(String s1, String s2){
       int n1=s1.length(), n2=s2.length();
       int sign1= (s1.charAt(0)=='-')?-1:1;
       int sign2= (s2.charAt(0)=='-')?-1:1;
       if(s1.charAt(0)=='-'){
           s1=s1.substring(1);
       }
       if(s2.charAt(0)=='-'){
           s2=s2.substring(1);
       }
       System.out.println(s1+" "+s2);
       int prod=0,k=1;
       for(int i=0; i<s1.length();i++){
           k=1;
           for(int j=0;j<s2.length();j++){
               prod=prod*k+(s1.charAt(i)-'0')*(s2.charAt(j)-'0');
               k*=10;
           }
       }
       return prod*sign1*sign2;
    }
    public static List<List<Integer>> matrixDiag(int[][] matrix){
        int n = matrix.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<2*n-1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<matrix.length;i++){
             for(int j=0;j<matrix[0].length;j++){
                 list.get(i+j).add(matrix[i][j]);
             }
        }     
        return list;
    }
    
}