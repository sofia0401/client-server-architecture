
public class Main {
    public static void main(String[] args) {
        final Object lock = new Object();
        PingPong ping=new PingPong("ping",lock);
        PingPong pong=new PingPong("pong",lock);

        Thread thread1 = new Thread(ping);
        Thread thread2 = new Thread(pong);
        thread1.start();
        thread2.start();
    }
}


class PingPong implements Runnable {

String p;
Object lock;

    PingPong(String p,Object lock) {
        this.p= p;
        this.lock=lock;
    }




    @Override
    public void run() {

            synchronized (lock) {

                while (true) {
                    System.out.println(p);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {

                        lock.notify();
                        lock.wait();

                    } catch (InterruptedException e) {
                    }
                }

        }
    }
}




