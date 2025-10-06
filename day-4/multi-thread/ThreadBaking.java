class Cake extends Thread{
    public void run(){
        System.out.println("Mixing Products" + Cake.currentThread().getId());
        System.out.println("Baking" + Cake.currentThread().getId());
        System.out.println("Deccorating Cake" + Cake.currentThread().getId());
    }
    
}


public class ThreadBaking {
    public static void main(String[] args) {
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}