public class Task1 {

    public static void printDigits(int n) {
        if (n < 0) {
            System.out.println("-");
            printDigits(-n);
            return;
        }
        if (n < 10) {
            System.out.println(n);
        }
        else {
            int a = n / 10;
            int b = n % 10;
            printDigits(a);

            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        printDigits(5481);
    }
}
