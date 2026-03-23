import java.util.Scanner;

public class Task6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число и степень: ");
        int a = sc.nextInt();
        int n = sc.nextInt();

        System.out.println("Результат: " + power(a, n));
    }

    public static int power(int a, int n) {

        if (n == 0) {
            return 1;
        }
        // a^n = a * a^(n-1)
        else {
            return a * power(a, n - 1);
        }
    }
}