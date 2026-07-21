// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        String s1 = "abc", s2 = "abc";
        System.out.println(s1.equals(s2));
        System.out.println(equality(s1,s2));
         String s= "abba";
         System.out.println(palindrome(s));
         System.out.println(palindrome2(s));
         System.out.println(palindrome3(s));
          System.out.println(palindrome4(s));
          String s3 = "geeksForgEeks";
          System.out.println(toggleCase(s3));
          System.out.println(toggleCase2(s3));
          System.out.println(toggleCase3(s3));
          String s4 = "geeksforgeeks"; char c1 = 'e';
          System.out.println(remove(s4, c1));
          String s5 = "geeksforgeeks"; char c2 = 'g';
          System.out.println(remove2(s5, c2));
          String s6 = "g  eeks   for ge  eeks  ";
          System.out.println(s6.replaceAll(" ",""));
          System.out.println(removeSpace2(s6));
          String s7 = "   abc d ";
          System.out.println(removeSpace3(s7));
          String s8 = "AXY", s9 = "ADXCPY";
          System.out.println(subSeq(s8, s9));
          System.out.println(subSeq2(s8, s9));
          System.out.println(nonRepeat1(s4));
          System.out.println(nonRepeat2(s4));
          System.out.println(nonRepeat3(s4));
          String s10 = "The quick brown fox jumps over the lazy dog";
          System.out.println(panagram1(s10));
          System.out.println(panagram2(s10));
    }
    public static boolean equality(String s1, String s2){
        if(s1.length()==s2.length()){
            for(int i=0; i<s1.length();i++){
                if(s1.charAt(i)!=s2.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean palindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
    public static boolean palindrome2(String s){
        int l=0, r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static boolean palindrome3(String s){
       int l=0, r=s.length()-1;
       return palindrome3Helper(s, l, r);
    }
     public static boolean palindrome3Helper(String s, int l, int r){
         if (l >= r){
            return true;
         }
            if(s.charAt(l)!=s.charAt(r)){
            return false;
            }
       
       return palindrome3Helper(s, l+1, r-1);
    }
    public static boolean palindrome4(String s){
        int n=s.length();
            for(int i=0; i<n/2;i++){
                if(s.charAt(i)!=s.charAt(n-1-i)){
                    return false;
                }
            }
        
        return true;    
    }
 
     public static String toggleCase(String s){
         String res="";
         for(int i=0; i<s.length();i++){
             char ch = s.charAt(i);
             if(Character.isUpperCase(ch)){
                res+=Character.toLowerCase(ch);   
             } else{
                 res+=Character.toUpperCase(ch);   
             }
         }
         return res;
    }
    public static String toggleCase2(String s){
         char[] arr = s.toCharArray();
         for(int i=0; i<s.length();i++){
             if(arr[i]>='a' && arr[i]<='z'){
                 arr[i] =(char)(arr[i]-32);
             } else if (arr[i] >= 'A' && arr[i] <= 'Z'){
                 arr[i] =(char)(arr[i]+32);
             }
         }
         return new String(arr);
    }
    public static String toggleCase3(String s){
         char[] chars = s.toCharArray();
         for(int i=0; i<chars.length;i++){
             if(Character.isAlphabetic(chars[i])){
                 chars[i]^=(1<<5);
             }
         }
         
         return new String(chars);
    }
     public static String remove(String s, char ch){
         return s.replaceAll(String.valueOf(ch),"");
    }
    public static String remove2(String s, char ch){
         StringBuilder sb = new StringBuilder(s);
         for(int i=0; i<sb.length();i++){
             if(sb.charAt(i) == ch){
                 sb.deleteCharAt(i);
                 i--;
             }
         }
         return sb.toString();
    }
    public static String remove3(String s, char ch){
         StringBuilder sb = new StringBuilder(s);
         for(int i=0; i<sb.length();i++){
             if(sb.charAt(i) == ch){
                 sb.deleteCharAt(i);
                 i--;
             }
         }
         return sb.toString();
    }
    public static String removeSpace2(String s){
        int n=s.length();
        char[] chars = s.toCharArray();
        for(int i=0; i<n;i++){
            if(chars[i]==' '){
                for(int j=i; j<n-1;j++){
                    chars[j]=chars[j+1];
                }
                n--;
                i--;
            }
        }
        return new String(chars, 0, n);
    }
    public static String removeSpace3(String s){
        int n=s.length();
        char[] arr = s.toCharArray();
        int i=0, itr=0;
        while(i < n){
            if(arr[i] != ' '){
                arr[itr++] = arr[i];
            }
            i++;
        }
        return new String(arr, 0, itr);
    }
    public static boolean subSeq(String s1, String s2){
       int m=s1.length(), n=s2.length();
        return isSubSeq(s1,s2,m,n);
    }
    public static boolean isSubSeq(String s1, String s2, int m, int n){
        if(m==0){
            return true;
            
        }
        if(n==0){
            return false;
        }
       if(s1.charAt(m-1) == s2.charAt(n-1)){
           return isSubSeq(s1, s2, m-1, n-1);
       } else{
           return isSubSeq(s1, s2, m, n-1);
       }
    }
    public static boolean subSeq2(String s1, String s2){
        int p1=0,p2=0; 
        while(p1<s1.length() && p2<s2.length()){
       if(s1.charAt(p1) == s2.charAt(p2)){
           p1++;
           p2++;
       } else{
           p2++;
       }
        }
        if(p1==s1.length()){
            return true;
        }
        return false;
    }
    public static char nonRepeat1(String s){
        int n=s.length();
        for(int i=0; i<n;i++){
            int count=0;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i) == s.charAt(j)){
                   count++; 
                }
            }
            if(count ==0){
                return s.charAt(i);
            }
        }
        return '$';
        
    }
    public static char nonRepeat2(String s){
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']+=1;
        }
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1){
                return s.charAt(i);
            }
        }
        return'$';
    }
    public static char nonRepeat3(String s){
        int[] freq = new int[26];
        Arrays.fill(freq,-1);
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==-1){
                freq[s.charAt(i)-'a']=i;
            } else{
                freq[s.charAt(i)-'a']=-2;
            }
        }
        int k=-1;
        for(int i=0;i<freq.length;i++){
            if (freq[i] >= 0 && (k == -1 || freq[i] < freq[k])) {
                k = i;
            }
        }
        return (k == -1) ? '$' : s.charAt(freq[k]);   
    }
    public static boolean panagram1(String s){
        for(char ch='a';ch<='z';ch++){
            boolean found=false;
            for (int i = 0; i < s.length(); i++) {
                if (ch == Character.toLowerCase(s.charAt(i))) {
                    found = true;
                    break;
                }
            }
             if (!found)
                return false;
        }
        return true;
    }
    public static boolean panagram2(String s){
         boolean[] vis = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Mark uppercase letters
            if (c >= 'A' && c <= 'Z')
                vis[c - 'A'] = true;

            // Mark lowercase letters
            else if (c >= 'a' && c <= 'z')
                vis[c - 'a'] = true;
        }

        // Check if all letters are present
        for (int i = 0; i < 26; i++) {
            if (!vis[i])
                return false;
        }
        return true;
    }
}