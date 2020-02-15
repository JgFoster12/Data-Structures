package ch02;

import java.util.Scanner;

public class PostfixDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = null;
        Postfix postfic = new Postfix("5 7 + 6 2");

        System.out.println(postfic.postFixOperations(" 5 7 + 6 2 - *"));
    }
}
