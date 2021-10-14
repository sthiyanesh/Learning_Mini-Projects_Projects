class MyThread extends Thread {
    String name;
    MyThread (String thread){
        name = thread;
        System.out.println("New thread: " + thread);
        this.start();
    }
    public void run() {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }
        System.out.println(name + " exiting.");
    }
}     
class MultiThread {
    public static void main(String args[]) {
        MyThread t1 = new MyThread("One");
        MyThread t2 = new MyThread("Two");
        try {
            Thread.sleep(100);
            System.out.println("Is Thread 1 Running:"+t1.isAlive());
            System.out.println("Is Thread 2 Running:"+t2.isAlive());
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}