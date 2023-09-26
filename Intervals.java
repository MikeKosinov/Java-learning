import java.util.Scanner;

public class Intervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N(start of interval):");
        int n = sc.nextInt();// Start of interval
        System.out.println("Enter M(end of interval):");
        int m = sc.nextInt();
        System.out.println("Enter K (number for check):");
        int k = sc.nextInt();

            if (k > n && k <= m) {
                System.out.println(k + " in interval (" + n + ", " + m + "]");
            } else {
                System.out.println(k + " doesn't in interval (" + n + ", " + m + "]");
            }

            if (k > n && k < m) {
                System.out.println(k + " in interval (" + n + ", " + m + ")");
            } else {
                System.out.println(k + " doesn't in interval (" + n + ", " + m + ")");
            }

            if (k >= n && k < m) {
                System.out.println(k + " in interval [" + n + ", " + m + ")");
            } else {
                System.out.println(k + " doesn't in interval [" + n + ", " + m + ")");
            }

            if (k >= n && k <= m) {
                System.out.println(k + " in interval [" + n + ", " + m + "]");
            } else {
                System.out.println(k + " doesn't in interval [" + n + ", " + m + "]");
            }
    }
}
