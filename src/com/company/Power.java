package com.company;
import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int y = scan.nextInt();

        int result = 1;

        for (int i = 0; i < y; i++) {
            result = result * x;
            System.out.println(result);
        }
        System.out.println(result);
    }
}