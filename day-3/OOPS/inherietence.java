class animal {
    int noLegs=4;

    public static void eat(){
        System.out.println("Eating");
    }
    public static void walk(){
        System.out.println("walk");
    }
}

class dog extends animal {
    boolean bark = true;

}

public class inherietence {
    public static void main(String[] args) {
        animal obj = new animal();
        obj.eat();
        dog obj2 = new dog();
        System.out.println(obj2.bark);
    }

    
}
