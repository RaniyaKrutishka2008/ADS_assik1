import java.util.Scanner;
public class Task3 {

    public static void main(String[] args) {
        System.out.print("Enter a number to check if it is a prime: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 2){
            System.out.println("Not Input");
            return;
        }
        if (isPrime(n, 2)){
            System.out.println("Prime");
        }else {
            System.out.println("Composite");
        }
    }
    public static boolean isPrime(int n, int m){
        if (m*m > n){
            return true;
        }
        if (n%m == 0){
            return false;
        }
        return isPrime(n, m+1);
    }
}
