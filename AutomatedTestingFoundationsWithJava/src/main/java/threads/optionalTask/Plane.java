package threads.optionalTask;

import java.util.List;

public class Plane extends Thread {
    private final String name;
    private final List<Runway> runways;
    
    public Plane(String name, List<Runway> runways) {
        this.name = name;
        this.runways = runways;
    }
    
    @Override
    public void run() {
        Runway runway = bookRunway();
        try {
            runway.departure(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            runway.unlock();
        }
    }
    
    private Runway bookRunway() {
        while (true) {
            for (Runway runway : runways) {
                if (runway.tryLock()) {
                    return runway;
                }
            }
        }
    }
}
