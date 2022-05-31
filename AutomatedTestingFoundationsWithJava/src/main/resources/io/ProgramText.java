package main.fundamentals.mainTask;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        System.out.printf("Hello %s!", scanner.nextLine());
        scanner.close();
    }
}
