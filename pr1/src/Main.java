
public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        Ping ping=new Ping(game);
        Pong pong=new Pong(game);
        Thread thread1 = new Thread(ping);
        thread1.start();
        Thread thread2 = new Thread(pong);
        thread2.start();
    }
}

class Game {
    boolean flag= false;
    public synchronized void ping() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        flag = true;
        System.out.println("ping");

        notify();
    }


    public synchronized void pong() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        flag = false;
        System.out.println("pong");

        notify();
    }



}
class Ping implements Runnable{

    Game game;
    Ping(Game game) {
        this.game=game;
    }

    @Override
    public void run() {
        while (true) {
            game.ping();
        }
    }

}

class Pong implements Runnable{

    Game game;
    Pong(Game game) {
        this.game=game;
    }

    @Override
    public void run() {
        while (true) {
            game.pong();
        }
    }
}