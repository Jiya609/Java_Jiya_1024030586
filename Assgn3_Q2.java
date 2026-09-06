public class Main {

    public static void main(String[] args) {

        try {

            System.out.println("Outer try started");

            try {

                System.out.println("Inner try started");

                int a = 10;
                int b = 0;

                System.out.println(a / b);

            }
            catch (NullPointerException e) {

                System.out.println(
                    "Inner catch: NullPointerException"
                );
            }

            System.out.println("Back to outer try");

            int[] arr = {10, 20, 30};

            System.out.println(arr[5]);

        }
        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                "Outer catch: ArrayIndexOutOfBoundsException"
            );
        }

        System.out.println("Program completed.");
    }
}
