package Assik1;

import java.util.Scanner;

public class Task7{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Введите количество элементов: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Введите элементы:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.print("Результат в обратном порядке: ");
    reversePrint(arr, n - 1);
  }
  public static void reversePrint(int[] arr, int index) {
    if (index < 0) {
      return;
    }

    System.out.print(arr[index] + " ");

    reversePrint(arr, index - 1);
  }
}