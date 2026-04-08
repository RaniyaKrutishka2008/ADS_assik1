package Assik1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.print("Enter a number of elements, and the list of them: ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> list = InputNumbers(sc, n, new ArrayList<>());

        System.out.println("The average of the numbers is: ");

        int totalSum = Sum(n, list);

        double average = (double) totalSum / n;

        System.out.print(average);
    }

    public static ArrayList<Integer> InputNumbers(Scanner sc, int n, ArrayList<Integer> list) {
        if (n == 0) {
            return list;
        }
        list.add(sc.nextInt());
        return InputNumbers(sc, n - 1, list);
    }

    public static int Sum(int n, ArrayList<Integer> list) {

        if (n == 0) {
            return 0;
        }

        return list.get(n - 1) + Sum(n - 1, list);
    }
}