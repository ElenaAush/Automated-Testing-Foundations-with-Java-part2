package threads.mainTask;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Task4 {
    private static final Queue<Lot> lots = new LinkedList<>();
    private static final List<Thread> participants = new LinkedList<>();
    
    public static void main(String[] args) {
        lots.add(new Lot("book", 40));
        lots.add(new Lot("rose", 50));
        lots.add(new Lot("tobacco", 70));
        lots.add(new Lot("tea", 85));
        lots.add(new Lot("horse", 120));
        lots.add(new Lot("automobile", 300));
        lots.add(new Lot("ring", 315));
        lots.add(new Lot("necklace", 350));
        lots.add(new Lot("statue", 450));
        lots.add(new Lot("painting" , 500));
        Auction auction = new Auction(lots);

        participants.add(new Thread(new Participant("Jone", 3200, auction)));
        participants.add(new Thread(new Participant("Mary", 1500, auction)));
        participants.add(new Thread(new Participant("Steeve", 9000, auction)));
        participants.add(new Thread(new Participant("Ann", 5000, auction)));
        participants.forEach(Thread::start);
    }
}
