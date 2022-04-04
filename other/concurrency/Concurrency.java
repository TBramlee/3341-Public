public class Concurrency {

    static int counter;
    static Object lock = new Object();
    public static void main(String[] args) {
        MyObj myObj= new MyObj();
        MyThread t1 = new MyThread(myObj);
        MyThread t2 = new MyThread(myObj);
        t1.start(); //starts running thread concurrently
        t2.start();
        try {
            t1.join(); //main thread will wait for child thread to finish
            t2.join();
        }
        catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        
        System.out.println("Counter = " + myObj.counter);
      
    }
}

class MyThread extends Thread {

    MyObj myObj;
    MyThread(MyObj myObj) { this.myObj = myObj;}

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (myObj) { //acq lock
                myObj.counter++;
            } //release lock
        }
        
    }
}

class MyObj {
    int counter;
}