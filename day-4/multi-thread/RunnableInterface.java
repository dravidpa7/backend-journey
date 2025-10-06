class Desert {

}


class Cake implements Runnable{
    public void run(){
        System.out.println("Mixing Products : " + Thread.currentThread().getId());
        System.out.println("Baking : " + Thread.currentThread().getId());
        System.out.println("Deccorating Cake : " + Thread.currentThread().getId());
    }
    
}


public class RunnableInterface {
    public static void main(String[] args) {
        int cakeCount =4;
        for (int i = 0; i < cakeCount; i++) {
            Cake cake = new Cake();
            Thread newThread = new Thread(cake);
            newThread.start();
        }
       
    }
}


