class threading{
    public static void main(String args[]){
        thread1 t1 = new thread1();
        Thread t = new Thread(t1);
        t.start();
    }
}
class thread1 implements Runnable{
    public void run(){
        System.out.println("calling Sleep Method");
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println(e);
        }  
        System.out.println("Sleep Method finished");
    }
}