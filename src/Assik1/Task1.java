package Assik1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
            System.out.print("Enter a number: ");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            printDigits(n);
        }

        public static void printDigits(int n) {
            if (n < 10) {
                System.out.println(n);
            }
            else {
                printDigits(n/ 10);
                System.out.println(n % 10);
            }
        }
    }