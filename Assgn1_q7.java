import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        if (n == 0) {
            count = 1;
        } else {
            n = Math.abs(n);

            while (n != 0) {
                n = n / 10;
                count++;
            }
        }

        System.out.println(count);
    }
}
