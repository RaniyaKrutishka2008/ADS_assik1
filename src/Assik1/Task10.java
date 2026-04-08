package Assik1;

import java.util.Scanner;

public class Task10{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//
        System.out.print("Введите два числа через пробел: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Наибольший общий делитель (НОД): " + gcd(a, b));
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
}