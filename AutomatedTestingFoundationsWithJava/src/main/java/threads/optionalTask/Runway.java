package threads.optionalTask;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runway {
    private final int number;
    private final Lock lock = new ReentrantLock();
    
    public Runway(int number) {
        this.number = number;
    }
    
    public boolean tryLock() {
        return lock.tryLock();
    }
    
    public void unlock() {
        lock.unlock();
    }
    
    public void departure(String namePlane) throws InterruptedException {
        System.out.println("Полоса " + number + " приняла самолет " + namePlane);
        TimeUnit.MILLISECONDS.sleep(10);
        System.out.println("Самолет " + namePlane + " начал выход на полосу " + number);
        TimeUnit.SECONDS.sleep(3);
        System.out.println(namePlane + " взлетел");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Полоса " + number + " освободилась");
    }
}
