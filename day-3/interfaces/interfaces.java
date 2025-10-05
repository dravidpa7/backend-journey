// multiple inheritence 

interface Father {
    void call();
    void talk();
}

interface Mother {
    void call();
    void talk();    
}

public class interfaces implements Father,Mother{
    public void call(){
        System.out.println("Calling");
    }
    public void talk(){
        System.out.println("Talking");
    }
    public static void main(String[] args) {
        interfaces obj = new interfaces();
        obj.call();
        obj.talk();
        
    }
}
