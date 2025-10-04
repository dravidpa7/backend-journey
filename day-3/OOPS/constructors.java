class sample{
    int rollno;
    int mark ;

    sample(int x, int y){
        rollno = x;
        mark = y;
    }
}

// methods we can call multiple times 
// in constructors we will not able to do multiple time, it done only in object creation

public class constructors {
     public static void main(String[] args) {
        sample obj = new sample(12,98);

        System.out.println(obj.rollno);
        System.out.println(obj.mark);
     }
}
