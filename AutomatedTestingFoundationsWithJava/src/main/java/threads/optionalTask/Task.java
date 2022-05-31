package threads.optionalTask;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private static final int RUNWAYS_COUNT = 5;
    private static final int PLAINS_COUNT = 10;
    
    public static void main(String[] args) {
        List<Runway> runways = new ArrayList<>();
        for (int i = 1; i <= RUNWAYS_COUNT; i++) {
            runways.add(new Runway(i));
        }

        List<Thread> planes = new ArrayList<>();
        for (int i = 1; i <= PLAINS_COUNT; i++) {
            planes.add(new Plane("Plane" + i, runways));
        }
        planes.forEach(Thread::start);
    }
}
