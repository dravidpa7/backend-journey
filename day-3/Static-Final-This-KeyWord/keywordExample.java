import java.util.Scanner;
// java.util - collection of classes 

class father{
    int age = 30;
    // static final char gender = 'M';
    static char gender ='M';
    final void print(){
        System.out.println("Parent class Method gender  M  " );
    }
}

class daughter extends father{

    // can not able to overried because it is final
    // void print(){
    //     System.out.println("Child class Method ");
    // }
    int age = 12 ;
    char gender = 'F';
    void parentprint(){
        System.out.println(super.age);
    }
}

class grandChild{
    int x,y;
    // this keyword used for same name in instance and parameter variable 
    void add(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class keywordExample {
    public static void main(String[] args){
        // father.print();
        father.gender = 'F';  // i have used final so i can't able to change, It is constant
        //after using static in data Member
        System.out.println("After Static class gender "+ father.gender);

        daughter obj = new daughter();
        obj.print();

        obj.parentprint();

        Scanner  sc = new Scanner(System.in);
        int a = sc.nextInt();

        // next line - Whole line 
        // sc.next() we get - hello from hello world
        // used sc.nextLine() - we get hello world
        // next float
        // get first char sc.next().charAt(0)
        System.out.println(a);
    }
}