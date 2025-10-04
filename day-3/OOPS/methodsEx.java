// to define a simple method
// learn about simple recursion

public class methodsEx{
    public static void main(String[] args) {
        add(); // method     
        recursion(5);      
    }

    public static void add(){
        int a = 10,b=20,c;
        c=a+b;
        System.out.println(c);
    }

    // with and without parameter - 2 Type
    // with and without return Type -2 Type 

    public static void recursion(int n){
        if(n==1)
            System.out.println(1);

        else{
            System.out.println(n);
            recursion(n-1);
        }
    }
}