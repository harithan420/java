 Online Java Compiler
 Use this editor to write, compile and run your Java code online
import java.util.Scanner;
import java.lang.Math;
class Main {
    public static void main(String[] args) {
        System.out.println(Start small. Ship something.);
        Scanner sc = new Scanner(System.in);
        System.out.println(Enter name);
        String name = sc.next();
        if(name.contains(Hari)){
            System.out.println(Welcome);
        } else if(name.contains(tha)){
            System.out.println(Most Welcome);
        } else {
            System.out.println(Bye );
        }
        String day=Monday;
        switch(day){
            case Monday
                System.out.println(mon);
                break;
            case Tuesday
                System.out.println(tue);
                break;
            case Staurday
                System.out.println(sat);
                break;
            default
                System.out.println(hol);
                
        }
        int x=0;
        System.out.println((x  20)  greater than 20  less than 20);
        System.out.println((x  0)  x is positive(x0x is negative x is zero));
        for(int i=0; i5;i++){
            System.out.println(i);
        }
        int[] nums = {1,2,3,4};
        for(int num  nums){
            System.out.println(num);
        }
        for(int i=0, j=10; i5&& j5;i++,j--){
            System.out.println(i+-+j);
        }
        for(;;){
            System.out.println(Hey);
            infinite
        }
        for(int i=1; i5;i++){
            for(int j=1; j5 ;j++){
                System.out.print(i  j+  );
            }
             System.out.println();
        }
        for(int i=2; i=10;i+=2){
            System.out.println(i);
        }
        int count=0;
        while(count5){
            System.out.println(Hello);
            count++;
        }
        built-in funcs
        double sqrt= Math.sqrt(25);
        System.out.println(sqrt);
        
        user-defined
        int square= calcSquare(5);
        System.out.println(square);
        Car c1 = new Car();
    c1.model=Tesla;
    c1.year=2009;
    System.out.println(My car is +c1.model+ +c1.year);
    c1.start();
    
    Stack s = new Stack();
    s.push(100);
    s.push(200);
    s.push(300);
    s.push(400);
    s.push(500);
    s.push(600);
    s.display();
    s.pop();
    s.pop();
    s.pop();
    s.pop();
    s.pop();
    s.pop();
        

    }
    public static int calcSquare(int n){
        return nn;
    }
    
}

class Car{
    public String model;
    public int year;
    public void start(){
        System.out.println(Car started);
    }
}

class Stack{
    int[] arr = new int[5];
    int top=-1;
    public void push(int x){
         if(top==4){
             System.out.println(Overflow);
             return;
        }
        top++;
        System.out.println(adding at+top);
        arr[top]=x;
    }
    public void pop(){
        if(top==-1){
             System.out.println(None found);
             return;
        }
        System.out.println(Popped+arr[top]);
        top--;
    }
    void display(){
        for(int i=top; i=0;i--){
            System.out.println(arr[i]);
        }
    }
}