import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.print("Enter a number to calculate the factorial: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(factorial(n));
    }
    public static int factorial(int n){
        if(n<=1){
            return 1;
        }
        return n * factorial(n-1);
    }
}