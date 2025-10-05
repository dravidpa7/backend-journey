abstract class computer {  // abstract class cannot create obj -> cannot instentiated
    void turnOn(){
        System.out.println("Turning On");
    }

    abstract void turnoff();
}

class HP extends computer{
    void turnOn(){
        System.out.println("Turning On 1 HP");
    }

    void turnoff(){
        
    }
}

public class abstractExample {
    public static void main(String[] args) {
        HP obj = new HP();
        obj.turnOn();
    }
}