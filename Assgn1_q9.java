import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int base = sc.nextInt();
        int exponent = sc.nextInt();

        long result = 1;

        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }

        System.out.println(result);
    }
}
