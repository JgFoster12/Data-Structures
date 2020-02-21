package ch04;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        testMethod();

    }

    public static void testMethod(){
        Scanner scanner = new Scanner(System.in);
        ArrayBoundedQueue arrayBoundedQueue = new ArrayBoundedQueue();
        ArrayUnboundedQueue arrayUnboundedQueue = new ArrayUnboundedQueue();

        int choice;
        String message;

        System.out.println("Welcome to the interactive test driver!");
        System.out.println("Choose a constructor: \n1: ArrayBoundedQueue \n2: ArrayBoundedQueue(int maxSize)");
        choice = scanner.nextInt();

        while(true){

            switch(choice){
                case 1:
                    menu(arrayBoundedQueue);
                    break;

                case 2:
                    menu(arrayUnboundedQueue);
                    break;
            }
        }
    }

    public static void menu(QueueInterface q){
        Scanner scanner = new Scanner(System.in);
        int operationsMenuChoice;
        System.out.println("Choose an operation to perform.\n......." +
                "\n1: enqueue(element)" +
                "\n2: String dequeue()" +
                "\n3: boolean isFull()" +
                "\n4: boolean isEmpty()"+
                "\n5: int size()"       +
                "\n6: Quit testing"
        );

        operationsMenuChoice = scanner.nextInt();
        switch (operationsMenuChoice){
            case 1:
                int element;
                System.out.println("Enter the element you'd like to enqueue");
                element = scanner.nextInt();
                q.enqueue(element);
                System.out.println("Added " + element + " to the queue.");
                System.out.println(q.size());
                break;
            case 2:
                System.out.println("Dequeued: " + q.dequeue());
                break;
            case 3:
                System.out.println(q.isFull());
                break;
            case 4:
                System.out.println(q.isEmpty());
                break;
            case 5:
                System.out.println("The size of the queue is: " + q.size());
                break;
            case 6:
                System.out.println("Ending the test... ");
                System.exit(0);
        }


    }
}
