package main.threads.mainTask;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {
    private final String name;
    private int balance;
    private final Queue<Lot> purchases;
    private final Auction auction;
    
    private final Phaser phaser;
    private final int BID = 10;
    
    public Participant(String name, int balance, Auction auction) {
        this.name = name;
        this.balance = balance;
        purchases = new LinkedList<>();
        this.auction = auction;
        
        phaser = auction.getPhaser();
        phaser.register();
    }
    
    @Override
    public void run() {
        try {
            readyToBargain();
            while (auction.isOpenAuction()) {
                bargainForLot();
                payOrPass();
                TimeUnit.MILLISECONDS.sleep(100);
            }
            showStateParticipant();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void readyToBargain() throws InterruptedException {
        System.out.println(name + " joined the auction");
        while (phaser.getPhase() < 1) {
            phaser.arriveAndAwaitAdvance();
        }
        Thread.sleep(10);
    }
    
    private void bargainForLot() throws InterruptedException {
        int ownPrizeLotForPay = 0;
        int time;
        
        while (!auction.isLotOnSale()) {
            synchronized (auction) {
                int prizeLot = auction.getNewLotPrice();
                
                if (ownPrizeLotForPay == prizeLot) {
                    continue;
                }
                
                time = thinkOut(3500);
                if (balance < prizeLot + BID || time >= auction.getTIME_WAITING()) {
                    System.out.println(name + ": -skip");
                    break;
                }
                
                ownPrizeLotForPay = becomeWinner(prizeLot);
            }
            TimeUnit.MILLISECONDS.sleep(time);
        }
    }
    
    private int thinkOut(int lastTime) {
        return ThreadLocalRandom.current().nextInt(900, lastTime);
    }
    
    private int becomeWinner(int prizeLot) {
        int newPrizeLot = prizeLot + BID;
        System.out.println(name + ": " + newPrizeLot + '!');
        auction.setNameWinner(name);
        auction.addNewPrizeLot(BID);
        return newPrizeLot;
    }
    
    private void payOrPass() throws InterruptedException {
        if (!Objects.equals(auction.getNameWinner(), name)) {
            phaser.arriveAndAwaitAdvance();
            return;
        }
        getLotOrHavePunish();
    }
    
    private void getLotOrHavePunish() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(thinkOut(1000));
        if (auction.getLotForSale().peek() != null) {
            Lot lot = auction.getLotForSale().remove();
            purchases.add(lot);
            balance -= lot.getPrice();
            auction.getPayment().exchange(lot.getPrice());
            phaser.arriveAndAwaitAdvance();
        } else {
            phaser.arriveAndAwaitAdvance();
            int numberOfSuspensionsFromLots = 2;
            while (auction.isOpenAuction() && numberOfSuspensionsFromLots > 0) {
                if (auction.getNewLotPrice() != 0) {
                    System.out.println(name + " no participant");
                    numberOfSuspensionsFromLots--;
                    phaser.arriveAndAwaitAdvance();
                }
            }
        }
    }
    
    private void showStateParticipant() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(10);
        synchronized (Participant.class) {
            System.out.println();
            System.out.println("* " + name);
            System.out.println("balance " + balance);
            if (purchases.size() == 0) {
                return;
            }
            System.out.println("-");
            for (Lot lot : purchases) {
                System.out.println(lot.toString());
            }
        }
    }
}
