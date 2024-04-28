package defs;

public class TestThreadRunnable {
    public static void main(String[] args) {
        StartStopDefs run1= new StartStopDefs();
        StartStopDefs run2= new StartStopDefs();
        Thread t1= new Thread(run1);
        t1.start();
//        Thread t2= new Thread(run2);
//        t2.start();
    }
}
