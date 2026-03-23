import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String str = sc.nextLine();

        System.out.println("Количество символов: " + countChars(str));
    }
    public static int countChars(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        else {
            return 1 + countChars(str.substring(1));
        }
    }
}