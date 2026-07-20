// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.List;
import java.util.ArrayList;
class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        System.out.println(isPrime(4));
        System.out.println(isPrime2(7));
        System.out.println(isPrime3(9));
        System.out.println(isArm(150));
        System.out.println(isArm2(153));
        System.out.println(trailFact(10));
        System.out.println(trailFact2(5));
        System.out.println(primeFact(25));
        System.out.println(primeFact2(18));
        System.out.println(primeFact3(18));
        System.out.println(allDiv(18));
        System.out.println(allDiv2(18));
        butterfly(2);
        System.out.println(palindrome(121));
        System.out.println(palindrome2(31213));
        System.out.println(palindrome2(5312135));
        towerOfHanoi(5, 'A', 'C', 'B');
    }
    public static boolean isPrime(int n){
        for(int i=2; i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPrime2(int n){
        for(int i=2; i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPrime3(int n){
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for(int i=5; i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }
    public static boolean isArm(int n){
        int c=Integer.toString(n).length();
        int orig=n;
        int sum=0;
        for(int i=0; i<c;i++){
            sum+=Math.pow(orig%10,c);
            orig=orig/10;
        }
        if(sum == n){
            return true;
        }
        return false;
    }
     public static boolean isArm2(int n){
         String s= Integer.toString(n);
        int c=Integer.toString(n).length();
        int sum=0;
        for(char ch : s.toCharArray()){
            sum+=Math.pow(ch-'0',c);
        }
        if(sum == n){
            return true;
        }
        return false;
    }
    public static int trailFact(int n){
        int fact=1;
         for(int i=1; i<=n;i++){
             fact*=i;
         }
         int count=0;
         while(fact%10==0){
             count++;
             fact=fact/10;
         }
         return count;
    }
     public static int trailFact2(int n){
        int count=0;
         for(int i=5; n/i>=1;i*=5){
             count+=n/i;
         }
        
         return count;
    }
    public static List<Integer> primeFact(int n){
        List<Integer> l = new ArrayList<>();
        
        for(int i=2; i<=n;i++){
            while(n%i==0 && n>0 ){
                l.add(i);
                n=n/i;
            }
        }
        return l;
    }
    public static List<Integer> primeFact2(int n){
        List<Integer> l = new ArrayList<>();
        
        for(int i=2; i*i<=n;i++){
            while(n%i==0 && n>0 ){
                l.add(i);
                n=n/i;
            }
        }
        return l;
    }
    public static List<Integer> primeFact3(int n){
        List<Integer> l = new ArrayList<>();
        while(n%2==0){
            l.add(2);
            n=n/2;
        }
        
        for(int i=3; i*i<=n;i+=2){
            while(n%i==0 && n>0 ){
                l.add(i);
                n=n/i;
            }
        }
        return l;
    }
    public static List<Integer> allDiv(int n){
        List<Integer> l = new ArrayList<>();
        for(int i=1; i<=n;i++){
            if(n%i==0){
                l.add(i);
            }
        }
        return l;
    }
    public static List<Integer> allDiv2(int n){
        List<Integer> l = new ArrayList<>();
        int num=1;
        while(num*num<=n){
            if(n%num==0){
                if(n/num==num){
                    l.add(num);
                } else{
                    l.add(num);
                    l.add(n/num);
                }
            }
            num++;
        }
        return l;
    }
    public static void butterfly(int n){
        int spaces=(2*n-1), stars=0;
        for(int i=1;i<=2*n-1;i++){
            if(i<=n){
                spaces=spaces-2;
                stars++;
            } else{
                spaces=spaces+2;
                stars--;
            }
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
        }
        for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
        }
        for (int j = 1; j <= stars; j++) {
            if (j != n) {
                System.out.print("*");
            }
        }
            System.out.println();
        }
        
    }
    public static boolean palindrome(int n){
        int temp = Math.abs(n);
        int rev=0;
        while(temp != 0){
            rev = (rev*10)+temp%10;
            temp=temp/10;
        }
        return (rev == n);
    }
    public static boolean palindrome2(int n){
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
    public static boolean palindrome3(int n){
        String s = Integer.toString(n);
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void towerOfHanoi(int n, char from, char to , char aux){
        if (n==0){
            return;
        }
        towerOfHanoi(n-1, from, aux, to);
        System.out.println("Disk " + n + " moved from "
                           + from + " to "
                           + to);
       towerOfHanoi(n-1, aux, to, from);
        
    }
}