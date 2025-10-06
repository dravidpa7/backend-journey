class Cake implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println(" Mixing : "+ Thread.currentThread().getName());

        } catch (Exception e) {
            System.out.println("Thread Exception");
        }
    
    }

}


public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {
        int cakeCount = 4;
        for (int i = 0; i < cakeCount; i++) {
            Cake obj = new Cake();
            Thread newThread = new Thread(obj);
            newThread.setName("Cake "+(i+10)); // set a own name
            newThread.start();

            // we can able to set Priorty min -1, nor -5 , max-10
            newThread.join();

            newThread.setPriority(Thread.MAX_PRIORITY);
            System.out.println(newThread.getPriority());

            System.out.println(newThread.isAlive());
            // try{
            //     newThread.join();
            // }catch(Exception e){

            // }

            // sleep Seprate Thread
            // if(i==1){
            //     try {
            //         Thread.sleep(2000);
            //     } catch (InterruptedException e) {
            //         e.printStackTrace();
            //     }
            // }

        }

        System.out.println("Outside For Loop");
        // System.out.println(1/0);

        Cake newCake = new Cake();
        Thread newThread1 = new Thread(newCake);

        newThread1.start();

        System.out.println("Thread is still Alive " + newThread1.isAlive());

    }
    
}


// | Step | Thread                           | Action                                                                                                                                      |
// | ---- | -------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- |
// | 1    | **Main Thread**                  | Starts execution of `main()`                                                                                                                |
// | 2    | **Main Thread**                  | Enters the `for` loop and starts 4 new threads                                                                                              |
// | 3    | **New Threads (t1, t2, t3, t4)** | They are *requested* to start, but scheduling is **not immediate**.                                                                         |
// | 4    | **Main Thread**                  | Immediately prints `"Outside For Loop"`                                                                                                     |
// | 5    | **Main Thread**                  | Executes `System.out.println(1/0)` → **ArithmeticException**                                                                                |
// | 6    | **Main Thread**                  | Terminates with an uncaught exception                                                                                                       |
// | 7    | **Child Threads**                | Continue executing their `run()` method (printing `"Mixing X"`) — may appear **before or after** the exception depending on CPU scheduling. |


// Why main thread finishes first

// Because the main thread is:

// much lighter (only prints text and divides numbers)

// doesn’t wait for others (join() not used)

// and can throw an exception that terminates it early.



//start() → join() → (thread already ended) → setPriority(10)
