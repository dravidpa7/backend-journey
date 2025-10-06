class CakeCounter{
    int cakeCount = 0;

    public synchronized void increment(){
        cakeCount++;
    }
}

class Team implements Runnable{

    CakeCounter counter; 
    // CakeCounter counter = new CakeCounter();
    // using class Without creating Object

    Team(CakeCounter counter){
        this.counter = counter;
    }

    public void run(){
        for (int i = 0; i < 1000; i++) {
            counter.increment();   
        }
    }
}

public class SyncronizedKey {
    public static void main(String[] args) {

        CakeCounter counter = new CakeCounter();

        Thread team1 = new Thread(new Team(counter));

        Thread team2 = new Thread(new Team(counter));

        team1.start();
        team2.start();

        try {
            team1.join();
            team2.join();


        } catch (Exception e) {

        }

        System.out.println(counter.cakeCount);

    }
}




// Other version
// class CakeCounter {
//     int cakeCount = 0;

//     public void increment() {
//         // simulate a delay to increase the chance of overlap
//         int temp = cakeCount;
//         cakeCount = temp + 1;
//     }
// }

// class Team implements Runnable {
//     CakeCounter counter;

//     Team(CakeCounter counter) {
//         this.counter = counter;
//     }

//     public void run() {
//         for (int i = 0; i < 1000; i++) {
//             counter.increment();
//         }
//     }
// }

// public class SyncronizedKey {
//     public static void main(String[] args) throws InterruptedException {
//         CakeCounter counter = new CakeCounter();

//         Thread team1 = new Thread(new Team(counter));
//         Thread team2 = new Thread(new Team(counter));

//         team1.start();
//         team2.start();

//         team1.join();
//         team2.join();

//         System.out.println("Final cake count: " + counter.cakeCount);
//     }
// }
