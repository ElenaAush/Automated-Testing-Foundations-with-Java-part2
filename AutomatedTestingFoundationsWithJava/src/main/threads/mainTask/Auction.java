package main.threads.mainTask;

import java.util.Queue;
import java.util.concurrent.*;

public class Auction extends Thread {
    private volatile boolean isOpenAuction;
    private Queue<Lot> lots;
    private int treasury;
    
    private Phaser phaser;
    private Exchanger<Integer> payment;
    private BlockingQueue<Lot> lotForSale;
    private volatile boolean onSale;
    private volatile String nameWinner;
    private volatile int newLotPrice;
    private final int TIME_WAITING = 3000;
    
    public Auction(Queue<Lot> lots) {
        this.lots = lots;
        
        phaser = new Phaser();
        phaser.register();
        payment = new Exchanger<>();
        lotForSale = new LinkedBlockingQueue<>(1);
        start();
    }
    
    public boolean isOpenAuction() {
        return isOpenAuction;
    }
    
    public Phaser getPhaser() {
        return phaser;
    }
    
    public Exchanger<Integer> getPayment() {
        return payment;
    }
    
    public BlockingQueue<Lot> getLotForSale() {
        return lotForSale;
    }
    
    public synchronized boolean isLotOnSale() {
        return onSale;
    }
    
    public String getNameWinner() {
        return nameWinner;
    }
    
    public void setNameWinner(String nameWinner) {
        this.nameWinner = nameWinner;
    }
    
    public int getNewLotPrice() {
        return newLotPrice;
    }
    
    public synchronized void addNewPrizeLot(int bid) {
        newLotPrice += bid;
    }
    
    public int getTIME_WAITING() {
        return TIME_WAITING;
    }
    
    @Override
    public void run() {
        try {
            prepareAuction();
            System.out.println("---The auction start!---");
            open();
            while (lots.size() > 0) {
                Lot lot = lots.remove();
                conductLotTrading(lot);
                finishLotTrading(lot);
            }
            close();
            System.out.println("---Auction is over!---");
            TimeUnit.MILLISECONDS.sleep(TIME_WAITING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void open() {
        isOpenAuction = true;
    }
    
    private void close() {
        isOpenAuction = false;
    }
    
    private void prepareAuction() throws InterruptedException {
        System.out.println("Preparations for the auction are underway...");
        System.out.println("Lots for the auction are ready.");
        System.out.println("Waiting for participants...");
        while (true) {
            if (phaser.getRegisteredParties() > 3) {
                break;
            }
        }
        sleep(100);
        phaser.arrive();
    }
    
    private void conductLotTrading(Lot lot) {
        int initialPrice = lot.getPrice();
        System.out.println(" ");
        System.out.println("Lot №" + phaser.getPhase() + " : " + lot.getName() + ", starting price " + initialPrice);
        System.out.println("Start lot trading!");
        newLotPrice = initialPrice;
        while (true) {
            if (allPassOrOneWinner()) {
                onSale = true;
                break;
            }
        }
    }
    
    private boolean allPassOrOneWinner() {
        return (phaser.getRegisteredParties() - 1 == phaser.getArrivedParties())
                || (phaser.getUnarrivedParties() == 2 && nameWinner != null);
    }
    
    private void finishLotTrading(Lot lot) throws InterruptedException {
        if (nameWinner == null) {
            lot.setPrice(newLotPrice - 10);
            lots.add(lot);
            System.out.println("lot will come later (" + lot.getName() + ')');
        } else {
            int initialPrice = lot.getPrice();
            lot.setPrice(newLotPrice);
            lotForSale.add(lot);
            System.out.println("waiting to pay...");
            
            sellOrReturnLot(lot, initialPrice);
            nameWinner = null;
        }
    
        newLotPrice = 0;
        onSale = false;
        phaser.arriveAndAwaitAdvance();
    }
    
    private void sellOrReturnLot(Lot lot, int initialPrice) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(TIME_WAITING);
        
        if (lotForSale.peek() == null) {
            treasury += payment.exchange(null);
            System.out.println("lot sold! (" + lot + " - " + nameWinner + ')');
        } else {
            lot = lotForSale.remove();
            lot.setPrice(initialPrice);
            lots.add(lot);
            System.out.println(nameWinner + " didn't pay for lot");
        }
    }
}
